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
class LineController @Inject()(val controllerComponents: ControllerComponents, ws: WSClient) extends BaseController {
  val url = "https://api.line.me/v2/bot/message/reply" 
  val channelToken = "kEY"

  def index = Action { implicit request: Request[AnyContent] =>
    
    Ok(views.html.index())
  }
}
/*
  implicit val ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global
    def echo() = Action { implicit request: Request[AnyContent] =>
      val url = "https://collectionapi.metmuseum.org/public/collection/v1/objects/1224"
      //val url = "https://zipcloud.ibsnet.co.jp/api/search?zipcode=7830060"
      val request = ws.url(url)
      val result: Future[String] = request.get().map{
        response => (response.json \ "primaryImage").as[String]
      }
      val text: String = Await.result(result, Duration.Inf)
      println(text)
      Ok(views.html.index(text))
    }
    */



/*
function doPost(e) {
  var replyToken= JSON.parse(e.postData.contents).events[0].replyToken;
  if (typeof replyToken === 'undefined') {
    return;
  }

  var url = 'https://api.line.me/v2/bot/message/reply';
  var channelToken = 'WE4MYynApTTKuBEnZr9wYr/lUCz6lB/peUGhVc9nYUiVBnZ/TscIDvxzYXki1qLHQ0obPvQOJ03gpGdn8YO17ljdtwTj2aaLz5MvZDYfw+ctJU28bQSo6ssnwQHg2zlsIUTQPOkRYDjeaUI00Q9LigdB04t89/1O/w1cDnyilFU=';

  var messages = [{
    'type': 'text',
    'text': '熱中症に気をつけて',
  }];

  UrlFetchApp.fetch(url, {
    'headers': {
      'Content-Type': 'application/json; charset=UTF-8',
      'Authorization': 'Bearer ' + channelToken,
    },
    'method': 'post',
    'payload': JSON.stringify({
      'replyToken': replyToken,
      'messages': messages,
    }),
  });
  return ContentService.createTextOutput(JSON.stringify({'content': 'post ok'})).setMimeType(ContentService.MimeType.JSON);
}
*/
