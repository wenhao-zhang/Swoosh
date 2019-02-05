package com.wenhao.swoosh

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.ToggleButton
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
            val text = "Please select a league!"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(this, text, duration)

            toast.show()
        }
    }

    fun onMensClicked(view: View){
       this.setLeague(this.mensLeagueBtn, "mens")

        this.womensLeagueBtn.isChecked = false
        this.coedLeagueBtn.isChecked = false

    }

    fun onWomensClicked(view: View){
        this.setLeague(this.womensLeagueBtn, "womens")

        this.mensLeagueBtn.isChecked = false
        this.coedLeagueBtn.isChecked = false
    }

    fun onCoedClicked(view: View){
        this.setLeague(this.coedLeagueBtn, "co-ed")

        this.womensLeagueBtn.isChecked = false
        this.mensLeagueBtn.isChecked = false
    }

    fun setLeague(btn: ToggleButton, league: String){
        if (btn.isChecked) {
            this.league = league
        }else{
            this.league = ""
        }
    }
}
