## devteam example app

This is a ScalikeJDBC example application.

https://github.com/seratch/scalikejdbc

## Try features!

- interpolation

`sbt console` and do like this:

```scala
//import scalikejdbc._, SQLInterpolation._
//implciit val session = AutoSession
val results = sql"select * from company".map(_.toMap).list.apply()
```

- mapper-generator

```sh
sbt
scalikejdbc-gen company
```

- config

`DBs.setupAll` loads `src/main/resources/applicaiton.conf`.

- play plugin

```sh
sbt 
project playapp
run
```

