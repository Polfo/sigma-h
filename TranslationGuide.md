# Introduction #

Some lessons have been learnt while translating Sigmah internationalization files, and this wiki page is here to share them for new translators.

Sigmah is using the Pootle online software translation platform for translation. Our Pootle server is located at **http://pootle.sigmah.org/**

_After two years of kind free hosting on Sahana HFOSS own Pootle server, we have shifted to our own server because the latest 2.5 Pootle version they migrated to is buggy with Java .properties based projects. Thanks Sahana again for those 2 years of kind hosting! Our Poootle server remains with old 2.1.5 version._

# Guidelines for translators #

## Pootle User manual ##
The community of the Liferay project has written a good introduction guide for Pootle. You can read the following and replace each word "Liferay" by "Sigmah" and you'll get a user manuel !

**[Pootle User manual](http://www.liferay.com/community/wiki/-/wiki/Main/Translating+Liferay+using+Pootle)**for project Liferay

## Lessons learnt for translators ##
  1. **Validate initial "fuzzy" translations** When starting the translation of a new version of the software in an already existing language (ie: translation of Sigmah v2.0 in Spanish which reuses the translation of Sigmah v1.2), the translators should in most cases validate all the translations marked as "fuzzy". Those translations are marked as fuzzy due to some technical reasons while importing all the translations from the previous versions. So, those translations should not be revised because the users are used to the former translations, and the user guide has been written using the former translation.
  1. **In doubt for a translation? _Solution 1_** Look at the string code (the text written at the top of your string translation box in very small font), it could give you an hint about what exactly is the usage of the string you have to translate (ie: the string "Calendar" has for code "projectTabCalendar", so the translator can get that this word is used for the tab named "Calendar" in a project page).
  1. **In doubt for a translation? _Solution 2_** Write a comment, and send your translation as "Fuzzy" ("Approximatif" in French). If the software release on which you're working is not planned to be a public one, you can also add the string number as a suffix to your translation to see where this string is used in Sigmah.
  1. **No simple quote (') in the UIMessages and MailModels files**: applies to `MailModels` and `UIMessages` files, and does not apply to `UIConstants` files. We know, it is not obvious and natural when you're typing... but the exported file from Pootle won't do the job for you, and if you don't enter the simple quote by pairs ('' instead of ' (ie: -window''s title- instead of -window's title-)), the file generated from your translation will break the build. Of course, your file will be controlled before being used in the code, but two controls are always better than only one. :)
  1. Don't set "My Account > Settings > Number of rows" to a value more than 16. Due to a bug in Pootle, if your number of rows exceeds the number of strings in one translation file, Pootle won't be able to open to you the screen for some strings of that short file. In Sigmah, the `MailMessages` file contains only 16 strings, so you can't have the "My Account > Settings > Number of rows" to a value greater than 16.


# Guidelines for Pootle admin #
## Internationalization files location ##
The internationalization files are the following ones:
  * `src\main\resources\org\sigmah\client\i18n\UIConstants.properties`
  * `src\main\resources\org\sigmah\client\i18n\UIConstants_$$.properties`
  * `src\main\resources\org\sigmah\client\i18n\UIMessages.properties`
  * `src\main\resources\org\sigmah\client\i18n\UIMessages_$$.properties`
  * `src\main\resources\org\sigmah\server\mail\model\MailModels.properties`
  * `src\main\resources\org\sigmah\server\mail\model\MailModels_$$.properties`

For understanding the difference between the files with a language code suffix ("`_$$`" stands for "`_es`", "`_fr`", etc.), see [Rules for coordination with translators](http://code.google.com/p/sigma-h/wiki/ContributionRules#Rules_for_coordination_with_translators).

## Source strings removal ##
Do not remove source strings from the property files. Static analysis via the Java will safely identify unused methods in the UIConstants and UIMessages interfaces. Removal of unused methods should be conducted periodically by the development team.

## File upload ##
The management of the file upload, in the "Overview" tab of the language translation project, can be quite tricky and is not very intuitive in the first place.

A good general lesson to remember is: "**a `*`.properties file for first importation, and XLIFF generated file for second one**".

### Files importation order ###
The first importation of a file in a language takes as granted that you send this file as a new source file in the original language for this new translation project. The name of the file has to be strictly the same as the potential similar one in other language, in order to let translators be able to see translations of a string in all available languages. You have to go to the "Files" tab of the language translation project and click on "Rescan project files" to actually process this source file.

All second importations are taken as importation of translations, if similar file name exist, and no more as import of source file, whatever the option used for importation.

### Update source strings of a translation project ###
_NB: since you need to use the command "Review the project's files" in the procedure to update the source strings of a file, you always need to update the strings of all the files of a translation project because this command has effect on all files of the project and can put the other files of your project in an incoherent status._

To update source strings of a translation project, the following procedure has to be used:
  1. Export as XLIFF all the files of your translation project (with the command "Translate offline" in the "Review" tab of the translation project)
  1. Delete all the files of your translation project (action available in the "Files" tab of the translation project)
  1. Import your new version of the source files containing the new source strings (with the file upload available in the "Overview" tab of the translation project, and any option can be used for the upload as it is a first importation)
  1. Analyze your imported files (with the command "Review the project's files" in the "Files" tab of the translation project)
  1. Import then your just generated XLIFF files with the option "Merge", and force the upload to the new source files you've just added.


## Importing files from translators into the code ##
Things to take in mind:
  * For all language except English, rename the `*.properties` exported files from Pootle with the suffix of the target language (`_fr`, `_es` so far).
  * Check that the `UIMessages` and `MailModels` files exported from Pootle do not contain any simple quote (') (or triple quotes...) which is not doubled (this does not apply to `UIConstants`). Each simple quote should be preceded by a second one ('' instead of ' (ie: -window''s title- instead of -window's title-)). Two solutions for that:
    * In Pootle, you can use the "singlequoting" option of the "Review" tab of your translation project to see faster all strings which have translated with a different number of single quotes. But this solution actually works poorly...
    * In your advanced text editor (like Notepad++), you can search for any single/triple quote with this regular expression: `(^['][^']|[^'][']$|[^']['][^']|''')`
  * Check that the `UIMessages` files have all required parameters. Easiest almost exhaustive solution for this check is to search for all `{1}` in the files: if there is a {1} without a {0} in the same string, it should be corrected.
  * An update of your working copy of the source code is naturally required.
  * Check for potential conflicts with the current copy in the source code repository.