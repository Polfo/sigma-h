# Goal of these scripts #
The data separation scripts were intended to extract organization data from one MySQL database and to insert it into several PostgreSQL databases. Each PostgreSQL instance corresponds to one organization. The main goal of this project was to increase data security by splitting data from each organization.

# How to : #
## Run it with the command line ##
These scripts needs Pentaho Data Integration in order to work properly (an open-source version exists under the name [Pentaho Data Integration Community Edition](http://kettle.pentaho.com)).

Go to the root of this software. Use this command line for running the script in Linux :
```
kitchen.sh 
-file="$$MAIN_SCRIPT_PATH$$" 
-param="DATA_SEPARATION_DESCRIPTOR=$$DATA_SEPARATION_DESCRIPTOR_PATH$$"
-param="OUTPUT_DIRECTORY=$$OUTPUT_DIRECTORY$$" > $$LOG_FILE$$
```

This script is also runnable on Windows with this command line :
```
Kitchen.bat 
/file:"$$MAIN_SCRIPT_PATH$$"
/param:"DATA_SEPARATION_DESCRIPTOR=$$DATA_SEPARATION_DESCRIPTOR_PATH$$"
/param:"OUTPUT_DIRECTORY=$$OUTPUT_DIRECTORY$$" > $$LOG_FILE$$
```

These command lines contains some variables :
  * **$$MAIN\_SCRIPT\_PATH$$** is the absolute path of the main script of these script. Its name is already DataSeparation.kjb and is placed in the root of the project.
  * **$$DATA\_SEPARATION\_DESCRIPTOR\_PATH$$** is the absolute path of the XML file descriptor used to set parameters in the script.
  * **$$OUTPUT\_DIRECTORY$$** is the absolute path of the directory where log files will be written. Don't forget to end this path with a forward slash on Linux or a double backslash on Windows.
  * **$$LOG\_FILE$$** is the absolute or relative path of the file where will be written the output of the PDI script.

## Define the XML file descriptor ##
The XML file descriptor is made for defining access parameters of each database which will be used by the script and for linking a database with an organization and the place where data file will be stored.

The element **`<data-separation>`** is the root of the document. It contains two others elements :
**`<central-base>`** for defining the central instance with MySQL and **`<organizations>`** for defining target instance with PostgreSQL.

The first one contains the element **`<mysql-connection>`** that defines the connection of the MySQL database of the central instance. This element indicates the IP address of the database with **`<host>`**, the port of MySQL with **`<port>`**, the name of the database with **`<database>`** and the user with **`<user>`**. The used has a name and a password (defined by **`<name>`** and **`<password>`**).

The element **`<target-base>`** has also the element **`<file-repository>`** that gives information on where files are stored and how they can be accessed (in other words these files can be accessed locally or with a specific protocol ?). This element use an attribute to specify the type of the access. Actually this attribute can have only one possible value : _“local”_ which indicates that files can be accessed locally on the hard drive.
This element has also an element different depending on the type of the previous attribute.
When the attribute has the value _“local”_, the sub-element is named **`<local-path>`** and indicates the absolute path of the directory where all files are stored. Dont forget to end the path with a forward slash if you run the script on Linux or a backslash if you used a Windows OS.

This is an example that defines a central instance :
```
<data-separation>
    <central-base>
        <mysql-connection>
            <host>127.0.0.1</host>
            <port>3306</port>
            <database>sigmah</database>
            <user>
                <name>username</name>
                <password>password</password>
            </user>
        </mysql-connection>
        <file-repository type=”local”>
            <local-path>/my_repository/</local-path>
        </file-repository>
    </central-base>
    [...]
</data-separation>
```

The element **`<organizations>`** contains several elements **`<organization>`**. Each element **`<organization>`** possess an id (defined by **`<id>`**) that corresponds to the value of the primary key on the central database of the organization you want to move.
It has also a name (defined by **`<name>`**). This name is only used for naming some log files. The value is not very important and is not necessarily the same name that the field name on the table Organization in the database. It has also an element **`<postgres-connection>`** that is the same as the element **`<mysql-connection>`** excepted that it has also an element that defines the schema (with the element **`<schema>`**) used on the PostgreSQL database. And it has also the element **`<file-repository>`** like the element **`<central-base>`**.

That is an example that defines a list of organizations.
```
<data-separation>
    [...]
    <organizations>
        <organization>
            <id>5</id>
            <name>MyNGO</name>
            <postgres-connection>
                <host>127.0.0.1</host>
                <port>5432</port>
                <database>sigmah</database>
                <user>
                    <name>username</name>
                    <password>password</password>
                </user>
            </postgres-connection>
        </organization>
        <organization>
            [...]
        </organization>
        [...]
    </organizations>
</data-separation>
```

### Example of the XML file descriptor ###
Here is an example of the XML file descriptor. In this file, the central database is split in two database : one for the NGO named "First NGO" and another one for the NGO named "Second NGO".
```
<data-separation>
    <central-base>
        <mysql-connection>
            <host>mysqldb.host.com</host>
            <port>3306</port>
            <database>sigmah</database>
            <user>
                <name>mysql_user</name>
                <password>mysql_password</password>
            </user>
        </mysql-connection>
        <file-repository type="local">
            <local-path>/var/sigmah/</local-path>
        </file-repository>
    </central-base>
    <organizations>
        <organization>
            <id>5</id>
            <name>First NGO</name>
            <postgres-connection>
                <host>first.ngo.com</host>
                <port>5432</port>
                <database>sigmah</database>
                <schema>public</schema>
                <user>
                    <name>pg_user</name>
                    <password>pg_password</password>
                </user>
            </postgres-connection>
            <file-repository type="local">
                <local-path>/var/first_ngo/</local-path>
            </file-repository>
        </organization>
        <organization>
            <id>7</id>
            <name>Second NGO</name>
            <postgres-connection>
                <host>second_ngo.uk</host>
                <port>5555</port>
                <database>sigmah</database>
                <schema>sigmah_schema</schema>
                <user>
                    <name>sngo</name>
                    <password>sngo</password>
                </user>
            </postgres-connection>
            <file-repository type="local">
                <local-path>/home/sngo/sigmah_repository/</local-path>
            </file-repository>
        </organization>
    </organizations>
</data-separation>
```