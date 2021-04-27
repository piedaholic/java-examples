package com.piedaholic.jdbc;

//@formatter:off
/*

    Driver: Establishes a connection to the database
    Connection: Sends commands to a database
    PreparedStatement: Executes a SQL query
    CallableStatement: Executes commands stored in the database
    ResultSet: Reads results of a query

    Examples of JDBC URLs
    ------------------------------------------------
    jdbc:postgres://localhost:5432/zoo
    jdbc:postgresql://localhost/zoo
    jdbc:oracle:thin:@123.123.123.123:1521:zoo
    jdbc:mysql://localhost:3306
    jdbc:mysql://localhost:3306/zoo?profileSQL=true

    jdbc --> protocol name
    postgres --> Product/Vendor Name
    localhost:5432/zoo --> Database connection details 
    IP address or domain name can also exist instead of localhost

    There are two main ways to get a Connection: 
    1. DriverManager
    2. DataSource.DriverManager

    A DataSource has more features than DriverManager. 
    For example, it can pool connections or store the database connection information outside the application.
    In real applications, you should use a DataSource rather than DriverManager to get a Connection. 
    For one thing, there's no reason why you should have to know the database password. 
    It's far better if the database team or another team can set up a data source that you can reference.
    Another reason is that a DataSource maintains a connection pool so that you can keep reusing the same connection rather than needing to get a new one each time. 
    Even the Javadoc says DataSource is preferred over DriverManager.

    The DriverManager class is in the JDK, as it is an API that comes with Java. 
    It uses the factory pattern, which means that you call a static method getConnection() to get a Connection, rather than calling a constructor.
    The factory pattern means that you can get any implementation of the interface when calling the method.

    Statement is an interface that both PreparedStatement and CallableStatement extend. 
    A Statement and PreparedStatement are similar to each other, 
    except that a PreparedStatement takes parameters, while a Statement does not. 
    A Statement just executes whatever SQL query you give it.

    PreparedStatement is far superior for the following reasons:

    Performance: In most programs, you run similar queries multiple times. 
                 A PreparedStatement figures out a plan to run the SQL well and remembers it.
    Security:   You are protected against an attack called SQL injection when using a PreparedStatement correctly.
    Readability: It's nice not to have to deal with string concatenation in building a query string with lots of parameters.
    Future use: Even if your query is being run only once or doesn't have any parameters, you should still use a PreparedStatement. 
                That way future editors of the code won't add a variable and have to remember to change to PreparedStatement then.


    SQL runnable by the execute method
    Method 	            DELETE 	INSERT 	SELECT 	UPDATE
    ps.execute() 	    Yes 	Yes 	Yes 	Yes
    ps.executeQuery() 	No 	    No 	    Yes 	No
    ps.executeUpdate() 	Yes 	Yes 	No 	    Yes

    Return types of execute methods
    Method 	            Return type 	What is returned for SELECT 	        What is returned for DELETE/INSERT/UPDATE
    ps.execute() 	    boolean 	    true 	                                false
    ps.executeQuery() 	ResultSet 	    The rows and columns returned 	        n/a
    ps.executeUpdate() 	int 	        n/a 	                                Number of rows added/changed/removed

    PreparedStatement methods
    Method name 	Parameter type 	Example database type
    setBoolean 	    Boolean 	    BOOLEAN
    setDouble 	    Double 	        DOUBLE
    setInt 	        Int 	        INTEGER
    setLong 	    Long 	        BIGINT
    setObject 	    Object 	        Any type
    setString 	    String 	        CHAR, VARCHAR

    set<> index starts with 1
    ResultSet : Columnx index starts with 1

    Name 	                Parameter name 	Parameter type 	Description
    read_e_names() 	        n/a 	        n/a 	        Returns all rows in the names table that have a name beginning with an E
    read_names_by_letter() 	prefix 	        IN 	            Returns all rows in the names table that have a name beginning with the specified parameter
    magic_number() 	        Num 	        OUT 	        Returns the number 42
    double_number() 	    Num 	        INOUT 	        Multiplies the parameter by two and returns that number
    
    Stored procedure parameter types
	                                    IN 	    OUT 	INOUT
    Used for input 	                    Yes 	No 	    Yes
    Used for output 	                No 	    Yes 	Yes
    Must set parameter value 	        Yes 	No 	    Yes
    Must call registerOutParameter() 	No 	    Yes 	Yes
    Can include ?= 	                    No 	    Yes 	Yes
*/