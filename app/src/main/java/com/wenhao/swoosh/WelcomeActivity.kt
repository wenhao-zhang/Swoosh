package com.wenhao.swoosh

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        getStartedBtn.setOnClickListener{
            val leagueIntent = Intent(this, LeagueSelectionActivity::class.java)
            startActivity(leagueIntent)
        }
    }
}
