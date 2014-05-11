libraryDependencies += "com.h2database" % "h2" % "1.4.178"

addSbtPlugin("org.scalikejdbc" %% "scalikejdbc-mapper-generator" % "2.0.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-scalariform" % "1.3.0")

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.2.3")

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.7.4")

addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.1.6")

scalacOptions ++= Seq("-deprecation", "-language:_", "-unchecked")
