package controllers

import javax.inject._
import play.api.mvc._

@Singleton
class MessageController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def idex = Action {
    Ok("test post")
  }
}
