

# Introduction #
This page is the introduction point for potential student candidates to work on the Sigmah project as part of the Google Summer of Code 2012 program.


# Sigmah #
## The project and its current users ##
[Sigmah](http://www.sigmah.org/) is open source software for integrated project management within humanitarian NGOs. Available in 3 langues (English, French, Spanish) version 1.1 is currently in adoption by [8 NGOs](http://www.sigmah.org/node/503) like Médecins du Monde, French Red Cross or Handicap International.
On [forums of the project](http://www.sigmah.org/node/84), users in Haiti, France, Pakistan or Afghanistan report new needs of features every week because project is still young, and the [roadmap](http://www.sigmah.org/issues/roadmap_page.php) of the project keeps growing.
[Video of the future developments planned](http://dai.ly/unUu0y) at the time of Sigmah launch conference in June 2011 ([original French version](http://dai.ly/vJHc5i)).


## Next steps and sustainability ##
Sigmah is already in adoption by real users, and new organisations are showing up to start to adopt it.

The key of the sustainability of the Sigmah project is the many partnerships on which the project it is built (see the [Donors & economic model page](http://www.sigmah.org/node/55) of the Sigmah website for more information).


## Technical details ##
Sigmah software is developed in Java using GWT + ExtJS. Access to database is done with Hibernate. Sigmah application forge is available at http://code.google.com/p/sigma-h/. Sigmah application is a very large and rich application. A strong effort to learn how to work on it is absolutely necessary. Don't expect to be able to do anything meaningful before one month of full time work to get easy with all functional and technical concepts. But.. if you like big challenges, you'll definetly get a rewarding one with this application!

Some of the projects listed below are linked with Sigmah community website. Sigmah community website is developed in PHP using Drupal, and its forge is available at https://github.com/osarrat/sigmah-website.

## Sigmah project and GSoC2012 ##
For Google Summer of Code 2012, Sigmah will be represented by 2 organizations:
  * [Groupe URD](http://www.urd.org/), functional project leader, will play the role of organization administrator
  * [Ideia](http://www.ideia.fr/), technical project leader, will play of the mentor


## Resources ##
After having taken a look to potential projects you may have on Sigmah, if you want to know more, you can join the **#sigmah channel on irc.freenode.net** (people will be idling around mostly during French business hours). Or as many open-source project, you can use the following resources more or less in the given order:
  1. Take a look at the [Sigmah User Guide](http://www.sigmah.org/print/book/export/html/219) to have a better idea of what the software is about, and at the [demo](http://demo.sigmah.org/) to know how it looks like.
  1. Go through the draft [Contributor Guide](http://code.google.com/p/sigma-h/wiki/ContributorGuide) on the [forge](http://code.google.com/p/sigma-h/) wiki of the project to better understand how the project id technically set up, and how you can concretely work on it.
  1. Install your own development environment and download your copy of the source code by following [this procedure](http://code.google.com/p/sigma-h/wiki/Building) (on the Contributor Guide as well).
  1. If ready to dive, send an "hello world!" on [sigmah-dev mailing list](http://groups.google.com/group/sigmah-dev) to start collaborating with other developers !

# Project ideas #

This project ideas list is just given as potential contribution. If a student wants to write its own proposal by mixing some of those project or taking some inspiration from the [roadmap](project.md), he's free to do so.

## Project 1: From collection to analysis of NGO projects information ##
**Presentation**

So far, version 1.1 is good for information collection and sharing. Users are happy but frustrated to not be able yet to analyze all this information collected. And with stronger capacity of analysis of all information collected, humanitarian workers will be able to more easily learn lessons out of their experiences and improve that wat the quality of their work.

**Examples**

There are several new information analysis features which are have been requested by users. The 3 main ones by order of increasing complexity are:
  * [0000388: Export to Excel](http://www.sigmah.org/issues/view.php?id=388)
  * [0000389: Organizational Unit aggregation field](http://www.sigmah.org/issues/view.php?id=389)
  * [0000213: Custom exports](http://www.sigmah.org/issues/view.php?id=213)

**Impact**

By easing the process of analyzing information collected on projects, humanitarian NGOs will be able to better prepare their project and improve the way they reply to the needs of people. They will also be more efficient in the preparation of their work, with more time spend on building lessons out of their data than on manipulating and collecting it.

**Knowledge prerequisite**

Java/GWT.

## Project 2: From a standalone project management application to integrated project management platform ##

**Presentation**

In its version 1.1, Sigmah doesn't offer any possibilities for integration with other software used by NGOs. This situation has for result may cases of double data-entry and loss of efficiency.

**Examples**

To give the possibility of the application to be called for many services by webservice.
To provide import for financial data (like specified in [0000387: Importing financial data](http://www.sigmah.org/issues/view.php?id=387).

**Impact**

With more facilities to integrate Sigmah into the global IT system of humanitarian organizations, it will make humanitarian organizations more efficient and ease the process of adoption.

**Knowledge prerequisite**

Java/GWT.

## Project 3: Easing deployments of Sigmah ##

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
  * NSIS
  * Java Web Start
  * IzPack.org
  * InnoSetup

**Impact**

With easier deployments facilities, organizations would be more able to try easily Sigmah on their own.

**Knowledge prerequisite**

Java/GWT.
Prior knowledge of installation technical solution(s) like NSIS would also be a plus.



## Project 4: a full wiki for Sigmah online manual ##

**Presentation**

On the Sigmah community website, there is already all the content of the [user guide](http://www.sigmah.org/node/219), which can be exported for printed manual as well as contextual help in the application. But the way to work on it is not yet efficient enough to encourage users to easily edit it.

**Examples**

Automatic revision should be added to the online manual ([0000310: No automatic revision on modification of a user guide](http://www.sigmah.org/issues/view.php?id=310)) as well as display of the diff between revisions of manual pages ([0000311:Showing diff of revisions](http://www.sigmah.org/issues/view.php?id=311)). An integration and way to encourage Sigmah users to edit the manual from Sigmah application could also be imagined.

**Impact**

The targeted impact is to provide all means to start a culture of community-managed user manual.


**Knowledge prerequisite**

Drupal is a prerequisite.
Java/GWT is required if the proposal takes into consideration the integration from the application.


## Project 5: Improving tools for inner governance of the project ##
**Presentation**

Sigmah project is runned by a "Steering Cooperative" of so far 11 NGOs. New organizations how their interest, but soon we won't be able to tackle the challenge to manage a big group of organizations at top of the project. We need to update our main tool which is the community website to deal with this situation.

**Examples**

A private mailing list user group system with mailing archives only available to members of the Steering Cooperative should be added to the community website ([0000373: Add discussion list management for Steering Cooperative mailing list](http://www.sigmah.org/issues/view.php?id=373)). The mailing list should keep a low traffic so that members don't feel overwhelmed. For higher traffic communication, a forum is used so far. But the functioning of this forum should be made simpler: easy integration of images, possibility to use list of items, blockquote when responding to messages, etc.

**Impact**
To help to build the memory of the decision-making process of the project.


**Knowledge prerequisite**

Drupal.