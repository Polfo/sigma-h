# Audience #

This document is for those who wish deploy and run ActivityInfo on their own server.
Since those in the UN/NGOs are often coming from a .NET background, the specifics in this
guide are for the Windows platform.

# Required Software #

To run an ActivityInfo Server, you will need to install the following software:

  1. [JDK, v1.6](http://download.java.net/jdk6/)
  1. [Apache Tomcat 6.x](http://tomcat.apache.org/download-60.cgi). There is a convenient Windows Service Installer available on the download page
  1. Download a ready-to-run version of the ActivityInfo server, a ".war" archive, from the [downloads](http://code.google.com/p/activity-info/downloads/list) page.
  1. [MySQL 5.5](http://dev.mysql.com/downloads/mysql/)

Note: Microsoft SQL Server is no longer supported for use with ActivityInfo.

# Setup SQL Server #

## Create the ActivityInfo database ##

Create an empty database called "actinfo".

TODO: write how to create the schema

# Setup Tomcat #

## Configuring Tomcat's Port ##

Tomcat is a Java servlet container, and not necessarily a general purpose web-server, so often it is installed along side Apache or IIS, which continue to serve other parts of your website. There are three ways to organize this:

  1. Run Tomcat as a secondary web server on the same machine as IIS or Apache, accepting requests on port 8080. ActivityInfo would then be accessed from yourorganisation.org:8080. This is also straightforward, but some organisation's firewalls  block port 8080, so some partners may not be able to access the site. This is not recommended.
  1. Run Tomcat as the _**only**_ web server on a given machine, accepting requests on port 80. ActivityInfo could then be accessed from, for example, `activityinfo.youroganisation.org`. This is the easiest in terms of setup: if you have
  1. Run Tomcat as a secondary web server on the same machine as IIS, and configure IIS to redirect certains requests to Tomcat. Users could access ActivityInfo from yourorganisation.org/activityinfo, or you could create a hostname alias and serve ActivityInfo from activityinfo.yourorganisation.org. This is convenienant, but the configuration is somewhat complex, and it seems to create a problem with some early versions of Internet Explorer 6.0

### Setting up Tomcat on port 8080 ###

This is the default configuration for Tomcat, so you will not need to change any configuration files.

### Setting up Tomcat on port 80 ###

You can change Tomcat's port in the conf\server.xml configuraton file. (If you've installed Tomcat on the default windows installation path, you will find the file at `C:\Program Files\Apache Software Foundation\Tomcat 6.0\conf\server.xml`. Find the Connector definition below and change the port from 8080 to 80.

```
  <!-- Define a non-SSL HTTP/1.1 Connector on port 8080 -->
  <Connector   port="8080"
               maxHttpHeaderSize="8192"
               maxThreads="150" minSpareThreads="25" maxSpareThreads="75"
               enableLookups="false" redirectPort="8443" acceptCount="100"
               connectionTimeout="20000" disableUploadTimeout="true"/>
```

### Redirecting traffic from IIS to Tomcat ###

This is a bit tricky. See http://tomcat.apache.org/connectors-doc/index.html


## Setting the admin password ##

You will probably want to set the admin password before open your server to the outside world. To do this, open `C:\Program Files\Apache Software Foundation\Tomcat 6.0\conf\tomcat-users.xml` and change the password attribute of the user element.

```
<tomcat-users>
<user name="admin" password="your-new-password-here" roles="admin,manager" />
</tomcat-users>
```


## Starting Tomcat ##

  1. Open the "Configure Tomcat" tool. You can find this on the start menu in Programs > Tomcat > Configure Tomcat
  1. Click Start

## Deploying ActivityInfo ##

Each web application deployed on Tomcat occupies a servlet "context" and can be accessed from `yourserver:8080/context_name`. The context\_name is determined by the name of the Web Archive (WAR). There is a special context name, "ROOT", that is served from "/". For example:

|Web Archive|Application URL|
|:----------|:--------------|
|activityinfo-0.5.6.war|http://yourserver:8080/activityinfo-0.5.6|
|activityinfo.war|http://yourserver:8080/activityinfo|
|ROOT.war   |http://yourserver:8080|

So before installing the ActivityInfo WAR, rename it according to the URL you would like it to be available.

Copy the ActivityInfo.war to the webapps folder, for example, `C:\Program Files\Apache Software Foundation\Tomcat 6.0\webapps` `C:\Program Files\Apache Software Foundation\Tomcat 6.0\webapps` or use the manager webapp, accessible from http://yourserver:8080/manager

## Configuring the connection to your SQL Server ##

By default, ActivityInfo will connect to SQL server on localhost:1433, with the username 'sa' and password 'adminpwd'.

If you need to change this (because, for example, your SQL server accepts remote connections and you wish to choose a password less obvious than 'adminpwd') you can change the connection URL in sigmah.properties. Relative to ActivityInfo's context root, this can be found in the war/WEB-INF folder.

## Enabling GZIP compression ##

Tomcat, like most web servers, can optionally serve text content like html or css with gzip compression, which most browsers support. (Browsers that do not support gzip compression will receive the uncompressed versions of files)
For ActivityInfo, which contains over a megabyte of javascript, this can help quite a bit for users with slow connections. The initial js code fragment, is ~470 kb uncompressed, but only 167 kb with gzip compression! (See this [blog post](http://timepedia.blogspot.com/2009/08/on-reducing-size-of-compressed.html) for more details on js, gwt and gzip)

In conf\server.xml, find your Connector and add the `compression`, `compressionMinSize`, `noCompressionUserAgents`, and  `compressableMimeType` attributes.

```
  <!-- Define a non-SSL HTTP/1.1 Connector on port 8080 -->
  <Connector   port="8080"
               maxHttpHeaderSize="8192"
               maxThreads="150" minSpareThreads="25" maxSpareThreads="75"
               enableLookups="false" redirectPort="8443" acceptCount="100"
               connectionTimeout="20000" disableUploadTimeout="true"
			   compression="on"
			   compressionMinSize="2048"
			   noCompressionUserAgents="gozilla, traviata"
			   compressableMimeType="text/html,text/xml,text/css,text/javascript"/>
```

Note: certain browsers say they support gzip compression but actually don't. These are excluded in the `noCompressionUserAgents` attribute. There is some question about IE6's support for gzip. If you encounter problems with users accessing ActivityInfo with IE6, you can add its useragent string to the list.

```
			   noCompressionUserAgents="gozilla, traviata, MSIE6.0"
```

You need to restart the server for changes to take effect.


# Customizing the appearance of the login page #

The templates used to render static pages are written in the Freemarker Template language and can be found in the "ftl" folder. (For example, `C:\Program Files\Apache Software Foundation\Tomcat 6.0\webapps\activityinfo\ftl` or `C:\Program Files\Apache Software Foundation\Tomcat 6.0\webapps\ROOT\ftl`)

|Template|Description|
|:-------|:----------|
|login.ftl|The opening login page displayed when a user connects without the "authToken" cookie set. You can completely change the appearance of the page if you choose, just be sure to preserve the form. If you wish to use GoogleAnalytics to track usage, be sure to set your id at the bottom of the page|
|hostpage.ftl|This page is the empty html page into which the ActivityInfo application is loaded. You can change the style of the loading box that appears, just make sure that references to scripts are not changed|

You may need to reload the context after making changes to the template. You can do this from the Tomcat manager at
http://yourserver:8080/manager/html

TODO: