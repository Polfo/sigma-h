## Introduction ##

This page gives the list of all operations to follow when relasing a new version of Sigmah.


## Release check list ##

  1. Check on the [Mantis\_Roadmap](http://www.sigmah.org/issues/roadmap_page.php) that you have resolved all the issue tickets of your version
  1. If your version has made changes in the database model, update the SchemaChangeLog wiki page accordingly
  1. Update the MinimumDataKit.zip and DemoData.zip sql bunch archives with the updated sql files (in PostGreSQL format) required by your version, and replace the old version of those files in the Downloads section of this forge
  1. Update the version number of Sigmah in the code with the appropriate version number (see the [Versioning](Versioning.md) rules for more details)
  1. Assure that all local changes are committed to SVN. If any changes are required to perform the build, they should incorporated into the POM.
  1. Release using the maven release plugin. From the command line or your IDE, execute the following goals in sequence:

```
mvn release:prepare
mvn release:perform
```

The maven release plugin will update the version numbers in the pom, tag  the current version, and deploy the artifact to the m2 repository.