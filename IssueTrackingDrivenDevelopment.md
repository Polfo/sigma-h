# Issue-tracking driven development #
"Issue-tracking driven development" could be summarized as "tell what you'll do, and do what you've told".

The rule is simple and straightforward:
**All commits should be linked with an issue in the issue tracker.**

## How to link commits with issues? ##
In order to ease this linkage process between the commit and the issue tracker, a script has been added. If strings like the following are included in the commit comment, the changeset of the commit will be automatically added to the issue details:
  * **`issue #45`** _(with a #, it also creates an hyperlink to the issue in the issue details)_
  * `issue 45`
  * `Issue 45`
  * `ISSuE #45` _(with a #, it also creates an hyperlink to the issue in the issue details)_
  * `issue 0000045`

## How to close an issue directly in the commit? ##
It is possible to mark an issue status as "resolved" and its resolution as "fixed" automatically by putting a string like the following in the commit comment:
  * **`fixes issue #45`** _(with a #, it also creates an hyperlink to the issue in the issue details)_
  * `Fixes issue 45`
  * `FIXES Issue 45`
  * `FiXeS ISSuE #45` _(with a #, it also creates an hyperlink to the issue in the issue details)_
  * `fixeS issue 0000045`