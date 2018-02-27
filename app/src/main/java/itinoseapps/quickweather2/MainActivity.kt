package itinoseapps.quickweather2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val inputLocationValue = location.text.toString()
            val intent = Intent(this, WeatherResultActivity::class.java)

            if(inputLocationValue.isEmpty()){
                Toast.makeText(this,"Please input location",Toast.LENGTH_SHORT).show()
            }else {
                intent.putExtra("location", inputLocationValue)
                startActivity(intent)
            }
        }
    }
}

