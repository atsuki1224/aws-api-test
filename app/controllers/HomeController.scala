package controllers

/**
import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.ws._
import scala.concurrent.{Future, Await}
import javax.inject.Inject
import scala.concurrent.duration.Duration
import play.api.libs.ws.WSClient
import scala.concurrent.{ExecutionContext, Future}
**/

import javax.inject.Inject

import scala.concurrent.{Future, Await}
import scala.concurrent.duration._
import play.api.mvc._
import play.api.libs.ws._
import play.api.http.HttpEntity
import akka.actor.ActorSystem
import akka.stream.scaladsl._
import akka.util.ByteString

/**
 *
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
class HomeController @Inject()(val controllerComponents: ControllerComponents, ws: WSClient) extends BaseController {
  /*
  implicit val ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global
    def index() = Action { implicit request: Request[AnyContent] =>
      val url = "https://api.github.com/users/atsuki1224"
      //val url = "https://zipcloud.ibsnet.co.jp/api/search?zipcode=7830060"
      val request = ws.url(url)
      val result: Future[String] = request.get().map{
        response => (response.json \ "bio").as[String]
      }
      val text: String = Await.result(result, Duration.Inf)
      println(text)
      Ok(views.html.index(text))
    }
    */
   def index()  = Action { implicit request: Request[AnyContent] =>
  implicit val ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global
     val url = "https://api.github.com/users/atsuki1224"
     val request: WSRequest = ws.url(url)
     val complexRequest: WSRequest =
     request
       .addHttpHeaders("Accept" -> "application/json / bio")
       .addQueryStringParameters("search" -> "play")
       val futureResponse: Future[WSResponse] = complexRequest.get()
       val text: WSResponse = Await.result(futureResponse, Duration.Inf)
       println("これがあたいだよおおおおおおおおおおおおお")
       println(text)
       Ok(views.html.index())
   }
}



