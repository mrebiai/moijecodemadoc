project-new --named moijecodemadoc --topLevelPackage com.mrebiai.moijecodemadoc --type war --finalName moijecodemadoc;

jpa-new-entity --named MaDoc;
jpa-new-field --named repository;
jpa-new-field --named imageDir;
jpa-new-field --named pumlDir;
jpa-new-field --named code;
jpa-new-field --named result;

rest-setup ;
rest-generate-endpoints-from-entities --targets com.mrebiai.moijecodemadoc.model.MaDoc;

scaffold-setup --provider AngularJS ;
scaffold-generate --provider AngularJS --targets com.mrebiai.moijecodemadoc.model.MaDoc;

