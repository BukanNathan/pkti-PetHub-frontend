package com.example.converterapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pre_load.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class PreLoad : AppCompatActivity() {
    var mySqLitedb : SqLiteMyDBHelper? = null
    private var mhs = listOf(
        SqLiteUser(),
        SqLiteUser(),
        SqLiteUser(),
        SqLiteUser(),
        SqLiteUser(),
        SqLiteUser(),
        SqLiteUser(),
        SqLiteUser()
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_load)

        btn_yes.setOnClickListener {
            executeLoadData()
        }
        btn_no.setOnClickListener {
            finishThisActivity()
        }
    }

    private fun finishThisActivity() {
        var myfirstRunSharedPref = FirstRunSharedPref(this)
        myfirstRunSharedPref.firstRun = false
        this.finish()
    }

    private fun executeLoadData() {
        btn_no.isEnabled = false
        btn_yes.isEnabled = false
        myProgress.progress = 0
        myProgress.max = mhs.size
        mySqLitedb = SqLiteMyDBHelper(this)
        doAsync {
            for(userData in mhs){
                mySqLitedb?.adduser(userData)
                uiThread {
                    myProgress.progress += 1
                }
            }
            uiThread {
                finishThisActivity()
            }
        }
    }
}