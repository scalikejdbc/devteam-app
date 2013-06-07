initialCommands := """
import scalikejdbc._,config._,SQLInterpolation._
import devteam._,model._,misc._
DBs.setupAll
DBInitializer.run()
GlobalSettings.sqlFormatter = SQLFormatterSettings("devteam.misc.HibernateSQLFormatter")
implicit val autoSession = AutoSession
val (p, c, s, ps) = (Programmer.syntax("p"), Company.syntax("c"), Skill.syntax("s"), ProgrammerSkill.syntax("ps"))
"""

scalikejdbcSettings

scalariformSettings


