# Introduction #

The Sigmah project is the fusion of:
  * ActivityInfo, a project monitoring system
  * Compas Dynamique, a quality management system developped by Groupe URD, and
  * Sigmh, a planned project management system, with funding from ECHO.

For all three systems, the central concept is the **Project** (UserDatabase in ActivityInfo).

The goal is to develop a single application that presents a unified experience to users. Any user can create a Project, and decide which aspects of the software to apply to the project:

  * Sigmah-MON : Definition of Logframe (Cadre Logique), data collection and entry of results, charting, mapping, of indicators. (ex ActivityInfo)
  * Sigmah-QUAL : Interactive guide to quality assurance on a project-by-project basis (ex Compas Dynamqiue)
  * Sigmah-PM : Manage funding sources, reporting deadlines, contracts, security incidents, etc

Over the course of the next year, Sigmah will benefit from two seperate funding sources:
  * UNICEF-DRC : Exclusive focus on Sigmah-MON, particularly data sharing and improved usability analysis features. Oriented towards an online information hub. BeDataDriven.com is the contractor.
  * ECHO : Broader focus on tools for NGOs. Groupe URD coordinates on behalf of working group of NGOs. Ideia.fr is the primary contractor, BeDataDriven provides additional work on foundation on Sigmah-MON components.

# Modularisation #

For maximizing productivity with GWT, it is preferable to keep SIGMAH as a single WAR, and a single maven module.

However, during the initial ECHO-contributions, it would be useful to compile two separate GWT modules Sigmah-Dev and Sigmah-Stable. The entry point for Sigmah-stable will include only the previous ActivityInfo components until the SIGMAH-QUAL and Sigmah-PM functionalities are ready.

# Roadmap #

Common release schedule?

## Preparation ##

The following steps need to be completed before the Sigmah-PM and Sigmah-QUAL domain objects can be added to the system

  * Migration of source repo to new project site (Alex: finished)
  * Documentation, cleanup of code (Alex: in progress)
  * Schema Migration - extension points
    * UserDatabase => Project
    * Partner => OrganizationalUnit (hierarchical)
    * PartnersInDatabase => ProjectMembership
  * SchemaDTO broken into `List<ProjectDTO>, LogFrameDTO, and CountryDTO` (the current design assumes a small number of projects per user)

## ECHO-Funded Sprints (Ideia.fr) ##

  * Iteration 1
    * Sprint 1
    * Sprint 2
    * Sprint 3
  * Iteration 2

## Components needed for Echo-financed Sigmah-MON requirements (Bedatadriven.com) ##

  * Logframe: the current model of Activity/Indicators needs to be enriched in order to meet the ECHO-financed monitoring requirements. TODO: embed Activity/Indicator in a hierarchy rather than list, improve logframe design component

  * Targets: Add support for targets for indicators

## UNICEF-Funded Sprints ##

  * Iteration 1 - begins 21st June - 23 July
  * Iteration 2
  * Iteration 3
  * Iteration 4



