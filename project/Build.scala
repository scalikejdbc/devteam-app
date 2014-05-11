import sbt._, Keys._
import play.Project._

object DevTeamBuild extends Build {

  lazy val scalikejdbcVersion = "2.0.0"
  lazy val h2Version = "1.4.178"

  val commonSettings = Seq(
    scalaVersion := "2.10.4",
    scalacOptions ++= Seq("-deprecation", "-language:_", "-unchecked")
  )

  lazy val common = Project(
    id = "common",
    base = file(".")
  ).settings(
    commonSettings ++ Seq(
      organization := "org.scalikejdbc",
      name := "devteam-example-common",
      version := "0.1-SNAPSHOT",
      libraryDependencies ++= Seq(
        "org.scalikejdbc"    %% "scalikejdbc"               % scalikejdbcVersion,
        "org.scalikejdbc"    %% "scalikejdbc-config"        % scalikejdbcVersion,
        "org.slf4j"          %  "slf4j-simple"              % "1.7.5"             % "provided",
        "org.hibernate"      %  "hibernate-core"            % "4.2.2.Final",
        "com.h2database"     %  "h2"                        % h2Version,
        "org.scalikejdbc"    %% "scalikejdbc-test"          % scalikejdbcVersion  % "test",
        "org.specs2"         %% "specs2"                    % "2.0"               % "test"
      )
    ) ++ net.virtualvoid.sbt.graph.Plugin.graphSettings :_*
  )

  lazy val playapp = {
    val appName         = "playapp"
    val appVersion      = "0.1-SNAPSHOT"
    val scalikejdbcPluginVersion = "2.2.0"
    val appDependencies = Seq(
      "org.scalikejdbc"      %% "scalikejdbc-play-plugin"         % scalikejdbcPluginVersion,
      "org.scalikejdbc"      %% "scalikejdbc-play-fixture-plugin" % scalikejdbcPluginVersion,
      "org.json4s"           %% "json4s-ext"                      % "3.2.5",
      "com.github.tototoshi" %% "play-json4s-native"              % "0.2.0",
      "com.github.tototoshi" %% "play-flyway"                     % "1.0.3",
      "com.h2database"       %  "h2"                              % h2Version
    )
    play.Project(appName, appVersion, appDependencies, path = file("playapp")).settings(
      commonSettings ++ net.virtualvoid.sbt.graph.Plugin.graphSettings :_*
    ).dependsOn(common)
  }

}
