package controllers

import javax.inject._
import play.api._
import play.api.mvc._

import play.api.libs.ws._
import scala.concurrent.Future
import javax.inject.Inject

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
      val holder = ws.url(url)
      val complexHolder =
      holder.withHeaders("Accept" -> "application/json")
      .withQueryString("search" -> "play")
      val futureResponse: Future[WSResponse] = complexHolder.get()
      println("これが値")
      for {
         result <- futureResponse
      } yield result 
      println("これが値")
      Ok(views.html.index())
    }
}
