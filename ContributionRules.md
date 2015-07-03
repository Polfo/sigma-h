# Introduction #

This page gathers all the rules and habits that have been taken by the contributors on the Sigmah code.
It is useful to read it as an introduction when joining the project, to be acknowledgeed of how to fit your contribution in the same trend, in order to keep the development and the final perception of the user homogeneous.
Later on, if you perceive explicitly a new habit or wants to describe an implicit rule, you're welcome to update this page !


# Rules for user perception #

  * Avoid to display in final release buttons or link to non-working or half-working part of the application: users will always get disappointed that something is not working yet.



# Rules on the code #
  * [Issue-tracking driven development](IssueTrackingDrivenDevelopment.md)
  * [Versioning](Versioning.md)



# Rules for coordination with translators #

  * "_Developers develop & translators translate_": In order to reduce the risks of conflict on the `UIConstants`, `UIMessages` and `MailModels` properties files, developers should avoid to edit the translated version of them. The French or Spanish developers can write the translation in their mothertongue of the new strings they create as part of the comment of the string in the original file.
    * In simpler words:
      * Developers only add new strings at the end of the `***.properties` files (without suffix) in the part dedicated to the version on which they work, and if possible always with a comment which may include the translation in the mothertongue for Spanish or French developers
      * Developers should not edit the `***_$$.properties` files (with suffix)
  * "_Give context to all my strings_": Translators **love** to have as much context as possible about what they have to translate, because it really helps their job. Thus, developers should try to add a comment (starting with the "#" character) on the line before **each** string they add. This comment should describe the string, and gives at best at least one screen in which it appears. It can also include the translation of the string in the mothertongue for French and Spanish developers.

  * "_I delete code, I check the constant strings_": Translators, as developers, don't like to work for no reason. So if a developer deletes some code containing an I18N string, and has a doubt whether this string is used anywhere else and could be deleted, he should check in ths code if this string is still used after his deletion. If it is no more used, it should be deleted.