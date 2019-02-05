package com.wenhao.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.wenhao.swoosh.Utilities.EXTRA_LEAGUE
import com.wenhao.swoosh.R
import com.wenhao.swoosh.Utilities.getState
import kotlinx.android.synthetic.main.activity_league_selection.*

class LeagueSelectionActivity : BaseActivity() {

    var league = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league_selection)
    }

    fun leagueNextClicked(view: View){
        if (!this.league.isEmpty()) {
            val skillActivity = Intent(this, SkillSelectionActivity::class.java)
            skillActivity.putExtra(EXTRA_LEAGUE, league)
            startActivity(skillActivity)
        }else{
            Toast.makeText( this,"Please select a league!", Toast.LENGTH_SHORT).show()
        }
    }

    fun onMensClicked(view: View){
       this.league = getState(mensLeagueBtn)

        this.womensLeagueBtn.isChecked = false
        this.coedLeagueBtn.isChecked = false

    }

    fun onWomensClicked(view: View){
        this.league = getState(womensLeagueBtn)

        this.mensLeagueBtn.isChecked = false
        this.coedLeagueBtn.isChecked = false
    }

    fun onCoedClicked(view: View){
        this.league = getState(coedLeagueBtn)

        this.womensLeagueBtn.isChecked = false
        this.mensLeagueBtn.isChecked = false
    }

}
