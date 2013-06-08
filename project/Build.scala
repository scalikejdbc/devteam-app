import sbt._, Keys._
import play.Project._

object DevTeamBuild extends Build {

  lazy val scalikejdbcVersion = "1.6.3-SNAPSHOT"

  lazy val common = Project(
    id = "common",
    base = file("."),
    settings = Defaults.defaultSettings ++ Seq(
      organization := "com.github.seratch",
      name := "devteam-example-common",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.10.1",
      resolvers ++= Seq(
        "Sonatype releases" at "http://oss.sonatype.org/content/repositories/releases",
        "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots"
      ),
      libraryDependencies ++= Seq(
        "com.github.seratch" %% "scalikejdbc"               % scalikejdbcVersion,
        "com.github.seratch" %% "scalikejdbc-config"        % scalikejdbcVersion,
        "com.github.seratch" %% "scalikejdbc-interpolation" % scalikejdbcVersion,
        "org.slf4j"          %  "slf4j-simple"              % "[1.7,)"             % "provided",
        "org.hibernate"      %  "hibernate-core"            % "4.2.2.Final",
        "com.h2database"     %  "h2"                        % "[1.3,)",
        "com.github.seratch" %% "scalikejdbc-test"          % scalikejdbcVersion   % "test",
        "org.specs2"         %% "specs2"                    % "[1.13,)"            % "test"
      )
    ) ++ net.virtualvoid.sbt.graph.Plugin.graphSettings
  )

  lazy val playapp = {
    val appName         = "playapp"
    val appVersion      = "0.1-SNAPSHOT"
    val appDependencies = Seq(
      "com.github.seratch"   %% "scalikejdbc-play-plugin"         % scalikejdbcVersion,
      "com.github.seratch"   %% "scalikejdbc-play-fixture-plugin" % scalikejdbcVersion,
      "org.json4s"           %% "json4s-ext"                      % "[3.2,)",
      "com.github.tototoshi" %% "play-json4s-native"              % "[0.1,)",
      "com.github.tototoshi" %% "play-flyway"                     % "[0.1,)",
      "com.h2database"       %  "h2"                              % "[1.3,)"
    )
    play.Project(appName, appVersion, appDependencies, path = file("playapp")).settings(
      (net.virtualvoid.sbt.graph.Plugin.graphSettings :+ (scalaVersion in ThisBuild := "2.10.1")):_*
    ).dependsOn(common)
  }

}
