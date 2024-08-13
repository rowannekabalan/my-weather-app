import controllers.HomeController
import play.api.routing.Router
import play.api.{ApplicationLoader, BuiltInComponentsFromContext, Logging}
import play.filters.HttpFiltersComponents
import router.Routes

class AppComponents(context:  ApplicationLoader.Context) extends BuiltInComponentsFromContext(context) with HttpFiltersComponents with controllers.AssetsComponents{

  override def router: Router = new Routes(
    httpErrorHandler,
    new HomeController(controllerComponents),
    assets
  )
}