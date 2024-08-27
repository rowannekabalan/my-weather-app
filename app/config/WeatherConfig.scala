package config

import scala.util.Try

case class WeatherConfig(key: String)

object WeatherConfig {
  def loadConfig(): Try[WeatherConfig] = {
    Try {
      val file = new java.io.File(System.getProperty("user.home") + "/.gu/weather-app.conf")
      val config = com.typesafe.config.ConfigFactory.parseFile(file)
      WeatherConfig(config.getString("key"))
    }
  }
}
