package com.wenhao.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.wenhao.swoosh.Model.Player

import com.wenhao.swoosh.R
import com.wenhao.swoosh.Utilities.EXTRA_PLAYER
import com.wenhao.swoosh.Utilities.getState
import kotlinx.android.synthetic.main.activity_skill_selection.*

class SkillSelectionActivity : BaseActivity() {

    private lateinit var player: Player


    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill_selection)
        this.player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null){
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    fun onFinishClicked(view: View){
        if (!this.player.skill.isEmpty()) {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER, this.player)
            startActivity(finishActivity)
        }else{
            Toast.makeText( this,"Please select a skill level!", Toast.LENGTH_SHORT).show()
        }

    }

    fun onBeginnerClicked(view: View){
        ballerBtn.isChecked = false
        this.player.skill = getState(beginnerBtn)
    }

    fun onBallerClicked(view: View){
        beginnerBtn.isChecked = false
        this.player.skill = getState(ballerBtn)
}


}
