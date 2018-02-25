package itinoseapps.quickweather2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import itinoseapps.quickweather2.lib.JSONDecoder
import itinoseapps.quickweather2.lib.WeatherCore
import kotlinx.android.synthetic.main.activity_weather_result.*

class WeatherResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_result)
        object :HttpAsyncTask(){
            override fun doInBackground(vararg params: Void): String? {
                val weather = WeatherCore()
                val json = weather.getCurrentWeather("London","API KEY")
                val jsondecoder = JSONDecoder()
                return jsondecoder.decode(json)
            }

            override fun onPostExecute(result: String?) {
                current_weather.text = "Current Weather is "+result
            }
        }.execute()
        backbutton.setOnClickListener{
            finish()
        }
    }
}
