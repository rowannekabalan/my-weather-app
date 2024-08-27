import config.WeatherConfig
import controllers.HomeController
import play.api.libs.ws.ahc.AhcWSComponents
import play.api.routing.Router
import play.api.{ApplicationLoader, BuiltInComponentsFromContext, Logging}
import play.filters.HttpFiltersComponents

class AppComponents(context:  ApplicationLoader.Context) extends BuiltInComponentsFromContext(context) with AhcWSComponents with HttpFiltersComponents with controllers.AssetsComponents{

  val conf = WeatherConfig.loadConfig().get

  override def router: Router = new Router.Routes(
    httpErrorHandler,
    new HomeController(controllerComponents, wsClient, conf),
    assets
  )
}