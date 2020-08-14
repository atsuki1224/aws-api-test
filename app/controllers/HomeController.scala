package controllers

import javax.inject._
import play.api._
import play.api.mvc._

import play.api.libs.ws._
import scala.concurrent.Future
/**
 *
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    val holder: WSRequestHolder = WS.url(url)
    val complexHolder: WSRequestHolder =
  holder.withHeaders("Accept" -> "application/json")
    .withRequestTimeout(10000)
    .withQueryString("search" -> "play")
    val futureResponse: Future[WSResponse] = complexHolder.get()
    Ok(views.html.index())
  }
}
