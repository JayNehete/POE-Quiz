package jay.nehete.poequiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username = intent.getStringExtra(Constants.USER_NAME)
        tvName.text = username

        val total = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correct = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        tvScore.text = "Score : $correct out of $total"

        btnOver.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}