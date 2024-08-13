package openweathermap

case class Coord(lon: Double, lat: Double)

case class Weather(id: Int, main: String, description: String, icon: String)

case class Main(
  temp: Double,
  feels_like: Double,
  pressure: Int,
  humidity: Int,
  temp_min: Double,
  temp_max: Double,
  sea_level: Option[Int],
  grnd_level: Option[Int]
)

case class Wind(speed: Double, deg: Int, gust: Option[Double])

case class Clouds(all: Int)

case class Rain(oneHour: Option[Double], threeHours: Option[Double])

case class Snow(oneHour: Option[Double], threeHours: Option[Double])

case class Sys(
  `type`: Option[Int],
  id: Option[Int],
  message: Option[Double],
  country: String,
  sunrise: Int,
  sunset: Int
)

case class WeatherResponse(
  coord: Coord,
  weather: List[Weather],
  base: String,
  main: Main,
  visibility: Option[Int],
  wind: Wind,
  clouds: Clouds,
  rain: Option[Rain],
  snow: Option[Snow],
  dt: Int,
  sys: Sys,
  timezone: Int,
  id: Int,
  name: String,
  cod: Int
)