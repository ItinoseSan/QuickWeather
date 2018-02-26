package itinoseapps.quickweather2.lib

import org.json.JSONObject

class JSONDecoder{
    fun decode(json:String):String{
        val response = JSONObject(json)
        val weathersComponent = response.getJSONArray("weather").getJSONObject(0)
        val weather = weathersComponent.getString("description")
        return weather.toString()
    }
}