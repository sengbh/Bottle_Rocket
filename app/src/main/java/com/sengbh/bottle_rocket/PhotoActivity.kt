package com.sengbh.bottle_rocket

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.photo_details.*

class PhotoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.photo_details)

        val receiveData = intent.getStringExtra(RecycleViewAdapter.PhotoHolder.STORE_KEY)
        photo_info?.text = receiveData
    }

}
