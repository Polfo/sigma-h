# Introduction #
Sigmah takes advantage of an array of Java technologies. Here are few resources for learning these different components

# Resources #

### Google Web Toolkit (GWT) ###

GWT was the main reason for choosing the Java platform for Sigmah rather than .NET.

  * [Project page](http://code.google.com/webtoolkit/)
  * [Introduction / Tutorial en français](http://www.mkhelif.fr/2008/07/03/gwt-introduction-au-framework.html)
  * [Tutorial in English](http://code.google.com/webtoolkit/tutorials/1.6/gettingstarted.html)

### Ext-GWT (GXT) ###

Ext-GWT or GXT is fairly complete widget library for GWT that has made it easy to implement an Office/Desktop-like interface for Sigmah. Though we're starting to have the time to branch out it more fluent, web-like interfaces, GXT still forms the core of the user interface.

  * [Product home page](http://www.extjs.com/products/gxt/)
  * [Getting started screen cast](http://www.extjs.com/helpcenter/nav/0_0)
  * [Video "Best practices in Ext-GWT"](http://vimeo.com/17796860)


### GoogleMaps ###

  * [API Reference](http://code.google.com/apis/maps/documentation/index.html)

### Dependency Injection (DI) ###

Sigmah uses DI extensively to keep components decoupled and enable unit testing.

  * Here is an [introduction to DI and Guice specifically](http://www.youtube.com/watch?v=hBVJbzAagfs&feature=player_embedded)
  * Article en français: [L'injection de dépendances](http://blog.xebia.fr/2009/04/15/google-guice-les-bases-de-linjection-de-dependances/)
  * [The Guice project page](http://code.google.com/p/google-guice/)

### MVP + DI FTW ###

The Sigmah client side application is built around two, really three key ideas:

  * The Model-View-Presenter (MVP) pattern, wherein we try to build UI components such that they delegate all or most logic to an easy-to-test presenter class.
  * Dependency Injection (see above)
  * The remote command pattern
  * The event bus pattern

These concepts are layed out in an [excellent video presentation](http://code.google.com/events/io/2009/sessions/GoogleWebToolkitBestPractices.html) by Ray Ryan.

### Other client side libraries ###

  * [Gwt-Log](http://code.google.com/p/gwt-log/) from Fred Sauer helped solve the great November IE6 crisis.

### Hibernate ###

[Hibernate](http://www.hibernate.org) is the Object-Relational Mapping toolkit that implements the JPA specification. It is responsible for moving the domain objects to and from the database.