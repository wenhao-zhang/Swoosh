package com.wenhao.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.wenhao.swoosh.Utilities.EXTRA_LEAGUE
import com.wenhao.swoosh.R
import com.wenhao.swoosh.Utilities.EXTRA_SKILL
import com.wenhao.swoosh.Utilities.getState
import kotlinx.android.synthetic.main.activity_skill_selection.*

class SkillSelectionActivity : BaseActivity() {

    var league = ""
    var skill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill_selection)
        this.league = intent.getStringExtra(EXTRA_LEAGUE)
    }

    fun onFinishClicked(view: View){
        if (!this.skill.isEmpty()) {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_LEAGUE, this.league)
            finishActivity.putExtra(EXTRA_SKILL, this.skill)
            startActivity(finishActivity)
        }else{
            Toast.makeText( this,"Please select a skill level!", Toast.LENGTH_SHORT).show()
        }

    }

    fun onBeginnerClicked(view: View){
        ballerBtn.isChecked = false
        this.skill = getState(beginnerBtn)
    }

    fun onBallerClicked(view: View){
        beginnerBtn.isChecked = false
        this.skill = getState(ballerBtn)
}


}
