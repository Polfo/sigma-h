

# Introduction #

This page is targeting the potential student candidates to work on the Sigmah project as part of the Sigmah or Google Summer of Code 2015 programme.
It provides context about the Sigmah project and above all ideas for them to build their project from. Those ideas have been collected from Sigmah users working in humanitarian NGOs. They represent their short-term priorities for new features in their software.



# Sigmah project #
## The project and its current users ##
**[Sigmah](http://www.sigmah.org/) is open source software for the shared  management of international aid projects**.

Available in 3 langues (English, French, Spanish) version 1.2 is currently in adoption by [8 NGOs](http://www.sigmah.org/node/503) **like Médecins du Monde, French Red Cross or Handicap International**.

On the [forum of the project](http://www.sigmah.org/node/84), users in Haiti, France, Pakistan or Afghanistan report new needs of features frequently because project is still young, and the [roadmap](http://www.sigmah.org/issues/roadmap_page.php) of the project keeps growing.

[Video of the future developments planned](http://dai.ly/unUu0y) at the time of Sigmah launch conference in June 2011 ([original French version](http://dai.ly/vJHc5i)).

## Technical details ##
Sigmah software is developed in Java using GWT + ExtJS. Access to database is done with Hibernate. Sigmah application forge is available at https://github.com/sigmah-dev/sigmah. Sigmah application is a very large and rich application. A strong effort to learn how to work on it is absolutely necessary. Don't expect to be able to do anything meaningful before one month of full time work to get easy with all functional and technical concepts. But.. if you like big challenges, you'll definetly get a rewarding one with this application!


## Sigmah project and SoC2015 ##
For Summer of Code 2015, Sigmah will be represented by  [Groupe URD](http://www.urd.org/), functional project leader which will play the role of organization administrator.
This year, Sigmah project runs its own Sigmah Summer of Code programme, with tights with the application we will make for Google Summer of Code.
For better understanding of the link between Sigmah Summer of Code and Google Summer of Code, please read [this wiki page chapter](https://code.google.com/p/sigma-h/wiki/SigmahSummerOfCode?ts=1423209627&updated=SigmahSummerOfCode#1.3_Sigmah_Summer_of_Code_/_Google_Summer_of_Code:_what_differen).


## Resources for new contributors ##
After having taken a look to potential projects you may have on Sigmah, if you want to know more, you can join the **#sigmah channel on irc.freenode.net** (people will be idling around mostly during French business hours). Or as many open-source project, you can use the following resources more or less in the given order:
  1. Take a look at the [Sigmah User Guide](http://www.sigmah.org/print/book/export/html/219) to have a better idea of what the software is about, and at the [demo](http://demo.sigmah.org/) to know how it looks like.
  1. Go through the draft [Contributor Guide](http://code.google.com/p/sigma-h/wiki/ContributorGuide) on the [forge](http://code.google.com/p/sigma-h/) wiki of the project to better understand how the project id technically set up, and how you can concretely work on it.
  1. Install your own development environment and download your copy of the source code by following [this procedure](http://code.google.com/p/sigma-h/wiki/Building) (on the Contributor Guide as well).
  1. If ready to dive, send an "hello world!" on [sigmah-dev mailing list](http://groups.google.com/group/sigmah-dev) to start collaborating with other developers !

# Project ideas #

This project ideas list is just given as a suggestion. As written in the introduction, those ideas do however represent the short-term priorities of real users working in humanitarian NGOs. When describing a project idea, a _User Priority_ is attributed to each feature request associated with it, to reflect its importance in the eyes of the users.

But user priority might not be SoC volunteer priority... A new important feature requested urgently by some users may be felt as boring to develop by a SoC volunteer. We just give those _User priority_ because we believe that an exciting thing about contributing to Sigmah is that you're helping real users to work more efficiently in their daily work at managing humanitarian projects, and knowing where your help would be the most appreciated by users might be useful.

As a consequence, if a student wants to write its own proposal by mixing some of those projects or taking some inspiration from the [project roadmap](http://www.sigmah.org/issues/roadmap_page.php), he's also welcomed to do so.

Finally, for each project idea, we provide a _Development Difficulty_ level to give an hint about how easy or challenging it would be to deal with this idea.


## Project idea 1: Sigmah project for better coordination ##

_Project Difficulty:_ Hard

_This project is a continuation and extension of the project started during summer 2014._

**Presentation**

When a natural disaster strikes a country, coordination between humanitarian organisations is always an issue. Several solutions already exist and make the situation not as bad as it could be, but there remain a lot of room for improvement. One of latest initiative regarding this complex challenge is the HXL project which aims to use the power of Linked Data to quickly share knowledge and information for better coordination. This Humanitaran eXchange Language (HXL) project is in a new phase. Sigmah definely wants to support this HXL initiative objective!

Basically, this project will involve three major steps:
  1. developing a new "Map" sub-tab in the Project screen to manage geographical information and pin the project position on a map, and provide several other information according to the HXL standard **Done during summer 2014!**
  1. develop the concept of "framework", which is conceptually in Sigmah a kind of meta-model ;
  1. handle the export of data in the HXL format through a framework called "HXL"



**Examples**

_User Prority:_ 1

This project idea corresponds to feature requests:
  * [0000106: User interface to manage quality frameworks](http://www.sigmah.org/issues/view.php?id=106) which must be readapted to match the full framework concept
  * [0000630: HXL export](http://www.sigmah.org/issues/view.php?id=630)


**Impact**

Impacts of this feature are many: better coordination for the humanitarian sector, possibility to build maps of projects by organisations for their own websites, possibility to build maps of projects using Sigmah in the world, etc.

**Knowledge prerequisite**

Java/GWT.



## Project idea 2: From a standalone project data collection tool to an integrated project management and analysis platform ##

_Project Difficulty:_ Hard

_Difficulty comment_: Hard project idea because it will require a deeper knowledge of the purpose and behavior of the whole software.

_This project is a continuation and extension of the project started during summer 2013._

**Presentation**

In its version 1.2, Sigmah works as a tool to collect and organize data about projects. It is already useful, but too limited for wider adoption in the NGOs. Sigmah must integrate itself better in NGOs information system, and provides more means to analyze the data it helps to collect.

The lack of integration with other software used by NGOs has for result many cases of double data-entry and loss of efficiency.
Users are happy with information-sharing abilities of Sigmah but frustrated not to be able yet to analyze all this information collected. And with stronger capacity of analysis of all information collected, humanitarian workers will be able to more easily learn lessons out of their experiences and improve that wat the quality of their work.

**Examples**

The request features which illustrate thie need to make Sigmah a real integrated project management and analysis platform are:

_User Prority:_ 1

  * [0000389: Organizational Unit aggregation field](http://www.sigmah.org/issues/view.php?id=389)
  * [0000530: New type of orgunit/project field: computation field](http://www.sigmah.org/issues/view.php?id=530)
  * [0000524: Dashboard projects table indentation](http://www.sigmah.org/issues/view.php?id=524)
  * [0000526: Base currency setting](http://www.sigmah.org/issues/view.php?id=526)

_User Prority:_ 2

  * [0000513: Budget Excel export improvement](http://www.sigmah.org/issues/view.php?id=513)
  * [0000515: New indicator aggregation method: last value](http://www.sigmah.org/issues/view.php?id=515)
  * [0000525: Filtered global export](http://www.sigmah.org/issues/view.php?id=525)

## Project idea 3: Easing deployments of Sigmah ##

**Presentation**

Right now, Sigmah can only be installed through a tedious procedure. Deployment of new version is not easy and we lack ways for users to report on the instances they install and thus provide means to convince donors to support the project they're using.

**Examples**

The 3 following feature requests give examples of features which could be developed:
  * [0000131: Sigmah installer](http://www.sigmah.org/issues/view.php?id=131) (installers should be available on Windows and Linux, and optionnaly Mac (secondary since there is no server running MacOS))
  * [0000125: Sigmah version update system](http://www.sigmah.org/issues/view.php?id=125)
  * [0000129: Sigmah instance registering system](http://www.sigmah.org/issues/view.php?id=129)
[Issue 129](https://code.google.com/p/sigma-h/issues/detail?id=129) is not linked with the objective to directly ease deployment, but is more linked with the long term objective to keep some donors interested by showing the usage of a more easily spread Sigmah.

Another work to be done is to develop means to easily install Sigmah on Ubuntu (collaboration with [Ubuntu-NGO](https://lists.launchpad.net/ubuntu-ngo/) team might be fruitful for that).

Possible technical solutions include:
  * Virtual Machine
  * NSIS
  * Java Web Start
  * IzPack.org
  * InnoSetup

**Impact**

With easier deployments facilities, organizations would be more able to try easily Sigmah on their own.

**Knowledge prerequisite**

Java/GWT.
Prior knowledge of installation technical solution(s) like NSIS would also be a plus.



## Project idea 4: Advanced project model and privileges management ##

_Project Difficulty:_ Medium

_This project is a continuation and extension of the project started during summer 2013._


**Presentation**

Sigmah's most fundamental feature is the flexibility it gives to organization in the way they can configure it. With this flexibility provided through project models and privileges management, organizations are able to design their project information system by themselves, through a graphical interface they're able to use and not by configuration files which scare them in most of the case.

Sigmah flexibility is already provided a great service to its users, but it needs to be enhanced to reply to new needs expressed by users.

**Examples**

Here is the list of feature requests or ideas as forum posts expressed by users to improve the project model and privileges system:

_User Prority:_ 1

  * [0000501: Group iterations](http://www.sigmah.org/issues/view.php?id=501)
  * [0000506: Projects visibility by attachment orgunit](http://www.sigmah.org/issues/view.php?id=506)
  * [0000509: Active Directory user authentication](http://www.sigmah.org/issues/view.php?id=509)
  * [0000511: Category modification flexibility](http://www.sigmah.org/issues/view.php?id=511)
  * [0000510: Interruption project phases](http://www.sigmah.org/issues/view.php?id=510)
  * [0000243: User attached to several OrgUnit](http://www.sigmah.org/issues/view.php?id=243)
  * [0000514: Hypertext link in field titles](http://www.sigmah.org/issues/view.php?id=514)


_User Prority:_ 2

  * [0000534: Field-linked reminders incentives](http://www.sigmah.org/issues/view.php?id=534)

**Impact**

By developing a project idea of that sort, the GSoC volunteer will contribute to allow new usages of Sigmah by its users. It will help Sigmah adoption in wider parts of organization already adopting it.


**Knowledge prerequisite**

Java/GWT.