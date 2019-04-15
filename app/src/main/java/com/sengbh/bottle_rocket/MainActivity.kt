package com.sengbh.bottle_rocket

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



private val retrofit = Retrofit.Builder()
    .baseUrl("http://sandbox.bottlerocketapps.com/BR_Android_CodingExam_2015_Server/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
private val service = retrofit.create(ParsingRetrofit::class.java)

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: RecycleViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        linearLayoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = linearLayoutManager
        service.getStore().enqueue(object : Callback<Stores>{
            override fun onFailure(call: Call<Stores>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<Stores>, response: Response<Stores>) {
                adapter = RecycleViewAdapter(response.body()!!.stores)
                recycler_view.adapter = adapter
            }
        })
    }
}
