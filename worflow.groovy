final def WORKSPACE_SUFFIX = "/jenkins_home/jobs/test-adoc/workspace";
final def WORKSPACE = "/srv" + WORKSPACE_SUFFIX;
final def LOCAL_WORKSPACE = "/var" + WORKSPACE_SUFFIX;
final def PROJECT_NAME = "mon-wiki";
final def GIT_PREFIX = "ssh://git@gitlab:22/bdxio/"+PROJECT_NAME;
final def GIT_REPO = GIT_PREFIX + ".git";
final def GIT_WIKI_REPO = GIT_PREFIX + ".wiki.git";
final def CREDENTIALS = 'xxxx';

stage name:'Clean workspace'; 
node {
 sh 'rm -rf *';
}

try {

  stage name:'CHECKOUT';   
  node {
    dir(PROJECT_NAME) {
      git credentialsId: CREDENTIALS, url: GIT_REPO, branch: 'master';
    }
    //dir(PROJECT_NAME+".wiki") {
    //  git credentialsId: CREDENTIALS, url: GIT_WIKI_REPO, branch: 'master';
    //}
    sh "git clone "+GIT_WIKI_REPO;
  }
 
  stage name:'Generate doc';
  node {
    def cmd1 = 'asciidoctor -r asciidoctor-diagram '+PROJECT_NAME+'/*.adoc -D ' + PROJECT_NAME+'.wiki/generated';
    def cmd2 = 'chmod -R a+w '+PROJECT_NAME+'.wiki/generated'; 
    sh 'docker run --rm  -v '+WORKSPACE+':/documents/ asciidoctor/docker-asciidoctor '+cmd1;
    sh 'docker run --rm  -v '+WORKSPACE+':/documents/ asciidoctor/docker-asciidoctor '+cmd2;
    // TODO update index.asciidoc
  }
  
  stage name:'Commit generated doc';
  node {
    dir(PROJECT_NAME+".wiki") {  
      //sh "git config user.name jenkins";
      //sh "git config user.email some@email.com";
      sh "git add -A .";
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
