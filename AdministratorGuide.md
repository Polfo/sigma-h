# Audience #

This guide is for those who wish deploy and run Sigmah on their own server.


# Required hardware #

To run a Sigmah Server, you will need to have a machine with the following requirements:


| **Application type** | Java web application (for information: 30Mb .war file) |
|:---------------------|:-------------------------------------------------------|
| **Server type**      | Java application server (Tomcat recommended but working also with Jetty) accepting Hibernate, or dedicated server |
| **Database type**    | The current version has been tested with PostGreSQL 9 and MySQL 5.5. It is possible to configure Sigmah to work with [other databases](http://community.jboss.org/wiki/SupportedDatabases), but these have not been tested and may not work. |
| **Processor**        | 2Ghz recommended, dual-core if possible                |
| **Live memory**      | 2Gb recommended                                        |
| **Hard drive**       | At least 50Gb, but depends strongly on the volume of data and files stored by the user of the organization |



# Guide to run and install Sigmah #
[Guide to run and install Sigmah](InstallingSigmah.md)

# Data separation #
[How to use the data separation scripts](DataSeparation.md)