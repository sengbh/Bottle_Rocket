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


class RecycleViewAdapter(private val photos: List<Store>) : RecyclerView.Adapter<RecycleViewAdapter.PhotoHolder>() {

    override fun onBindViewHolder(holder: RecycleViewAdapter.PhotoHolder, position: Int) {
        val itemPhoto : Store = photos[position]
        holder.bindPhoto(itemPhoto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewAdapter.PhotoHolder {
        val inflateView = parent.inflate(R.layout.recycleview_table, false)
        return PhotoHolder(inflateView)
    }

    override fun getItemCount() = photos.size


    class PhotoHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v
        private var store: Store? = null

        fun bindPhoto(store: Store) {
            val holder = PhotoHolder(view)
            this.store = store
            Picasso.get().load(store.storeLogoURL).into(view.itemImage)
            view.itemDate.text = store.address
            view.itemDescription.text = store.phone

            holder?.store = store
        }

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            val context = itemView.context
            val showPhotoIntent = Intent(context, PhotoActivity::class.java).also {
                it.putExtra(
                    STORE_KEY,
                    store?.copy().toString()
                )
            }
            context.startActivity(showPhotoIntent)
            Log.d("RecyclerView",

                "CLICK!")
        }

        companion object {
            const val STORE_KEY = "Store"
        }
    }
}

