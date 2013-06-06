## devteam example app

This is a ScalikeJDBC example application.

https://github.com/seratch/scalikejdbc

## Try features!

- SQLInterpolation

`sbt console` and do like this:

```scala
//import scalikejdbc._, SQLInterpolation._
//implciit val session = AutoSession
val results = sql"select * from company".map(_.toMap).list.apply()
```

- Query DSL

Example:

https://github.com/seratch/devteam-app/blob/master/src/main/scala/devteam/model/Programmer.scala

These model classes is available on `sbt console`.

You can try it:

```scala
val newbie = Programmer.create("seratch")
newbie.addSkill(Skill.findAll.head)
newbie.copy(companyId = Company.findAll.headOption.map(_.id)).save()

val seratch = Programmer.findAllBy(sqls.eq(p.name, "seratch")).head
seratch.company
seratch.skills
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

