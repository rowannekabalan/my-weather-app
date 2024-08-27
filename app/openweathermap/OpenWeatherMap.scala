package openweathermap

import play.api.libs.ws.{WSClient, WSRequest}

import scala.concurrent.{ExecutionContext, Future}


object OpenWeatherMap {
  def getWeather(lat: Double, lon: Double, apiKey: String, ws: WSClient)(implicit ec: ExecutionContext): Future[WeatherResponse]= {
    val url = s"http://api.openweathermap.org/data/3.0/weather"
    val request: WSRequest = ws.url(url).withQueryStringParameters(
      "lat" -> lat.toString,
      "lon" -> lon.toString,
      "appid" -> apiKey,
      "units" -> "metric"
    )

    request.get().map { response =>
      ???
    }


  }

  /**
   *  http://api.openweathermap.org/geo/1.0/direct?q={city name},{state code},{country code}&limit={limit}&appid={API key}
   *
   */
  def geoCode(city: String, apiKey: String, ws: WSClient)(implicit ec: ExecutionContext): Future[(Double, Double)] = {
    val url = s"http://api.openweathermap.org/geo/1.0/direct"
    val request: WSRequest = ws.url(url).withQueryStringParameters(
      "q" -> city,
      "limit" -> "1", // Get the first matching result
      "appid" -> apiKey
    )

    request.get().map { response =>
      ???
    }
  }
}
