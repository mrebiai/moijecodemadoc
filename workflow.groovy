// A définir
final def PROJECT_NAME = "mon-wiki";
final def CREDENTIALS = 'xxxx';

// A ne pas modifier
def LOCAL_WORKSPACE;
node {
	LOCAL_WORKSPACE = pwd();
}
final def WORKSPACE = LOCAL_WORKSPACE.replaceFirst("/var", "/srv");
final def GIT_PREFIX = "ssh://git@gitlab:22/bdxio/"+PROJECT_NAME;
final def GIT_REPO = GIT_PREFIX + ".git";
final def GIT_WIKI_REPO = GIT_PREFIX + ".wiki.git";

stage name:'CLEAN'; 
node {
 sh 'rm -rf *';
}

try {
  stage name:'CHECKOUT';   
  node {
  	// scrutation sur ce repo uniquement pour relancer le build du job
    dir(PROJECT_NAME) {
      git credentialsId: CREDENTIALS, url: GIT_REPO, branch: 'master';
    }
    // pas de scrutation sur ce repo
    sh "git clone "+GIT_WIKI_REPO;
  }
  stage name:'GENERATE';
  node {
    // génération
    def cmd1 = 'asciidoctor -r asciidoctor-diagram '+PROJECT_NAME+'/*.adoc -D ' + PROJECT_NAME+'.wiki/generated';
    // mise à jour des droits pour pouvoir vider le workspace en fin de job
    def cmd2 = 'chmod -R a+w '+PROJECT_NAME+'.wiki/generated'; 
    sh 'docker run --rm  -v '+WORKSPACE+':/documents/ asciidoctor/docker-asciidoctor '+cmd1;
    sh 'docker run --rm  -v '+WORKSPACE+':/documents/ asciidoctor/docker-asciidoctor '+cmd2;
    // update index.asciidoc
    def output = "";  
    dir(PROJECT_NAME) {
      files = new File(pwd()).listFiles();
      for (f in files) {
        if (f.name.endsWith(".adoc")) {
        	output+="* link:generated/"+(f.name.substring(0, f.name.length()-5))+".html[]\n";
      	}
      }
    }
    dir(PROJECT_NAME+".wiki") {
      def fOutput = new File(pwd()+"/index.asciidoc");
      fOutput.write(output); 
    }
  }
  stage name:'PUBLISH';
  node {
    dir(PROJECT_NAME+".wiki") {  
      sh "git add .";
      sh "git commit -m 'commit generated doc'";
      sh "git push -u origin master";
    }
  }  
} finally {
  node {
    dir(LOCAL_WORKSPACE) {
      sh "rm -rf *";
    }
   }
}
