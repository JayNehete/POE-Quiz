package jay.nehete.poequiz

object Constants{

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQues(): ArrayList<Qustion>{
        val ques = ArrayList<Qustion>()

        val que1 = Qustion(
                1,
                "Identify the Gem",
                R.drawable.earth,
                "Ground Slam",
                "Earth Shatter",
                "Perforate",
                "Volatile Dead",
                2
        )
        ques.add(que1)

        val que2 = Qustion(
                2,
                "Identify the Gem",
                R.drawable.hop,
                "Herald Of Purity",
                "Herald of Thunder",
                "Herald of Agony",
                "Herald of Ash",
                1
        )
        ques.add(que2)

        val que3 = Qustion(
                3,
                "Identify the Gem",
                R.drawable.penance_brand,
                "Arcanist Brand",
                "Armageddon Brand",
                "Penance Brand",
                "Volatile Dead",
                3
        )
        ques.add(que3)

        val que4 = Qustion(
                4,
                "Identify the Gem",
                R.drawable.exsan,
                "Exsanguiate",
                "Reap",
                "Sunder",
                "Herald of Ash",
                1
        )
        ques.add(que4)

        val que5 = Qustion(
                5,
                "Identify the Gem",
                R.drawable.causticarrow,
                "Toxic Rain",
                "Animate Weapon",
                "Hatred",
                "Caustic Arrow",
                4
        )
        ques.add(que5)

        return ques
    }
}