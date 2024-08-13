package controllers

import play.api.libs.ws.WSClient
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
class HomeController(val controllerComponents: ControllerComponents, ws: WSClient) extends BaseController {

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

  def weather(city: String) = Action { implicit request: Request[AnyContent] =>
    // fetch the geo location of the city
    // pass the lon and lat to the weather API
    // handle the result


    Ok(views.html.weather(city))
  }
}
