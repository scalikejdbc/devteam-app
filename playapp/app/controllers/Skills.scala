package controllers

import play.api._, mvc._
import play.api.data._, Forms._

import org.json4s._, ext.JodaTimeSerializers, native.JsonMethods._
import com.github.tototoshi.play2.json4s.native._

import devteam.model._

object Skills extends Controller with Json4s {

  implicit val formats = DefaultFormats ++ JodaTimeSerializers.all
 
  def all = Action {
   Ok(Extraction.decompose(Skill.findAll))
  }

  def show(id: Long) = Action {
   Skill.find(id).map{ skill =>
     Ok(Extraction.decompose(skill))
   }.getOrElse(NotFound)
  }

  val skillForm = Form("name" -> text)
 
  def create = Action { implicit req =>
    val name = skillForm.bindFromRequest.get
    val skill = Skill.create(name = name)
    Created.withHeaders(LOCATION -> s"/skills/${skill.id}")
  }

  def delete(id: Long) = Action {
   Skill.find(id).map{ skill =>
     skill.destroy()
     NoContent
   }.getOrElse(NotFound)
  }
 
}
