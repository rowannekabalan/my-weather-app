import play.api.{Application, ApplicationLoader, LoggerConfigurator}
import play.api.ApplicationLoader.Context

class AppLoader extends ApplicationLoader {
  def load(context: Context) = {
    new AppComponents(context).application
  }
}