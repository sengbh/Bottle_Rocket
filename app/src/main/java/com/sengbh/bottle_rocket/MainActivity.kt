package com.sengbh.bottle_rocket

import android.os.Bundle
import android.provider.ContactsContract
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

private lateinit var linearLayoutManager: LinearLayoutManager
private lateinit var adapter: RecycleViewAdapter

class MainActivity : AppCompatActivity() {

    private val photosList: ArrayList<ContactsContract.CommonDataKinds.Photo> = null!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        linearLayoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = linearLayoutManager
        adapter = RecycleViewAdapter(this.photosList)
        recycler_view.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        if (photosList.size == 0)
            requePhoto()
    }

    private fun requePhoto() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun receiveNewPhoto(newPhoto: ContactsContract.Contacts.Photo){
        runOnUiThread{
            photosList.add(newPhoto)
            adapter.notifyItemInserted(photosList.size-1)
        }
    }
}

private fun <E> java.util.ArrayList<E>.add(newPhoto: ContactsContract.Contacts.Photo) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}
