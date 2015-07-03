# Introduction #

## Historical background of a growing community ##
Sigmah project has started in 2009 with a group of humanitarian NGOs deciding to join their forces to reply to their project internal information management challenges. In 2010, the software development of the Sigmah application started to reply to those needs. Version 1.0 has been published in 2011 thanks to the funding get for the Phase 1 of this initiative, and the hard work of Ideia software service company which has been selected to become Sigmah main technical partner. In 2012, Sigmah project has been selected to participate to the Google Summer of Code programme for the first time and 2 new contributors have joined the community that way. And in 2013, it has participated once again and 3 contributors have worked all the summer on the project. Finally, every year, a new trainee has been hired by Ideia to contribute to the project.

We are now at the end of the year 2013, and it makes quite a lot of developers interested in the project, no need to mention all those who are knocking on the door once in a while telling they want to contribute!

Out of those summers of code and the usual traineeship period in France which is almost the same period, the activity level in our developer community is pretty low.

## Why a Sigmah Developer Community Summit? ##
The feeling some of us have is that our community is now big enough to structure a bit better the way we could all collaborate. Many of us have expressed the desire to contribute to the project out of a summer of code, but it just looks like we don't find the way how to.
And to do this structuring work, organizing a Sigmah Developer Community Summit seemed the best solution. In French, we would have called such an event "les Etats Généraux de Sigmah", which resonates with symbolism coming from the French revolution! (more information for those curious : http://en.wikipedia.org/wiki/Estates_General_%28France%29)

At the same time, we get a very big news for the Sigmah project: we have learned last month that we get a grant to fund the development of Sigmah version 2!! (more information about this: http://www.urd.org/Sigmah-Phase-2-the-project-changes ) This means that the Sigmah software will change a lot in the upcoming months. The offline mode will be developed for example during the first semester 2014. Several major new features will be added to Sigmah during the year 2014 and the beginning of 2015, thanks to the hard work of Ideia and the grant we get to fund their work. But many many features out of this core v2 list remain to be developed. As a consequence, we will need to coordinate the work of the Ideia team with the work of the volunteer team. This is another very important reason to have this Sigmah Developer Community Summit: to find a way to organize our work altogether.

During the last meeting of Sigmah Steering Cooperative (the open group of 11 NGOs which is leading the project), the idea of organizing this Summit has been approved. The Steering Cooperative has accepted to formerly grant new powers to the developer community which can now officially take initiatives on certain aspect of the project.

## Purpose of this wiki page ##
This wiki page has two joined purposes:
  * explain what is and how works the Sigmah Developer Community Summit 2014
  * keep track of all the conclusions of it


## Table of contents ##



# The Sigmah Developer Community Summit 2014 #

## Description ##
The objective of the summit is to open to debate several components linked to our developer community. The conclusion of those discussions should help us shift from an informal community to a more structured and efficient one.

The components of our community which are opened for debate are listed below in the "Discussions and decisions" part of this wiki page.

The final objective of this summit is dual: **to take shared decisions on all those components of our community, and to build an action plan to implement them**.


## Process ##

### Original process ###

#### Step 1: asynchronous debate ####

The first step of the summit will be to have a long month of "asynchronous debate". The debate will go from now until the online final meeting. They are asynchronous because they will be conducted only through our sigmah-dev mailing list and this wiki page.

The objective of this long period of asynchronous debate is to give to anyone the possibility to express himself about the topics of this summit. If we can't come to a conclusion in our asynchronous debate on a specific topic, we will conclude the debate during the online final meeting.

#### Step 2: online final meeting ####

The online final meeting will be the festive conclusion of the Sigmah Developer Community Summit, and the opening ceremony of the new structuring of our community. It will be used to conclude the debates on topics which haven't come to a conclusion. It will also be used to decide together which T-shirt design we find the best!

The exact time slot for our online final meeting will be decided through the following poll: http://framadate.org/studs.php?sondage=4hdasqu9r5xmy1z9 => date found: 5th of February

### Evolution of the process after the 5th of February online meeting ###
Participating to a debate only on each one scarce spare time can be difficult. Even if we get many positive feedbacks and ideas (thanks to all contributors !), we haven't managed to cover all the topics during the month and an half of "asynchronous debate". We had finally nonetheless on the 5th of February an online meeting even if it couldn't end this required Developer Community Summit process.

It has been accepted that the process of this Developer Community Summit should be modified as following:
  * end of the process: the process will no more end on a specific date, but will end once all the topics will have found a conclusive decision ;
  * the process will now mix debates and concrete work following a monthly rythm ;
  * each month, we will have an online meeting with chat on IRC about the topics which have become more mature to be covered, and this meeting will always be ended with a concrete action plan.

And the first Sigmah In-house Developer Community Online Meeting (SIDCOM#1) we had on 5th of February has been very productive! The page below has been modified to include the decisions and tasks decided during this meeting.


# Discussions and decisions #

## Community governance and communication channels ##
Since we have decided to strenghten the structure of our developer community, it would be good to agree together on the way we should take decisions together inside the Sigmah project.

### What will not change ###
**Sigmah is and will remain a user-centered project**. Users are leading this project through the Steering Cooperative. They feel this software is theirs. They feel empowered. As a consequence, many new users report that they like Sigmah because it really looks like as something designed for them. And many users also contributes easily to the project, feeling they are giving something to a common good designed for the humanitarian sector as a whole.

The Steering Cooperative keeps leading of the project. Groupe URD remains Sigmah Project Facilitator: the organization which implements the decisions of the Steering Cooperative.

### How to become a committer? ###
**Proposition**

A developer must provide successfully between 5 to 10 patches before becoming a committer. The number of patches required depends of the complexity of the issues they fix.

The decision to grant commit rights to a new developer is taken between Sigmah Project Facilitator (chosen by the Steering Cooperative, currently: Olivier Sarrat) and Sigmah Lead Developer (the most experienced developer, currently: Tom Miette).

**Discussion**

Is everybody OK with this process to grant commit right to a new developer?

### What could a developer project member do? ###

**Proposition**

A developer can pick up any issue in the roadmap and propose a fix for it. It is advised to choose one in the new release under development because these are the ones most expected by the end users, but a developer can choose to develop a feature or fix a bug which is considered less urgent.

To create a new feature in the issue list, a developer must have the agreement of the Sigmah Project Facilitator, because all new features must be linked with needs expressed by users. It is not because an idea is good that this idea will fit with what the users are expecting from their software. Of course, a developer can start a discussion on www.sigmah.org forum to discuss a feature idea with the users. The Sigmah Project Facilitator can help this process.

A developer can propose his service for any non-functional mission. For example: no need to have a formal approval of the Steering Cooperative to create a Virtual Machine to have more easily a developer environment.

**Discussion**

Would have anyone something to add in this proposition ?


### Monthly meetings and sprints ###

**Proposition**

We are all humans... we all know that most of us have difficulties to start doing something if we don't have a deadline for it.

The major developer community internal functioning innovation might be to structure a monthly rythm in our community life.
Each month, we might have a monthly meeting (on IRC to keep it light and with meeting minutes automatically produced) to decide what we should do for the following month. During the next meeting, each one having committed to complete a mission with his monthly precise objectives should give a feedback about his progress.


For each commitment made by someone, we have to find a "commitment peer" which will have check the progress of the commitment. This "commitment peer" should be someone not having a commitment during the month, or having finished in time his past month commitment.


I would add another idea: **small is beautiful!**. We should all take good care that each of us should commit to complete monthly missions which are compatible with his time free.. including rest! The fix of a trivial bug (like on line of code modified) or the committment to find and describe a possible solution to fix a complex issue is far better than no bug fix at all... and much much better than a commitment to finish to develop a super cool feature that the users will expect by the end of the month and will be very dissapointed not to have.

**Discussion**

Are you ok with this idea of monthly mission commitments?

And with the monthly meetings? On IRC?

## Community online tools ##

### A better task management through a new Issue Tracker: Redmine ###

**Proposition**

Some missions on the project are not linked with issues on the Sigmah application or the Sigmah website. For example: creating an independant Maven repository, going to a university to promote Sigmah for the next Sigmah Summer of Code programme, or creating a developer environment VM.

But if we agree on the idea to have monthly mission committment, we should have a tool to keep track of all those missions committments. And of course, it will occur that mission committments will be the fixing of an issue (either bug or feature)... so this tool which looks like a kind of project management tool should merge with an issue tracker.

Here are the features expected for this improved issue tracker:
  * due dates for issues or tasks to be able to register monthly committments
  * issues or tasks for non-software related topics (ex: translation, outreach, etc.)
  * an easy view on issues or tasks by monthly "sprint period" , to be able to monitor the current work
  * simpler issue statuses set than the one we have now: {"assigned", "resolved", "closed"} will be enough
  * simpler Priority and Severity statuses set than the one we have now: simplifications should be debated
  * the new issue tracker solution must contain all issues presently in Mantis (closed and open issues): the full migration is required
  * full and easy integration with Github
  * _a bonus but not a requirement:_ an intuitive and attractive interface: intuitive for non-IT contributors (translators, etc.), and attractive to motivate people to join


An open source tool which merge project management feature with issue tracking already exist, and it is called Redmine. To structure differently our community life, we could imagine to migrate from Mantis to Redmine.



**Discussion**

What is your opinion about it?
Are you ok with the new features to expect?
Would migrating to Redmine could be a solution?


**Decision**

The debate is still open on this topic. The idea to have monthly task committment is agreed and is actually tried for the month of February 2014. But we no decision is taken after SIDUCOM#1 between keeping and improving Mantis or migrating to Redmine to cover needs.

The proposition above has been completed to include a list of new features we should expect from our issue tracker. In the action plan decided during SIDUCOM#1, the Improved Mantis solution and the Redmine Migration solution will be both tested during February 2014 so that we will have a way to decide during SIDUCOM#2 which issue tracker we should use.


### Source code management: better management of branches with Git ###

**Proposition**

Our community is big enough to need to manage more easily branches than what can provide SVN source code management tool. During summer 2013, Tharindu had for example to create his own separate repo to manage his complex project during the whole summer. Many of us have request to move from SVN to Git which can be done luckily very easily.

If we agree to move from SVN to Git, the next question is: on which forge?
Having a central repository of all issues is something very important for the project. And if we move to Github, each fork will have its own issues. Maybe not the best solution.

**Discussion**

Is everybody ok to move to Git?

Which forge should we then use? Google Code with Git? Github? Our own Git server?? another forge???

**Decision**
Migration to Github has been decided by the community during SIDUCOM#1, after discussions on sigmah-dev.
Main remaining question is: how easy will be the integration between Mantis or Redmine and Github?

### A new wiki engine ###

**Proposition**

The current wiki on Google Code has several limitations. The main limitation might be that we cannot have public modification privilege. We must grant each one with modification privilege.
Some have expressed the idea to use DokuWiki. But we could also use MoinMoin (to facilitate the migration from Google Code wiki because it uses the same syntax) or MediaWiki.

**Discussion**

Who would support this project of wiki migration?

To which tool should we then migrate?

### Test cases platform ###

**Proposition**

So far, we use [wiki pages to write the test scenario](TestCases.md). This is a basic solution which works. But tools exist to write and follow up test scenario exist, and could be linked to our source code repository. Those tools could help us maybe to save time.

A list of functional test tools is available here: http://www.opensourcetesting.org/functional.php



**Discussion**

Who thinks we are mature enough to change our tool to manage test cases?

Which tool would you suggest?


## Design of the "Sigmah Summer of Code" programme ##

**Proposition**

A "Sigmah Summer of Code" (SSoC) programme is planned during one of the 2 following years. Here are the main reasons behind this programme:
  * One of the core purpose of this programme is to have replacement programme in case Google doesn't select us a year. Google always want to have some turn-over in Google Summer of Code, and even if we perform very well, we might have to leave our seat to another open source project for one or several years. If we like the idea of Summer of Code programme, we have to be prepared not being selected a year by Google.
  * The number of slots given by Google can be limited, and we have to reject students who would like nevertheless to participate during the summer. If we have a Sigmah Summer of Code umbrella programme, all students who want to contribute during the summer will be managed together and we will have a structure to follow up those we had to reject due to unsufficient slots.

Here is what we have imagined so far for having our own Sigmah Summer of Code:
  * Programme
    * SSoC starts before and ends at the same time as GSoC.
    * Rewards:
      * A Sigmah T-Shirt to be designed (should we customize this T-shirt with the name of the successful contributor?)
      * A recommendation letter
      * A new page on a new "Hall of Fame" section to be created on the www.sigmah.org website? (with a copy of the recommendation letter)
      * A "badge" proving the skills get during the SSoC: this badge would implement Mozilla OpenBadges programme http://openbadges.org/
    * SSoC is an umbrella programme: any student participating to a summer of code programme for Sigmah is considered part of SSoC, either benevolent or paid by GSoC.
  * Functioning and calendar
    * February: launch of the students and mentors recruitment
      * Students are recruited for both programmes: SSoC and GSoC, because we don't know yet if Google will select us
  * April: student selection
    * Rules regarding the double programme selection process:
    * Time involvment:
      * SSoC is a learning benevolent opportunity which is complimentary to studies. SSoC has to remain compatible with summer jobs or other student obligations. Half-time availability only is required for application to SSoC, which means approximatively 18 hours per week, like: one and half day during the week-end (12 hours) and 2 evenings of 3 hours during the week.
      * GSoC is a full-time well-paid job. Full-time availability is then required for GSoC, which means the equivalent of approximatively a minimum of 5 days of work at 7 hours per day (these are the French standards), and no more than 2 weeks of vacations during the 4 months of the programme
        * Student application:
      * Application deadline to SSoC is one week after the student application deadline for GSoC. If Sigmah is selected to GSoC, this will leave the opportunity for students not selected to GSoC to be selected for SSoC. Any student can naturally submit a proposal to SSoC before the deadline.
      * While applying to SSoC, the student can choose to submit a full-time or a half-time project. The size of the project can be revised according to selection to GSoC.
        * While applying to SSoC, a student has the right to say that he will only work with Sigmah during the summer if he gets selected for GSoC: Google has an ability to pay the students that we will never have, and money can be legitimately a part of the motivation to work for open source projects during the summer.
  * The rest of the programme is runned in a similar way as we do for GSoC: mentoring, evaluation, etc.


**Discussion**

Are you ok with the general idea to have a Sigmah Summer of Code as umbrella programme to GSoC?

Who would like to suggest a better name than "Sigmah Summer of Code" ??

Should students applying to SSoC only have another special reward that those applying to GSoC won't have? (just to reward specially those who work as benevolent)


## Sigmah T-shirt ! ##

**Proposition**

Having a T-Shirt for Sigmah has 2 purposes: to give the feeling to each community member to be a member of the community ;), and to promote Sigmah while wearing it.

Sigmah T-shirt has to show Sigmah logo somewhere, and has to respect Sigmah project values: it must be made from organic cotton (to reduce the pollution of the soil and the water), and come from fair trade (to reduce the exploitation of workers).

For the rest, everything is open! Let's suggest design for T-shirt and use our final Sigmah Developer Community Summit online meeting to decide all together which design we will use. :)

_Dav Wise proposition_


![http://www.sigmah.org/_temp/tshirt/DavWise/DavWise%20-%20Sigmah%20Tshirt%20Design%20white%20-%20small.jpg](http://www.sigmah.org/_temp/tshirt/DavWise/DavWise%20-%20Sigmah%20Tshirt%20Design%20white%20-%20small.jpg)

![http://www.sigmah.org/_temp/tshirt/DavWise/DavWise%20-%20Sigmah%20Tshirt%20Design%20black%20-%20small.jpg](http://www.sigmah.org/_temp/tshirt/DavWise/DavWise%20-%20Sigmah%20Tshirt%20Design%20black%20-%20small.jpg)


**Discussion**

Should we have a fixed color for the T-shirt, or a different set of possible colors?

Should we have 2 kind of T-shirts? One for recognized contributors (committers, translators, adoption focal points inside NGOs, members of the Steering Cooperative, etc.), and a general one ?

Should we customize T-shirt given as reward to SSoC students?

Should we include a QR code on the T-shirt? If yes, pointing to which URL? www.sigmah.org or the Hall of Fame personal page of the developer wearing it?

Should we have only a unique and good-looking T-shirt which will be common to all?

Do you have any design to suggest? :)

## Promotion ##

**Proposition**

With a new governance and structuration, we will be ready to welcome more contributors inside our developer community. The Sigmah Summer of Code programme will also give us the possibility to welcome more people. But to attract more people, we need to inform them that Sigmah exists: this is called promotion.

Sigmah is already member of the [UN online Volunteer programme (\*UNV\*)](http://www.onlinevolunteering.org).

To promote the project, we could design a promotion package that any community member could us to promote the project inside his university for example.


**Discussion**

Are you ok with the idea of this promotion package?

Which other idea for promotion would you have?


# Tasks: Summit action plan #

To implement the decisions taken during this Sigmah Developer Community Summit, a lot of work have to be done. The following table describes all the tasks which have to be conducted to implement decisions of the Summit. The table also show progress in the completion of the tasks

| **Month** | **Task title** | **Responsible** | **Final result** | _**End of the month commitment**_ | _**Commitment required time**_ | **Task peer** | **Completion** |
|:----------|:---------------|:----------------|:-----------------|:----------------------------------|:-------------------------------|:--------------|:---------------|
| February  | Prepare a Github environment for Sigmah| osarrat         | At best, a Sigmah organization should be created on Github. If not possible, another should be found and discussed. | the solution for Sigmah presence on GitHub / For end of February. | ~1/2 day                       | _none_        | **completed**  |
| February  | UNV mission publication | osarrat         | A mission will be published on UNV website to look for volunteer wanting to participate in the SSoC programme, to work during the year with us, or to translate Sigmah. | The mission will be published before the end of February.  | 1/2 day                        | _none_        | **completed**  |
| February  | Mantis to Redmine migration test | pravin          | A fully workable Redmine test demo respecting all the requirements set above for the issue tracker. | The demo. / For end of February.  | ~5 full days                   | _none_        | in progress    |
| February  | Sigmah Mantis issue tracker improvement demo | tmiette         | A fully workable new and improved Mantis test demo respecting all the requirements set above for the issue tracker. | The demo. / For end of February.  | ~2 full days                   | _none_        | in progress    |
| February  | Developer Environment Installation procedure for dummies | tmiette         | A complete revision of the developer environment installation procedure, totally detailed, with screenshots, etc. | The procedure. / For end of February. | ~1 full day                    | _none_        | in progress    |
| February  | Feedbacks on Github | spM             | Feedbacks should be collected on Github trial so that we can take a decision altogether on migrating ot not, and how for the last details. | the feedbacks / For end of February. | ~1 day                         | _none_        | discarded      |
| March     | Google Code to Github migration | spM             | All Sigmah source code is managed through Github. | 1. test the hook between Github and the issue tracker selected (Mantis or Redmine) on demo repo and demo issue tracker (with a proof of success sent by email; 4. Perform the migration of the source code from SVN to Github; 5. set up a server-side hook with the issue tracker. | 2 days?                        | osarrat       | in progress    |
| March     | Google Code to Github migration | osarrat         | All Sigmah source code is managed through Github.  | 2. remove commit rights on Google Code for everybody to prevent any other commit ; 3. create a "sigmah" repository on the sigmah-dev Github org ; 6. invite all committers removed from Google Code to become committers on sigmah-dev Github org "sigmah" repo ; 7. replace in Mantis URL of SVN commits on Google Code by URL of Git commits on Github (can be done manually, because only 9 issues having lins to commits currently) | 1 day                          | _none_        | in progress    |
| March     | Data model modification procedure wiki page | aponcon         |                  |                                   |                                | osarrat       | in progress    |
| March     | Sigmah Developer Environment virtual machine + documentation on the wiki | aponcon         |                  |                                   |                                | osarrat       | in progress    |
| Unplanned | Google Code to MediaWiki migration | ?               | A running MediaWiki instance on wiki.sigmah.org with all the content of the current Sigmah Google Code wiki, with no transformation of the content.  | (i) A test MediaWiki instance with all the content of the current Sigmah Google Code wiki, with no transformation of the content. (ii) A procedure to reproduce easily the migration. | 2 full days ?                  |               |                |