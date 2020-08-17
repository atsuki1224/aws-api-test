package controllers

import javax.inject._
import play.api._
import play.api.mvc._

import play.api.libs.ws._
import scala.concurrent.{Future, Await}
import javax.inject.Inject
import scala.concurrent.duration.Duration

import play.api.libs.ws.WSClient

import scala.concurrent.{ExecutionContext, Future}
/**
 *
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents, ws: WSClient) extends BaseController {
  implicit val ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global
    def index() = Action { implicit request: Request[AnyContent] =>
      val url = "https://zipcloud.ibsnet.co.jp/api/search?zipcode=7830060"
      val request = ws.url(url)
      val result: Future[String] = request.get().map{
        response => (response.json \ "address1").as[String]
      }
      val text: String = Await.result(result, Duration.Inf)
      println(text)
      Ok(views.html.index())
    }
}
