package com.sengbh.bottle_rocket

import android.content.Intent
import android.provider.ContactsContract
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycleview_table.view.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//private val photos: ArrayList<Photo> = null

private val ContactsContract.CommonDataKinds.Photo.url: Any
    get() {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://sandbox.bottlerocketapps.com/BR_Android_CodingExam_2015_Server/stores.json")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ParsingRetrofit::class.java)

    }

class RecycleViewAdapter(private val photos: ArrayList<ContactsContract.CommonDataKinds.Photo>) : RecyclerView.Adapter<RecycleViewAdapter.PhotoHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewAdapter.PhotoHolder {
        val inflateView = parent.inflate(R.layout.recycleview_table, false)
        return PhotoHolder(inflateView)
    }

    override fun onBindViewHolder(holder: RecycleViewAdapter.PhotoHolder, position: Int) {
        val itemPhoto = photos[position]
        holder.bindPhoto(itemPhoto)

    }

    override fun getItemCount() = photos.size


    class PhotoHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v
        private var photo: ContactsContract.CommonDataKinds.Photo? = null

        fun bindPhoto(photo: ContactsContract.CommonDataKinds.Photo) {
            this.photo = photo
            var into: Any = Picasso.get().load(photo.url).into(view.itemImage)
            view.itemDate.text = photo.toString()
            view.itemDescription.text = photo.toString()
        }

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            val context = itemView.context
            val showPhotoIntent = Intent(context, PhotoActivity::class.java)
            showPhotoIntent.putExtra(PHOTO_KEY, photo)
            context.startActivity(showPhotoIntent)
            Log.d("RecyclerView", "CLICK!")
        }

        companion object {
            private const val PHOTO_KEY = "PHOTO"
        }
    }
}

private fun Any.into(itemImage: ImageView?): Any {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

private fun Picasso.load(url: Any): Any {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

private fun Intent.putExtra(photO_KEY: String, photo: ContactsContract.CommonDataKinds.Photo?) {

}
