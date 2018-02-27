package itinoseapps.quickweather2.lib

import org.json.JSONObject

class JSONDecoder{

    fun decode(json:String):String {
        when (json) {
            "{\"cod\":\"404\",\"message\":\"city not found\"}" -> return "not found"
            else -> return parse(json)
        }
    }

    fun parse(json: String):String{
        val response = JSONObject(json)
        val weathersComponent = response.getJSONArray("weather").getJSONObject(0)
        val weather = weathersComponent.getString("main")
        return weather.toString()
    }
}