package itinoseapps.quickweather2.lib

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class WeatherCore {

    val openWeatherAPIEndPoint = "http://api.openweathermap.org/data/2.5/"

    fun getCurrentWeather(location: String,key: String):String{
        return buildRequestUrl(location,"weather", key)
    }

    private fun buildRequestUrl(location:String,urlparam:String,key:String):String{
        val builder = StringBuilder()

        val requestUrl = builder.
                append(openWeatherAPIEndPoint)
                .append(urlparam)
                .append("?q=")
                .append(location)
                .append("&appid=")
                .append(key).toString()

        return sendRequest(requestUrl)
    }

    private fun sendRequest(url:String):String{
        val requestUrl = URL(url)

        val connection = requestUrl.openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        connection.setRequestProperty("ContentType", "application/json")
        connection.connect()

        return handleResponse(connection)
    }

    private fun handleResponse(connection: HttpURLConnection):String{
        var isr = if (connection.responseCode == HttpURLConnection.HTTP_OK)
            InputStreamReader(connection.inputStream)
        else
            InputStreamReader(connection.errorStream)
        val reader = BufferedReader(isr)
        val builder = StringBuilder()
        val line=reader.readLine()

        builder.append(line)

        reader.close()

        return builder.toString()
    }
}