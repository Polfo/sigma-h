## Version number rules ##
A good rule is to increment the minor version number (0.$.0) whenever database schema changes or any other breaking changes beyond a drop-in update.

## Version release process, and release candidates ##
Each sprint should have its own version number.

At the end of a sprint, result should be released as release candidate (rc). If the release candidate version if rejected, a new release candidate version has to delivered. And this processe loops until a release candidate is accepted.

For each release, both the software and the source code repository should be tagged with the version.

At the end of the process, when the release candidate is accepted, the software is released a last time with the final release number (without "rc`*`" in its version number), and the source code repository is tagged with the final version number as well.

In the issue tracker, release candidates are not followed independantly, and all tickets must be attached to the full version number associated with the sprint, not to the release candidate one.

### Typical scenario ###
  * Sprint 3 is planned to output version 0.6.3.
  * At the end of the sprint, the team delivers v0.6.3rc1 . Both the software and the source code repository are tagged with label "v0.6.3rc1".
  * A few minor bugs are detected in this version. Issue tracking tickets are not yet closed, and the team produces a few more commits linked to open tickets attached to targeted version 0.6.3 in the roadmap. The team delivers a new version v0.6.3rc2 . Both the software and the source code repository are tagged with label "v0.6.3rc2".
  * This version is finally accepted. The team delivers the final version v0.6.3 for this sprint, and both the software and the source code repository are tagged with the final label "v0.6.3".