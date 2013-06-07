# devteam app

This is a simple ScalikeJDBC demo application. 

## ScalikeJDBC

ScalikeJDBC is A tidy SQL-based DB access library for Scala developers. This library naturally wraps JDBC APIs and provides you easy-to-use APIs.

https://github.com/seratch/scalikejdbc

https://github.com/seratch/scalikejdbc/wiki

### ScalikeJDBC Users Group

Join us if you're insterested!

https://groups.google.com/group/scalikejdbc-users-group

## Some models which uses ScalikeJDBC Query DSL

Source code under `src/main/scala/devteam/model`. These are simple model example that use Query DSL.

https://github.com/seratch/devteam-app/tree/master/src/main/scala/devteam/model

Try ScalikeJDBC on `sbt console`!

### SQLInterpolation Basic

SQLInterpolation simplifies DB access.

```scala
val name = "Typesafe"
val company = sql"select id, name from company where name = ${name}".map(_.toMap).single.apply()
```

- More info

https://github.com/seratch/scalikejdbc/wiki/SQLInterpolation

### Query DSL

DRY and typesafe way to write SQL.

```
val typesafe = withSQL {
  select.from(Company as c).where.eq(c.name, "Typesafe")
}.map(Company(c)).single.apply()
```

or try prepared models:

```scala
val pg = Programmer.create("@seratch")
pg.addSkill(Skill.findAll.head)
pg.copy(companyId = Company.findAll.headOption.map(_.id)).save()

val seratch = Programmer.findAllBy(sqls.eq(p.name, "@seratch")).head
seratch.company
seratch.skills
```

- More info

https://github.com/seratch/scalikejdbc/wiki/Query-DSL-Reference

### Testing Support

ScalikeJDBC has powerful testing support. You can use auto-rollback and fixtures with ScalaTest or specs2. Check the following example:

https://github.com/seratch/devteam-app/blob/master/src/test/scala/devteam/model/ProgrammerSpec.scala

- More info

https://github.com/seratch/scalikejdbc/wiki/Test-Support

### Source Code Generator

`scalikejdbc-gen` is a useful sbt plugin to generate Scala code from existing tables. Usage is pretty simple. Just specify table name like this:

```scala
sbt "scalikejdbc-gen company"
```

- More info

https://github.com/seratch/scalikejdbc/wiki/Generating-Models

### Typesafe Config Reader

This is an easy-to-use configuration loader for ScalikeJDBC which reads typesafe config. `DBs.setupAll` loads `src/main/resources/application.conf`. 

- More info

https://github.com/seratch/scalikejdbc/wiki/Config

### Simple JSON API app (Play2)

The above models don't depend on any specific web framework. You can re-use them in wether Play2 app, Scalatra app or others.

`playapp` project is a pretty simple JSON API server demo app. Try it now:

```
sbt 
project playapp
run

// access http://localhost:9000/companies
```

- Code

https://github.com/seratch/devteam-app/blob/master/playapp/app/controllers

- Routing

https://github.com/seratch/devteam-app/blob/master/playapp/conf/routes

- More info

The above models don't depend on Play framework. You can re-use them in wether Play2 app, Scalatra app or others.

## Files

```
.
├── README.md
├── build.sbt
├── db
│   ├── playapp.h2.db
│   ├── sandbox.h2.db
├── playapp
│   ├── app
│   │   └── controllers
│   │       ├── Companies.scala
│   │       ├── Programmers.scala
│   │       ├── Root.scala
│   │       └── Skills.scala
│   ├── build.sbt
│   ├── conf
│   │   ├── application.conf
│   │   ├── db
│   │   │   └── migration
│   │   │       └── default
│   │   │           └── V1__create_tables.sql
│   │   ├── play.plugins
│   │   └── routes
│   ├── dependency-graph.txt
│   ├── project
│   │   └── build.properties
│   └── test
│       └── RootSpec.scala
├── project
│   ├── Build.scala
│   ├── build.properties
│   ├── plugins.sbt
│   └── scalikejdbc.properties
└── src
    ├── main
    │   ├── resources
    │   │   └── application.conf
    │   └── scala
    │       └── devteam
    │           ├── misc
    │           │   ├── DBInitializer.scala
    │           │   └── HibernateSQLFormatter.scala
    │           └── model
    │               ├── Company.scala
    │               ├── Programmer.scala
    │               ├── ProgrammerSkill.scala
    │               └── Skill.scala
    └── test
        ├── resources
        │   └── application.conf
        └── scala
            ├── devteam
            │   └── model
            │       ├── CompanySpec.scala
            │       ├── ProgrammerSpec.scala
            │       └── SkillSpec.scala
            └── settings
                └── DBSettings.scala
```

## License

Apache License, Version 2.0

http://www.apache.org/licenses/LICENSE-2.0.html


