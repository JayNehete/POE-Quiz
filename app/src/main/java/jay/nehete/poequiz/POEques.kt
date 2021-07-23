package jay.nehete.poequiz

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_p_o_eques.*

class POEques : AppCompatActivity(), View.OnClickListener{

    private var currPos : Int = 1
    private var quesList : ArrayList<Qustion>? = null
    private var selectedPos : Int = 0
    private var correctAnswer : Int = 0
    private var userName: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p_o_eques)

        userName = intent.getStringExtra(Constants.USER_NAME)

        quesList = Constants.getQues()

        setQuestion()
    }

    private fun setQuestion(){
        val question =  quesList!![currPos-1]

        setDefault()

        if(currPos == quesList!!.size){
            bSubmit.text = "FINISH"
        }else{
            bSubmit.text = "SUBMIT"
        }

        opt1.setOnClickListener(this)
        opt2.setOnClickListener(this)
        opt3.setOnClickListener(this)
        opt4.setOnClickListener(this)
        bSubmit.setOnClickListener(this)

        pbProg.progress = currPos
        tvProg.text = "$currPos" + "/" + pbProg.max

        tvQues.text = question.question

        ivImg.setImageResource(question.image)
        opt1.text = question.op1
        opt2.text = question.op2
        opt3.text = question.op3
        opt4.text = question.op4
    }

    private fun setDefault(){
        val options = ArrayList<TextView>()
        options.add(0,opt1)
        options.add(1,opt2)
        options.add(2,opt3)
        options.add(3,opt4)

        for(option in options){
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,
                    R.drawable.default_option
            )
        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.opt1->{
                selectedOptionView(opt1,1)
            }
            R.id.opt2->{
                selectedOptionView(opt2,2)
            }
            R.id.opt3->{
                selectedOptionView(opt3,3)
            }
            R.id.opt4->{
                selectedOptionView(opt4,4)
            }
            R.id.bSubmit ->{
                if(selectedPos==0){
                    currPos++

                    when{
                        currPos<=quesList!!.size -> {
                            setQuestion()
                        }else->{
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, userName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, correctAnswer)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, quesList!!.size)
                            startActivity(intent)
                        }
                    }
                }else{
                    val question = quesList?.get(currPos-1)
                    if(question!!.ans != selectedPos){
                        answerView(selectedPos, R.drawable.wrong_option)
                    }else{
                        correctAnswer++
                    }
                    answerView(question.ans, R.drawable.correct_option)

                    if(currPos==quesList!!.size){
                        bSubmit.text = "FINISH"
                    }else{
                        bSubmit.text = "NEXT QUESTION"
                    }
                    selectedPos=0
                }
            }
        }
    }
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        setDefault()
        selectedPos = selectedOptionNum
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,
                R.drawable.select_option
        )
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1->{
                opt1.background = ContextCompat.getDrawable(
                        this,drawableView
                )
            }
            2->{
                opt2.background = ContextCompat.getDrawable(
                        this,drawableView
                )
            }
            3->{
                opt3.background = ContextCompat.getDrawable(
                        this,drawableView
                )
            }
            4->{
                opt4.background = ContextCompat.getDrawable(
                        this,drawableView
                )
            }
        }
    }
}