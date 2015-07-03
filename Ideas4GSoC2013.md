

# Introduction #

This page is targeting the potential student candidates to work on the Sigmah project as part of the Google Summer of Code 2013 programme.
It provides context about the Sigmah project and above all ideas for them to build their project from. Those ideas have been collected from Sigmah users working in humanitarian NGOs. They represent their short-term priorities for new features in their software.



# Sigmah project #
## The project and its current users ##
**[Sigmah](http://www.sigmah.org/) is open source software for the shared  management of international aid projects**.

Available in 3 langues (English, French, Spanish) version 1.1 is currently in adoption by [8 NGOs](http://www.sigmah.org/node/503) **like Médecins du Monde, French Red Cross or Handicap International**.

On the [forum of the project](http://www.sigmah.org/node/84), users in Haiti, France, Pakistan or Afghanistan report new needs of features frequently because project is still young, and the [roadmap](http://www.sigmah.org/issues/roadmap_page.php) of the project keeps growing.

[Video of the future developments planned](http://dai.ly/unUu0y) at the time of Sigmah launch conference in June 2011 ([original French version](http://dai.ly/vJHc5i)).


## Next steps and sustainability ##
Sigmah is already in adoption by real users, and new organisations are showing up to start to adopt it.

The key of the sustainability of the Sigmah project is the many partnerships on which the project it is built (see the [Donors & economic model page](http://www.sigmah.org/node/55) of the Sigmah website for more information). During this summer, through a partnership established between **French Red Cross and Google France**, an UX Designer from Google will for example design the graphical layout of several features of the GSoC volunteer projects.


## Technical details ##
Sigmah software is developed in Java using GWT + ExtJS. Access to database is done with Hibernate. Sigmah application forge is available at http://code.google.com/p/sigma-h/. Sigmah application is a very large and rich application. A strong effort to learn how to work on it is absolutely necessary. Don't expect to be able to do anything meaningful before one month of full time work to get easy with all functional and technical concepts. But.. if you like big challenges, you'll definetly get a rewarding one with this application!

Some of the projects listed below are linked with Sigmah community website. Sigmah community website is developed in PHP using Drupal, and its forge is available at https://github.com/osarrat/sigmah-website.

## Sigmah project and GSoC2013 ##
For Google Summer of Code 2013, Sigmah will be represented by  [Groupe URD](http://www.urd.org/), functional project leader which will play the role of organization administrator.


## Resources for new contributors ##
After having taken a look to potential projects you may have on Sigmah, if you want to know more, you can join the **#sigmah channel on irc.freenode.net** (people will be idling around mostly during French business hours). Or as many open-source project, you can use the following resources more or less in the given order:
  1. Take a look at the [Sigmah User Guide](http://www.sigmah.org/print/book/export/html/219) to have a better idea of what the software is about, and at the [demo](http://demo.sigmah.org/) to know how it looks like.
  1. Go through the draft [Contributor Guide](http://code.google.com/p/sigma-h/wiki/ContributorGuide) on the [forge](http://code.google.com/p/sigma-h/) wiki of the project to better understand how the project id technically set up, and how you can concretely work on it.
  1. Install your own development environment and download your copy of the source code by following [this procedure](http://code.google.com/p/sigma-h/wiki/Building) (on the Contributor Guide as well).
  1. If ready to dive, send an "hello world!" on [sigmah-dev mailing list](http://groups.google.com/group/sigmah-dev) to start collaborating with other developers !

# Project ideas #

This project ideas list is just given as a suggestion. As written in the introduction, those ideas do however represent the short-term priorities of real users working in humanitarian NGOs. When describing a project idea, a _User Priority_ is attributed to each feature request associated with it, to reflect its importance in the eyes of the users.

But user priority might not be GSoC volunteer priority... A new important feature requested urgently by some users may be felt as boring to develop by a GSoC volunteer. We just give those _User priority_ because we believe that an exciting thing about contributing to Sigmah is that you're helping real users to work more efficiently in their daily work at managing humanitarian projects, and knowing where your help would be the most appreciated by users might be useful.

As a consequence, if a student wants to write its own proposal by mixing some of those projects or taking some inspiration from the [roadmap](project.md), he's also welcomed to do so.

## Project idea 1: A user-friendly reply to the need of flexible humanitarian projects ##

**Presentation**

Humanitarian projects are in some way like IT projects: they must be flexible. The needs of the populations for which they are conducted evolve in the time, some emergency or security situation may transform totally the feasibility of some of the planned activities. As a consequence, a project management system like Sigmah must let the possibility to let its users change their projects along they way, and keep tracks of those different versions. In the contractual world that link often humanitarian organisations with their public donors, those versions are usually linked with an Amendment. A first version of a amendment system has been set up in Sigmah version 1.0. But users have produce a lot of feedbacks on it to ask to change it deeply. Now, based on the experience they get with this first attempt to build a feature which is at the heart of Sigmah, we have a confirmed design of the feature they're expecting as a condition to fully adopt Sigmah in their whole organisations.

This complex and fundamental feature will be graphically designed by a UX Designer from Google working on the project through a French Red Cross - Google France partnership.

**Examples**

_User Prority:_ 1

This project idea corresponds to feature request [0000167: Revise Amendments system behavior](http://www.sigmah.org/issues/view.php?id=167).

A preliminary mockup of the desired behavior is available at [this URL](http://www.sigmah.org/issues/file_download.php?file_id=74&type=bug).  This mockup will be completely reviewed and can change totally in terms of graphic design with the help of the Google UX designer.

**Impact**

The current unsatisfying design of this feature makes it almost unused: with this new design which has been discussed a lot with users, Sigmah will be really able to provide to users the flexibility they need in their project, and the ease of use that produces a good versioning system.

**Knowledge prerequisite**

Java/GWT.


## Project idea 2: From a standalone project data collection tool to an integrated project management and analysis platform ##

**Presentation**

In its version 1.1, Sigmah works as a tool to collect and orgnize data about projects. It is already useful, but too limited for wider adoption in the NGOs. Sigmah must integrate itself better in NGOs information system, and provides more means to analyze the data it helps to collect.

The lack of integration with other software used by NGOs has for result many cases of double data-entry and loss of efficiency.
Users are happy with information-sharing abilities of Sigmah but frustrated not to be able yet to analyze all this information collected. And with stronger capacity of analysis of all information collected, humanitarian workers will be able to more easily learn lessons out of their experiences and improve that wat the quality of their work.

**Examples**

The request features which illustrate thie need to make Sigmah a real integrated project management and analysis platform are:

_User Prority:_ 1

  * [0000387: Importing data into fields](http://www.sigmah.org/issues/view.php?id=387)
  * [0000386: Flexible budget field](http://www.sigmah.org/issues/view.php?id=386)
  * [0000389: Organizational Unit aggregation field](http://www.sigmah.org/issues/view.php?id=389)
  * [0000515: New indicator aggregation method: last value](http://www.sigmah.org/issues/view.php?id=515)
  * [0000530: New type of orgunit/project field: computation field](http://www.sigmah.org/issues/view.php?id=530)

_User Prority:_ 2

  * [0000513: Budget Excel export improvement](http://www.sigmah.org/issues/view.php?id=513)

**Impact**

With more facilities to integrate Sigmah into the global IT system of humanitarian organizations, it will make humanitarian organizations more efficient and ease the process of adoption. By easing the process of analyzing information collected on projects, humanitarian NGOs will be able to better prepare their project and improve the way they reply to the needs of people. They will also be more efficient in the preparation of their work, with more time spend on building lessons out of their data than on manipulating and collecting it.

**Knowledge prerequisite**

Java/GWT.



## Project idea 3: Advanced project model and privileges management ##

**Presentation**

Sigmah's most fundamental feature is the flexibility it gives to organization in the way they can configure it. With this flexibility provided through project models and privileges management, organizations are able to design their project information system by themselves, through a graphical interface they're able to use and not by configuration files which scare them in most of the case.

Sigmah flexibility is already provided a great service to its users, but it needs to be enhanced to reply to new needs expressed by users.

**Examples**

Here is the list of feature requests or ideas as forum posts expressed by users to improve the project model and privileges system:

_User Prority:_ 1

  * [0000419: Project/orgunit models modifications with Available status](http://www.sigmah.org/issues/view.php?id=419)
  * [0000468: Advanced indicator management privileges](http://www.sigmah.org/issues/view.php?id=468)
  * [0000550: Advanced reminders management privileges](http://www.sigmah.org/issues/view.php?id=550)
  * [0000551: Advanced agenda management privileges](http://www.sigmah.org/issues/view.php?id=551)
  * [0000552: Advanced logframe management privileges](http://www.sigmah.org/issues/view.php?id=552)
  * Other ideas to improve privileges in the forum: http://www.sigmah.org/node/682 , http://www.sigmah.org/node/692 , http://www.sigmah.org/node/705 , http://www.sigmah.org/node/711
  * [0000534: Field-linked reminders incentives](http://www.sigmah.org/issues/view.php?id=534)
  * [0000337: Hide by default in Dashboard closed projects](http://www.sigmah.org/issues/view.php?id=337)
  * [0000438: Own password modification by user](http://www.sigmah.org/issues/view.php?id=438)
    * While developing this feature, a technical reply should be found for other issues regarding password as expression by users in the forum posts:http://www.sigmah.org/node/709 and http://www.sigmah.org/node/682#comment-347


_User Prority:_ 2

  * [0000147: Display reminders linked project code on dashboard](http://www.sigmah.org/issues/view.php?id=147)
  * [0000501: Group iterations](http://www.sigmah.org/issues/view.php?id=501)

**Impact**

By developing a project idea of that sort, the GSoC volunteer will contribute to allow new usages of Sigmah by its users. It will help Sigmah adoption in wider parts of organization already adopting it.


**Knowledge prerequisite**

Java/GWT.



## Project idea 4: Privacy for managing organizational internal support requests on Sigmah community website ##

**Presentation**

In order to maximize the mutualisation of support cases in the forum, all organizations adopting Sigmah should be encouraged to use Sigmah community website as their internal platform to manage support cases.

But, since user may need internally to exchange confidential information while explaining their support case, organizations using Sigmah community website for managing support cases should be able to deal with internal message privately and decide if and under what form should support cases message be shared publicly.

**Examples**

_User Prority:_ 1

This project idea corresponds to feature request [0000469: Private support](http://www.sigmah.org/issues/view.php?id=469).

**Impact**

This feature is really important to help foster a culture of contributions to the project from NGOs adopting Sigmah. Those who are familiar with open source project culture know that the idea to contribute to the community just even by sending a support request on the forum is not always natural. This project would help to foster this culture inside NGOs adopting Sigmah, and as a consequence will make Sigmah grow faster.

**Knowledge prerequisite**

PHP/Drupal.