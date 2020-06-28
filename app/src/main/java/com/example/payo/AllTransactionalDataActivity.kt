package com.example.payo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AllTransactionalDataActivity : AppCompatActivity(), AllTransAdapter.Onclick {
    lateinit var recyclerView: RecyclerView
    lateinit var allTransAdapter: AllTransAdapter
    lateinit var arrayList: ArrayList<DataModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.all_transactional_data_activity)
        recyclerView = findViewById(R.id.recyclerView)
        allTransAdapter = AllTransAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = allTransAdapter
        arrayList = ArrayList<DataModel>()
        for (i in 0..20) {
            arrayList.add(DataModel(tag = "Tag$i"))
        }
        allTransAdapter.setListData(arrayList)
        allTransAdapter.notifyDataSetChanged()
        // recyclerView.

    }

    override fun onclik(position: Int) {

        arrayList[position].tag = "changed tag$position"
        allTransAdapter.setListData(arrayList)
        allTransAdapter.notifyDataSetChanged()

    }
}