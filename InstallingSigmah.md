# Table of contents #



# Introduction #

This installation guide describes the technical procedure to follow to install Sigmah.

If you want to install Sigmah just for a trial purpose, you might be interested to know that Sigmah has a live demo available at: http://demo.sigmah.org . You might also be interested to read about the the [Sigmah Central service](http://www.sigmah.org/organisational-use#sigmah_central) if you want to use Sigmah but are in doubt whether you have the human or financial capacities to maintain such a system.

This installation guide only covers installation of Sigmah both on a Windows and on a Linux (Ubuntu) platforms.


# Installing Sigmah on a Windows platform #

## Prerequisites ##

For better performance and security, it is recommended to maintain an installation environment for Sigmah with latest versions of the 3 key components it requires. Those components and the known minimum required version are:
  * **Java 1.8 and above**: visit http://www.java.com to download and get installation procedures for the Java runtime environment (if you have a 64bit environment, be sure to download a x64 version which will produce `Java HotSpot(TM) 64-Bit Server VM` in reply to `java -version`)
  * **PostgreSQL 9 and above**: download and run the One-click-installer available at http://www.postgresql.org/download/windows to get your copy of the PostgreSQL relational database management system (_tip_: when installing the database, give all the rights to your database user). For the rest of this procedure, we'll assume that the PostgreSQL database will be installed on same server as application server (database server name will be <font color='blue'><code>localhost</code></font>), and that to connect to the database man should use the default port number <font color='blue'><code>5432</code></font>. NB : it seems that Postgres doesn't worked properlly when installed on C:/Program Files (it seems better to install it at directly at the root C:/, especially on windows 7)
  * **Tomcat 7 and above**: download and get installation procedures of the Tomcat Java application server at http://tomcat.apache.org/index.html . NB : Sigmah does work also properly with Jetty application server



## Preparing the Sigmah database ##
  1. Download the MinimumDataKit zip file of the latest version of Sigmah at http://code.google.com/p/sigma-h/downloads/list .
  1. Create a new database on your PostgreSQL server (watch this [video to learn how to](http://www.youtube.com/watch?v=LR39-SWj87Q&feature=related)). For the rest of this procedure, we'll assume your database is called <font color='blue'><code>sigmah_db</code></font>. We'll also assume that to access this new database your database username is <font color='blue'><code>db_username</code></font>, and your database password is <font color='blue'><code>db_password</code></font>.
  1. Run all the files of the MinimumDataKit in this new `sigmah_db` database, in the order given by their filename.

## Installing Sigmah ##
  1. Download the webapp archive (`*`.war) of the latest version of Sigmah at http://code.google.com/p/sigma-h/downloads/list .

> 2. Create a folder in the `webapps` directory of your Tomcat installation. This folder will be used as context name for your Sigmah webapp. For the rest of this procedure, we'll assume that you've created a webapp folder named <font color='blue'><code>sigmah</code></font>. All paths, if the contrary is not explicitly specified, will be considered starting from the root of this `sigmah` folder.

> 3. Decompress the .war file into your just created `sigmah` folder.

> 4. Edit the file `WEB-INF/classes/META-INF/persistence.xml` and set the database parameters as the following for an installation using PostgreSQL as recommended: _(**Notice**: in v1.2 and earlier versions, the file to edit for database connection parameters was `WEB-INF/classes/sigmah.properties`)_

```
hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
hibernate.connection.driver_class=org.postgresql.Driver
hibernate.connection.username=db_username
hibernate.connection.password=db_password
hibernate.connection.url=jdbc:postgresql://localhost:5432/sigmah_db
hibernate.hbm2ddl.auto=update
hibernate.show_sql=false
hibernate.format_sql=false
```

> 5. Edit the file `WEB-INF/classes/sigmah.properties`, set the files management and mail parameters. Each folder set must of course exist before running Sigmah. Edit each key of the file as following:

| **Key** | **Supported versions** | **Description** |
|:--------|:-----------------------|:----------------|
|_`files.repository.name`_| 2.0 and later          |Root directory name where files will be stored (ie: `repository.name=C:\\Sigmah-files`)|
|_`archives.repository.name`_| 2.0 and later          |Root directory name where backup archives are stored. (ie: `repository.name=C:\\Sigmah-files\\archives`)|
|_`files.upload.maxSize`_| 2.0 and later          |Maximumum size of the uploaded files in bytes (default: 20971520 (20MB) ) |
|_`mail.hostname`_| 1.0 and later          |SMTP hostname used to send emails by the application. (ie: `mail.hostname=smtp.myngo.org`)|
|_`mail.port`_| 1.1 and later          |SMTP port used to send emails by the application. (ie: `mail.port=25`)|
|_`mail.from.address`_| 1.0 and later          |SMTP sender email address used to send emails by the application. (ie: `mail.from.address=sigmah@myngo.org`)|
|_`mail.from.name`_| 1.0 and later          |SMTP sender name as shown to recipient used to send emails by the application (ie:`mail.from.name=Sigmah`)|
|_`mail.auth.username`_| 1.1 and later          |Username in case of a required authentication when using the given SMTP server (ie:`mail.auth.username=sigmah`)|
|_`mail.auth.password`_| 1.1 and later          |Password in case of a required authentication when using the given SMTP server (ie:`mail.auth.password=sig42mah`)|
|_`mail.encoding`_| 2.0 and later          | Character encoding used in the emails generated by Sigmah (ie:`mail.encoding=UTF-8`)|
|_`mail.contentType`_| 2.0 and later          | Content type used in the emails generated by Sigmah (ie:`mail.contentType=text/html`)|
|_`mail.support.to`_| 2.0 and later          | E-mail address to which the `Report a bug` hyperlinks redirects to. (default:`mail.support.to=support@sigmah.org`)|
|_`maps.key`_| 2.0 and later          | Google Maps key |
|_`repository.images`_| 1.0 - 1.2              |Subfolder of the previous one where the organization's logos have to be stored. (ie: `repository.images=Images` would point to "_C:\Sigmah-files\_Images") (_**Notice**_: in v1.0, used to be the absolute path of a folder ; since 1.1, it is a relative path from the root folder specified in `repository.name`) (**deprecated**: removed since 2.0)|
|_`upload.maxSize`_| 1.2                    |Maximumum size of the uploaded files in bytes (**deprecated**: replaced by `files.upload.maxSize` since 2.0)|
|_`host.url`_| 1.1 - 1.2              |URL on which the Sigmah instance is running.This URL will be used widely on Sigmah. For example, we use the URL: `[host.url]/NewUserConfirm?userid1234/` to do the confirmation of new created user .**_Notice_**: Do not add any sign at the end. It should be like 'http://www.sigmah.org',not 'http://www.sigmah.org/'**. (**deprecated**: removed since 2.0)**|
|_`default.interface`_| 1.1 - 1.2              |Interface switch between Sigmah & ActivityInfo. This parameter MUST remain with value `default.interface=Sigmah`**. (**deprecated**: removed since 2.0)**|
|_`repository.file_storage_provider_class`_| 1.1 - 1.2              |Use `repository.file_storage_provider_class=org.sigmah.server.endpoint.file.LocalStorageProvider`, except if you install Sigmah on the Amazon platform. (**deprecated**: removed since 2.0) |
|_`repository.name`_| 1.1 - 1.2              |Root directory name where files will be stored (ie: `repository.name=C:\\Sigmah\\Files`) (**deprecated**: replaced by `files.repository.name` since 2.0)|
|_`repository.files`_| 1.0                    |Folder where the files uploaded by users will be stored. (ie: `repository.files=C:\\Sigmah\\Files`) (**deprecated**: replaced by `repository.name` since 1.1)|
|_`newUserConfirm.host.url`_| 1.0                    | URL used in the confirmation email sent to new users, to confirm their registration. (ie: `newUserConfirm.host.url=http://www.myngo.org:8080/sigmah/NewUserConfirm?`) (**deprecated**: replaced by `host.url` since 1.1) |

> (**deprecated**: step removed since v2.0) 6. Edit the file `WEB-INF/classes/sigmah.client.js` and replace the GoogleMapsAPI key by a one you've generated with your Google account at https://developers.google.com/maps/documentation/javascript/v2/introduction#Obtaining_Key

> (**deprecated**: step removed since v2.0) 7. Optionally, edit the file `WEB-INF/classes/log4j.properties` to specify your own path for the log file. If you want to do so, replace the value `activityinfo.log` of the key `log4j.appender.file.File` by the value you wish.

> 8. Start or reboot your Tomcat application server to make it deploy your new Sigmah webapp. To start the Tomcat application server, type the following command in the root folder of your Tomcat instance: `java -jar start.jar` (more information on web application deployment at http://wiki.eclipse.org/Tomcat/Howto/Deploy_Web_Applications)

Sigmah should be now technically installed on your server, congratulations! The procedure is almost finished: next step will be to create an organization and a first user (see below).


## Creating your first organization ##
  1. Download the newOrganizationLaunchScript.postgresql.sql script from http://code.google.com/p/sigma-h/downloads/list .
  1. Edit the logo of your organization to produce a PNG file of 126x56 pixels, and save this file in the files folder of your Sigmah installation (ie: `C:\Sigmah\Files`). _(**Notice**: in v1.2 and earlier versions, there was a specific `images` folder to store logo on the filesystem, but since v2.0 all files including organisations' logos are stored in a single folder)_
  1. Edit the script, and use the search&replace tool of your text editor to replace all the parameters (strings which starts and ends by a '§') by the values you want to give to them.
  1. Run the script on your database.

**Your installation of Sigmah is fully finished!**

You're ready to use it.

To start to use your Sigmah installation:
  1. Open your browser at http://localhost:8080/sigmah/ (or another URL if you have not used all the default parameters suggested in this procedure)
  1. Enter the email used as parameter in the newOrganizationLaunchScript.postgresql.sql script, and "sigmah" as password.
  1. You're in!


# Installing Sigmah on Ubuntu #
## Prerequisites ##
### Install the java jre environment ###
```
user@hostname:~$ sudo apt-get install default-jre
```

### Download and install Jetty ###

It looks like the version 9 of Jetty is not working (version 8 does).

```
user@hostname:~$ cd /usr/local/src
user@hostname:/usr/local/src$ sudo wget http://download.eclipse.org/jetty/stable-8/dist/jetty-distribution-8.1.8.v20121106.tar.gz
user@hostname:/usr/local/src$ sudo tar xfz jetty-distribution-8.1.8.v20121106.tar.gz
user@hostname:/usr/local/src$ sudo mv jetty-distribution-8.1.8.v20121106 /opt/jetty
user@hostname:/usr/local/src$ sudo cp /opt/jetty/bin/jetty.sh /etc/init.d/jetty
user@hostname:/usr/local/src$ sudo useradd jetty -U -s /bin/false
user@hostname:/usr/local/src$ sudo chown -R jetty:jetty /opt/jetty
```

### Install PostreSQL ###
```
user@hostname:~$ sudo apt-get install postgresql
user@hostname:~$ sudo -i -u postgres
postgres@hostname:~$ psql
postgres=# CREATE USER sigmah;
# CREATE ROLE
postgres=# ALTER ROLE sigmah WITH CREATEDB;
# ALTER ROLE
postgres=# CREATE DATABASE sigmah_db OWNER sigmah;
# CREATE DATABASE
postgres=# ALTER USER sigmah WITH ENCRYPTED PASSWORD 'sigmah';
# ALTER ROLE
postgres=# \q
postgres@hostname:~$ [ctrl+d] to logout
user@hostname:~$
```

## Preparing the Sigmah Database ##

You can follow the "Preparing the Sigmah database" part to download the MinimumDataKit-1.1-postgresql.zip file. Unzip the file and open a terminal in the unzipped folder "MinimumDataKit-1.1-postgresql".

Note: I got errors with the 2-compas\_quality\_framework.postgresql.sql file due to the escape caracter "\'" not escaped... (i.e. "People\'s"). I edited the file and removed them: "people\'s" -> "peoples".

```
user@hostname:~/MinimumDataKit-1.1-postgresql$ psql -U sigmah -d sigmah_db -h localhost -f ./0-structure.postgresql.sql
Password for user sigmah: 
user@hostname:~/MinimumDataKit-1.1-postgresql$ psql -U sigmah -d sigmah_db -h localhost -f ./1-actinfo-data-withoutUser.postgresql.sql 
Password for user sigmah: 
user@hostname:~/MinimumDataKit-1.1-postgresql$ psql -U sigmah -d sigmah_db -h localhost -f ./2-compas_quality_framework.postgresql.sql 
Password for user sigmah: 
```

## Installing Sigmah and creating your first organization ##

You can follow the "Installing Sigmah" part as the process is the same.

However, keep in mind the 2 following comments:

**To restart Jetty (point 8.):
```
user@hostname:~$ sudo /etc/init.d/jetty restart
```**

**PostgreSQL: when restarting PostgreSQL, I had an issue with the log file (missing the folder _/var/log/postgresql_):**

```
user@hostname:/var/log$ sudo /etc/init.d/postgresql restart
* Restarting PostgreSQL 9.1 database server
* Error: Could not create log file /var/log/postgresql/postgresql-9.1-main.log

user@hostname:/var/log$ sudo mkdir postgresql
user@hostname:/var/log$ sudo chmod 777 postgresql/
user@hostname:/var/log$ sudo /etc/init.d/postgresql restart
```

See also: http://bugs.launchpad.net/ubuntu/+source/postgresql-common/+bug/1048664