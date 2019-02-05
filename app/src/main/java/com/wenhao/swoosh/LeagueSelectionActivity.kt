package com.wenhao.swoosh

import android.content.Intent
import android.os.Bundle
import android.view.View

class LeagueSelectionActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league_selection)
    }

    fun leagueNextClicked(view: View){
        val skillActivity = Intent(this, SkillSelectionActivity::class.java)
        startActivity(skillActivity)
    }
}
