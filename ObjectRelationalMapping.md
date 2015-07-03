# Introduction #

ActivityInfo relies on the Java Persistance API (JPA), specifically Hibernate to map the
object relational model to an underlying database.

Individual objects are mapped are database tables and columns with JPA annotations, such as
@Entity, @Table, @Column, @ManyToOne, etc. Take a look at the definitions of the
[org.activityinfo.server.domain](http://code.google.com/p/activity-info/source/browse/trunk/activityinfo/src/main/java/org/activityinfo/server/domain/) classes.

Hibernate, as a JPA implementation, takes care of propagating application state to and from the database layer. For example, the following code creates a new UserDatabase and calls on the EntityManager to save it to the database.

```
User alex = entityManager.getReference(User.class, 12); // get a reference to the user who will own this new database

UserDatabase db = new UserDatabase();
db.setName("RRM");
db.setFullName("Rapid Response Mechanism");
db.setOwner( alex );

entityManager.persist( db );
```

The entityManager is generally provided by the DependencyInjectionFramework.

See also:
  * [Hibernate Web Site](http://www.hibernate.org/)
  * Book: [Java Persistence with Hibernate](http://www.manning.com/bauer2/) by Bauer/King


# Deleting Objects #

Deletion of both SchemaDomainObjects and SiteDomainObjects is handled by setting a dateDeleted flag on the deleted entities, rather
than physically removing them from the database. This is done for several reasons.

First, Physical deletion of a high level schema object like the UserDatabase could result in the cascading removal of thousands of entities and years worth of data.
The possiblity of an accidental deletion, even by an authorized user, is a pretty scary thought. Flagging objects as removed rather than actually deleting them makes emergency "undeletes" possible. (There is no user interface for this yet)

Second, it facilitates synchronisation, as clients can query for the identity of recently deleted objects.



# Enforcing visibility #

Authenticated users are only meant to see parts of the overall ActivityInfo database, for example, a user who does not
have access to a UserDatabase should not be able to see the database or it's indicators, data etc. A user who has access to a database
only to sites from their partner should not see data from other sites. Users, in general, should not see entities that have
been marked as removed.

ActivityInfo uses Hibernate filters to enforce these rules transparently at the mapping level, rather than at the business logic
level, which leaves the logic code a bit cleaner.

The following annotation on [UserDatabase](http://code.google.com/p/activity-info/source/browse/trunk/activityinfo/src/main/java/org/activityinfo/server/domain/UserDatabase.java)
for example, will add a WHERE clause to all queries involving UserDatabase to include only those UserDatabases where
the currentUser is either the owner or authorized to view the UserDatabase.

```
@org.hibernate.annotations.Filter(
     name="userVisible",
     condition="(:currentUserId = OwnerUserId or " +
          ":currentUserId in (select p.UserId from UserPermission p " +
	       "where p.AllowView=1 and p.UserId=:currentUserId and p.DatabaseId=DatabaseId))"
)
```


The filter below, when activated, assures that only entities that have not been deleted are included in query results:

```
@org.hibernate.annotations.Filter(
     name="hideDeleted",
     condition="DateDeleted is null"
)
```

Filters are activated automatically by the DependencyInjectionFramework upon the receipt of a new HttpRequest and authentication
of the requesting user.
