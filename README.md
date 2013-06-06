## devteam example app

This is a ScalikeJDBC example application.

### try sbt console

`sbt console` will prepare all the examples, test database (h2).

```sh
git clone git://github.com/seratch/devteam-app.git
cd devteam-app
sbt console
```

You can try code immediately.

```
Type in expressions to have them evaluated.
Type :help for more information.

scala> Company.findAll
[run-main] INFO scalikejdbc.StatementExecutor$$anon$1 - SQL execution completed

  [SQL Execution]

    select
        c.id as i_on_c,
        c.name as n_on_c,
        c.url as u_on_c,
        c.created_at as ca_on_c,
        c.deleted_at as da_on_c
    from
        company c
    where
        c.deleted_at is null
    order by
        c.id; (0 ms)

  [Stack Trace]
    ...
    devteam.model.Company$.findAll(Company.scala:40)
    $line10.$read$$iw$$iw$$iw$$iw$$iw$$iw$$iw$$iw$$iw$$iw$$iw$$iw$$iw$$iw$.<init>(<console>:27)
    $line10.$read$$iw$$iw$$iw$$iw$$iw$$iw$$iw$$iw$$iw$$iw$$iw$$iw$$iw$$iw$.<clinit>(<console>)
    $line10.$eval$.<init>(<console>:7)
    $line10.$eval$.<clinit>(<console>)
    $line10.$eval.$print(<console>)
    sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
    sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    java.lang.reflect.Method.invoke(Method.java:601)
    scala.tools.nsc.interpreter.IMain$ReadEvalPrint.call(IMain.scala:734)
    scala.tools.nsc.interpreter.IMain$Request.loadAndRun(IMain.scala:983)
    scala.tools.nsc.interpreter.IMain.loadAndRunReq$1(IMain.scala:573)
    scala.tools.nsc.interpreter.IMain.interpret(IMain.scala:604)
    scala.tools.nsc.interpreter.IMain.interpret(IMain.scala:568)
    ...

res0: List[devteam.model.Company] = List(Company(1,Typesafe,Some(http://typesafe.com/),2013-06-07T00:28:57.703+09:00,None), Company(2,Oracle,Some(http://www.oracle.com/),2013-06-07T00:28:57.708+09:00,None), Company(3,Google,Some(http://www.google.com/),2013-06-07T00:28:57.709+09:00,None), Company(4,Microsoft,Some(http://www.microsoft.com/),2013-06-07T00:28:57.709+09:00,None))

scala>

scala> sql"select * from skill".map(_.toMap).list.apply()
[run-main] INFO scalikejdbc.StatementExecutor$$anon$1 - SQL execution completed

  [SQL Execution]

    select
        *
    from
        skill; (0 ms)

  [Stack Trace]
    ...
    $line10.$read$$iw$$iw$$iw$$iw$$iw$$iw$$iw$$iw$$iw$$iw$$iw$$iw$$iw$$iw$.<init>(<console>:27)
    $line10.$read$$iw$$iw$$iw$$iw$$iw$$iw$$iw$$iw$$iw$$iw$$iw$$iw$$iw$$iw$.<clinit>(<console>)
    $line10.$eval$.<init>(<console>:7)
    $line10.$eval$.<clinit>(<console>)
    $line10.$eval.$print(<console>)
    sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
    sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    java.lang.reflect.Method.invoke(Method.java:601)
    scala.tools.nsc.interpreter.IMain$ReadEvalPrint.call(IMain.scala:734)
    scala.tools.nsc.interpreter.IMain$Request.loadAndRun(IMain.scala:983)
    scala.tools.nsc.interpreter.IMain.loadAndRunReq$1(IMain.scala:573)
    scala.tools.nsc.interpreter.IMain.interpret(IMain.scala:604)
    scala.tools.nsc.interpreter.IMain.interpret(IMain.scala:568)
    scala.tools.nsc.interpreter.ILoop.reallyInterpret$1(ILoop.scala:745)
    ...

res0: List[Map[String,Any]] = List(Map(ID -> 1, NAME -> Scala, CREATED_AT -> 2013-06-07 00:28:57.71), Map(ID -> 2, NAME -> Java, CREATED_AT -> 2013-06-07 00:28:57.71), Map(ID -> 3, NAME -> Ruby, CREATED_AT -> 2013-06-07 00:28:57.711), Map(ID -> 4, NAME -> MySQL, CREATED_AT -> 2013-06-07 00:28:57.711), Map(ID -> 5, NAME -> PostgreSQL, CREATED_AT -> 2013-06-07 00:28:57.711))

scala>
```

## Play2 application

```
sbt 
project playapp
run
```

