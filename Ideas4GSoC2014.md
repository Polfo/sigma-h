

# Introduction #

This page is targeting the potential student candidates to work on the Sigmah project as part of the Google Summer of Code 2014 programme.
It provides context about the Sigmah project and above all ideas for them to build their project from. Those ideas have been collected from Sigmah users working in humanitarian NGOs. They represent their short-term priorities for new features in their software.



# Sigmah project #
## The project and its current users ##
**[Sigmah](http://www.sigmah.org/) is open source software for the shared  management of international aid projects**.

Available in 3 langues (English, French, Spanish) version 1.2 is currently in adoption by [8 NGOs](http://www.sigmah.org/node/503) **like Médecins du Monde, French Red Cross or Handicap International**.

On the [forum of the project](http://www.sigmah.org/node/84), users in Haiti, France, Pakistan or Afghanistan report new needs of features frequently because project is still young, and the [roadmap](http://www.sigmah.org/issues/roadmap_page.php) of the project keeps growing.

[Video of the future developments planned](http://dai.ly/unUu0y) at the time of Sigmah launch conference in June 2011 ([original French version](http://dai.ly/vJHc5i)).

## Technical details ##
Sigmah software is developed in Java using GWT + ExtJS. Access to database is done with Hibernate. Sigmah application forge is available at http://code.google.com/p/sigma-h/. Sigmah application is a very large and rich application. A strong effort to learn how to work on it is absolutely necessary. Don't expect to be able to do anything meaningful before one month of full time work to get easy with all functional and technical concepts. But.. if you like big challenges, you'll definetly get a rewarding one with this application!

Some of the projects listed below are linked with Sigmah community website. Sigmah community website is developed in PHP using Drupal, and its forge is available at https://github.com/osarrat/sigmah-website.

## Sigmah project and GSoC2014 ##
For Google Summer of Code 2014, Sigmah will be represented by  [Groupe URD](http://www.urd.org/), functional project leader which will play the role of organization administrator.


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

Finally, for each project idea, we provide a _Development Difficulty_ level to give an hint about how easy or challenging it would be to deal with this idea.

## Project idea 1: Sigmah project for better coordination ##

_Project Difficulty:_ Medium

**Presentation**

When a natural disaster strikes a country, coordination between humanitarian organisations is always an issue. Several solutions already exist and make the situation not as bad as it could be, but there remain a lot of room for improvement. One of latest initiative regarding this complex challenge is the HXL project which aims to use the power of Linked Data to quickly share knowledge and information for better coordination. This Humanitaran eXchange Language (HXL) project is in a new phase. Sigmah definely wants to support this HXL initiative objective!

Moreover, during GSoC Mentors Summit 2013, Sahana and Sigmah project have decided that they should develop a feature to share project location from the latter to the former because humanitarian free & open source software (HFOSS) must definetly show the way for better coordination! Some potential Sigmah users have recently also asked for better data exchange between both tools. This project idea is a consequently a **joint project between Sahana and Sigmah** ([link to related Sahana project idea](http://eden.sahanafoundation.org/wiki/Projects/Advanced#IntegrationwithSigmahusingHXL)), and has created a lot of positive expectations!

Basically, this project will involve two major steps:
- developing a new "Map" sub-tab in the Project screen to manage geographical information and pin the project position on a map, and provide several other information according to the HXL standard
- handle the export of data in the HXL format

The final expected output from this project idea will be a video demonstratinf the full scenario of interoperability between Sigmah and Sahana as described basically in this [Blueprint User Story](http://eden.sahanafoundation.org/wiki/BluePrint/HXL#SigmahtoSahana3W4Wdataexportation) on the Sahana wiki.


**Examples**

_User Prority:_ 1

This project idea corresponds to feature request [0000612: Project Map sub-tab for HXL export](http://www.sigmah.org/issues/view.php?id=612).


**Impact**

Impacts of this feature are many: better coordination for the humanitarian sector, possibility to build maps of projects by organisations for their own websites, possibility to build maps of projects using Sigmah in the world, etc.

**Knowledge prerequisite**

Java/GWT.



## Project idea 2: From a standalone project data collection tool to an integrated project management and analysis platform ##

_Project Difficulty:_ Hard

_Difficulty comment_: Hard project idea because it will require a deeper knowledge of the purpose and behavior of the whole software.

_This project is a continuation and extension of the project started during 2013._

**Presentation**

In its version 1.2, Sigmah works as a tool to collect and organize data about projects. It is already useful, but too limited for wider adoption in the NGOs. Sigmah must integrate itself better in NGOs information system, and provides more means to analyze the data it helps to collect.

The lack of integration with other software used by NGOs has for result many cases of double data-entry and loss of efficiency.
Users are happy with information-sharing abilities of Sigmah but frustrated not to be able yet to analyze all this information collected. And with stronger capacity of analysis of all information collected, humanitarian workers will be able to more easily learn lessons out of their experiences and improve that wat the quality of their work.

**Examples**

The request features which illustrate thie need to make Sigmah a real integrated project management and analysis platform are:

_User Prority:_ 1

  * [0000389: Organizational Unit aggregation field](http://www.sigmah.org/issues/view.php?id=389)
  * [0000515: New indicator aggregation method: last value](http://www.sigmah.org/issues/view.php?id=515)
  * [0000530: New type of orgunit/project field: computation field](http://www.sigmah.org/issues/view.php?id=530)

_User Prority:_ 2

  * [0000513: Budget Excel export improvement](http://www.sigmah.org/issues/view.php?id=513)
  * [0000484: Files field Excel export](http://www.sigmah.org/issues/view.php?id=484)

**Impact**

With more facilities to integrate Sigmah into the global IT system of humanitarian organizations, it will make humanitarian organizations more efficient and ease the process of adoption. By easing the process of analyzing information collected on projects, humanitarian NGOs will be able to better prepare their project and improve the way they reply to the needs of people. They will also be more efficient in the preparation of their work, with more time spend on building lessons out of their data than on manipulating and collecting it.

**Knowledge prerequisite**

Java/GWT.



## Project idea 3: Advanced project model and privileges management ##

_Project Difficulty:_ Medium

_This project is a continuation and extension of the project started during 2013._


**Presentation**

Sigmah's most fundamental feature is the flexibility it gives to organization in the way they can configure it. With this flexibility provided through project models and privileges management, organizations are able to design their project information system by themselves, through a graphical interface they're able to use and not by configuration files which scare them in most of the case.

Sigmah flexibility is already provided a great service to its users, but it needs to be enhanced to reply to new needs expressed by users.

**Examples**

Here is the list of feature requests or ideas as forum posts expressed by users to improve the project model and privileges system:

_User Prority:_ 1

  * [0000419: Project/orgunit models modifications with Available status](http://www.sigmah.org/issues/view.php?id=419)
  * Other ideas to improve privileges in the forum: http://www.sigmah.org/node/682 , http://www.sigmah.org/node/692 , http://www.sigmah.org/node/705 , http://www.sigmah.org/node/711
  * [0000534: Field-linked reminders incentives](http://www.sigmah.org/issues/view.php?id=534)
  * [0000438: Own password modification by user](http://www.sigmah.org/issues/view.php?id=438)
    * While developing this feature, a technical reply should be found for other issues regarding password as expression by users in the forum posts:http://www.sigmah.org/node/709 and http://www.sigmah.org/node/682#comment-347


_User Prority:_ 2

  * [0000501: Group iterations](http://www.sigmah.org/issues/view.php?id=501)

**Impact**

By developing a project idea of that sort, the GSoC volunteer will contribute to allow new usages of Sigmah by its users. It will help Sigmah adoption in wider parts of organization already adopting it.


**Knowledge prerequisite**

Java/GWT.

## Project idea 4: File upload improvement ##

_Project Difficulty:_ Easy

_Difficulty comment_: Project idea considered easy because this project might be to as wide to develop than others, but it will require a lot of imagination and creativeness to provide a lot of robustness and imagine all cases which might interrupt the connection. A good proposal on this project idea should demonstrate which kind of programmatic testing framework will be used to provide conditions with all kinds of extreme bad and impredictible connection. This framework should virtualize a network with all sort of cases. Maybe such a programmatic testing framework is not feasible, and then an alternative solution should be proposed.


**Presentation**

Attaching file in Sigmah is one of its core features. This feature must be very robust and user-friendly. And users having poor connection face some problems which make them reject the software.


**Examples**

Here is the list of feature requests expressed by users to improve the file upload system:

_User Prority:_ 1

  * [0000605: Background and robust uploading of files](http://www.sigmah.org/issues/view.php?id=605)
  * [0000592: Huge files can't be uploaded without proper information message to user](http://www.sigmah.org/issues/view.php?id=592)


**Impact**

With a robust and user-friendly file upload system, Sigmah adoption inside NGOs will be able to expand because its core feature will be much more responsive to their expectations.

**Knowledge prerequisite**

Java/GWT.