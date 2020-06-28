package com.example.payo

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ExpensesAndIncomeActivity : AppCompatActivity() {
    lateinit var expensesAndIncomeAdapter: ExpensesAndIncomeAdapter
    lateinit var monthly: Button
    lateinit var daily: Button
    lateinit var recyclerview: RecyclerView
    private lateinit var arrayList: ArrayList<DataModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.expenses_income_layout)


        monthly = findViewById(R.id.monthly)
        daily = findViewById(R.id.daily)
        recyclerview = findViewById(R.id.recyclerview)
        arrayList = ArrayList()
        for (i in 0..12) {
            val expenses = (20.0 * Math.random()).toFloat()
            val dataModel = DataModel()
            dataModel.expense = expenses
            dataModel.income = 100 - expenses
            arrayList.add(dataModel)
        }
        expensesAndIncomeAdapter = ExpensesAndIncomeAdapter(this)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = expensesAndIncomeAdapter
        expensesAndIncomeAdapter.setListData(arrayList)
        expensesAndIncomeAdapter.notifyDataSetChanged()
        monthly.setOnClickListener {
            arrayList.clear()
            for (i in 0..12) {
                val expenses = (20.0 * Math.random()).toFloat()
                val dataModel = DataModel()
                dataModel.expense = expenses
                dataModel.income = 100 - expenses
                arrayList.add(dataModel)
            }
            expensesAndIncomeAdapter.setListData(arrayList)
            expensesAndIncomeAdapter.notifyDataSetChanged()
        }
        daily.setOnClickListener {
            arrayList.clear()
            for (i in 0..30) {
                val expenses = (20.0 * Math.random()).toFloat()
                val dataModel = DataModel()
                dataModel.expense = expenses
                dataModel.income = 100 - expenses
                arrayList.add(dataModel)
            }
            expensesAndIncomeAdapter.setListData(arrayList)
            expensesAndIncomeAdapter.notifyDataSetChanged()
        }

    }
}