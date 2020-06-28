package com.example.payo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AllTransactionalDataActivity : AppCompatActivity(), AllTransAdapter.Onclick {
    lateinit var recyclerView: RecyclerView
    lateinit var allTransAdapter: AllTransAdapter
    lateinit var searchTag: EditText
    lateinit var searchButton: Button
    lateinit var arrayList: ArrayList<DataModel>
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.all_transactional_data_activity)
        recyclerView = findViewById(R.id.recyclerView)
        searchButton = findViewById(R.id.searchButton)
        searchTag = findViewById(R.id.searchTag)
        allTransAdapter = AllTransAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = allTransAdapter
        arrayList = ArrayList<DataModel>()
        for (i in 0..20) {
            arrayList.add(DataModel(tag = "Tag$i"))
        }
        allTransAdapter.setListData(arrayList)
        allTransAdapter.notifyDataSetChanged()
        searchButton.setOnClickListener {
            val Tag = searchTag.text.toString()
                .trim()
            if (Tag.isNotBlank()) {

                for (i in 0 until arrayList.size - 1) {
                    if (arrayList[i].tag == Tag) {
                        (recyclerView.layoutManager as LinearLayoutManager).smoothScrollToPosition(
                            recyclerView,
                            RecyclerView.State(),
                            i
                        )
                        //     recyclerView.scrollToPosition(i)
                        break
                    } else {
                        count++

                    }
                }
                if (count == arrayList.size-1) {
                    Toast.makeText(this, "no tag found", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(this, "empty tag", Toast.LENGTH_SHORT).show()
            }


        }

    }

    override fun onclik(position: Int) {

        arrayList[position].tag = "changed tag$position"
        allTransAdapter.setListData(arrayList)
        allTransAdapter.notifyDataSetChanged()

    }
}