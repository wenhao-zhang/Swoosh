package com.wenhao.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import com.wenhao.swoosh.Model.Player
import com.wenhao.swoosh.R
import com.wenhao.swoosh.Utilities.EXTRA_PLAYER
import com.wenhao.swoosh.Utilities.getState
import kotlinx.android.synthetic.main.activity_league_selection.*

class LeagueSelectionActivity : BaseActivity() {

    var player = Player("","")

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null){
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league_selection)
    }

    fun leagueNextClicked(view: View){
        if (!this.player.league.isEmpty()) {
            val skillActivity = Intent(this, SkillSelectionActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, this.player)
            startActivity(skillActivity)
        }else{
            Toast.makeText( this,"Please select a league!", Toast.LENGTH_SHORT).show()
        }
    }

    fun onMensClicked(view: View){
        this.player.league = getState(mensLeagueBtn)

        this.womensLeagueBtn.isChecked = false
        this.coedLeagueBtn.isChecked = false

    }

    fun onWomensClicked(view: View){
        this.player.league = getState(womensLeagueBtn)

        this.mensLeagueBtn.isChecked = false
        this.coedLeagueBtn.isChecked = false
    }

    fun onCoedClicked(view: View){
        this.player.league = getState(coedLeagueBtn)

        this.womensLeagueBtn.isChecked = false
        this.mensLeagueBtn.isChecked = false
    }

}
