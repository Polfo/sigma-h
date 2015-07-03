# Introduction #

ActivityInfo uses the JDBC driver to connect to SQL server, which requires that the server accept incoming TCP/IP Connections on port 1433 and logins via SQL authentication.

# Enabling Mixed Mode Authentication #

  1. In SQL Server Management Studio Object Explorer, right-click the server, and then click Properties.
  1. On the Security page, under Server authentication, select "SQL Server and Windows Authentication mode", and then click OK.
  1. In the SQL Server Management Studio dialog box, click OK, to acknowledge the need to restart SQL Server.
  1. In Object Explorer, right-click your server, and then click Restart. If SQL Server Agent is running, it must also be restarted.


# Enabling TCP/IP Access on Port 1433 #

  1. Click Start > All Programs > Microsoft SQL Server 2005 > Configuration Tools > SQL Server Configuration Manager.
  1. In the left pane of the SQL Server Configuration Manager window, expand SQL Server 2005 Network Configuration and then click Protocols for SQLEXPRESS.
  1. In the right pane of the SQL Server Configuration Manager window, right-click TCP/IP and click Enable. Click OK to acknowledge the warning message.
  1. Right-click TCP/IP again and click Properties.
  1. In the TCP/IP Properties window, click the IP Addresses tab, and then expand IPALL.
  1. Under IPALL, clear the TCP Dynamic Ports field and then type a port number in the TCP Port field. Usually, the port number should be set to 1433.
  1. In the TCP/IP Properties window, click OK, and then click OK to acknowledge the warning message.
  1. In the left pane of the SQL Server Configuration Manager window, click SQL Server 2005 Services.
  1. In the right pane of the SQL Server Configuration Manager window, right-click SQL Server (SQLEXPRESS) and click Restart.