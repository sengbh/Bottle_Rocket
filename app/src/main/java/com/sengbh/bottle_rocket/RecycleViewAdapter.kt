package com.sengbh.bottle_rocket

import android.provider.ContactsContract
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup

//private val photos: ArrayList<Photo> = null

class RecycleViewAdapter(private val photos: ArrayList<ContactsContract.CommonDataKinds.Photo>) : RecyclerView.Adapter<RecycleViewAdapter.PhotoHolder>() {

    abstract override fun getItemCount(): photos.size

    override fun onBindViewHolder(holder: RecycleViewAdapter.PhotoHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewAdapter.PhotoHolder {
       val inflateView = parent.inflate(R.layout.recycleview_table, false)
        return PhotoHolder(inflateView)
    }
}

//1
class PhotoHolder (v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
    //2
    private var view: View = v
    private var photo: ContactsContract.CommonDataKinds.Photo? = null

    //3
    init {
        v.setOnClickListener(this)
    }

    //4
    override fun onClick(v: View) {
        Log.d("RecyclerView", "CLICK!")
    }

    companion object {
        //5
        private val PHOTO_KEY = "PHOTO"
    }
}
