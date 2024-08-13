package openweathermap

import play.api.libs.ws.WSClient

import scala.concurrent.Future

object OpenWeatherMap {
  def getWeather(lat: Double, lon: Double, apiKey: String, ws: WSClient): Future[WeatherResponse]= {
    ???
  }

  /**
   *  http://api.openweathermap.org/geo/1.0/direct?q={city name},{state code},{country code}&limit={limit}&appid={API key}
   *
   */
  def geoCode(city: String, apiKey: String, ws: WSClient): Future[(Double, Double)] = {
    ???
  }

}
