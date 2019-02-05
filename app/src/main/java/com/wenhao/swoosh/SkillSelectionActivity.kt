package com.wenhao.swoosh

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class SkillSelectionActivity : BaseActivity() {

    var league = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill_selection)
        league = intent.getStringExtra(EXTRA_LEAGUE)
    }


}
