package com.bignerdranch.android.fetchrewardscodingproblem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// Basic setup for Retrofit
class MainActivity : AppCompatActivity() {
    private lateinit var apiInterface: Api
    //Recycler to display the UI of the list and Adapater to display the data in the RecyclerView
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Links the RecyclerView to the XML and displays it in a vertical format
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        getApiInterface()
        getItem()
    }
    private fun getApiInterface(){
        apiInterface = RetrofitInstance.getInstance().create(Api::class.java)
    }
    private fun getItem(){
        val call = apiInterface.getItem()
        call.enqueue(object : Callback<List<Items>>{
            override fun onResponse(call: Call<List<Items>>, response: Response<List<Items>>) {
                if(response.isSuccessful && response.body() != null){
                    // sorts the list by removing blank/null names and sort first by listId and then id(name and id are the same number)
                    val items = response.body()!!.filter { !it.name.isNullOrBlank() }
                    val sortedItems = items.sortedWith(compareBy({it.listId},{it.id}))

                    //Passes the sorted list data to adapater which will tell RecyclerView to display the sorted list
                    adapter = ItemAdapter(sortedItems)
                    recyclerView.adapter = adapter
                }
            }
            //Error handling when network call fails
            override fun onFailure(call: Call<List<Items>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}