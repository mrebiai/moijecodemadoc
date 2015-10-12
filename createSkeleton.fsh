project-new --named moijecodemadoc --topLevelPackage com.mrebiai.moijecodemadoc --type war --finalName moijecodemadoc;

jpa-new-entity --named MyDoc;
jpa-new-field --named code;
jpa-new-field --named result;

rest-setup ;
rest-generate-endpoints-from-entities --targets com.mrebiai.moijecodemadoc.model.MyDoc;

scaffold-setup --provider AngularJS ;
scaffold-generate --provider AngularJS --targets com.mrebiai.moijecodemadoc.model.MyDoc;

