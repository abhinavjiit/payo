package com.example.payo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AllTransactionalDataActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var allTransAdapter: AllTransAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.all_transactional_data_activity)
        recyclerView = findViewById(R.id.recyclerView)
        allTransAdapter = AllTransAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = allTransAdapter
        // recyclerView.

    }
}