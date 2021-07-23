package jay.nehete.poequiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        btnStart.setOnClickListener{
              if(perName.text.toString().isEmpty()) {
                  Toast.makeText(this, "Please enter Name", Toast.LENGTH_SHORT).show()
              }else{
                  val intent = Intent(this, POEques::class.java)
                  intent.putExtra(Constants.USER_NAME, perName.text.toString())
                  startActivity(intent)
                  finish()
              }
        }
    }
}