package controllers

import config.WeatherConfig
import openweathermap.OpenWeatherMap.{geoCode, getWeather}
import play.api.libs.ws.WSClient
import play.api.mvc._

import scala.concurrent.ExecutionContext


/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
class HomeController(val controllerComponents: ControllerComponents, ws: WSClient, conf: WeatherConfig)(implicit ec:  ExecutionContext) extends BaseController {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def weather(city: String) = Action.async { implicit request: Request[AnyContent] =>
   for {
      (lat, lon) <- geoCode(city, conf.key, ws)
      response <- getWeather(lat, lon, conf.key, ws)
    } yield Ok(views.html.weather(city, response))
  }
}
