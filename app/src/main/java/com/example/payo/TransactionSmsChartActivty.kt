package com.example.payo

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate


class TransactionSmsChartActivty : AppCompatActivity() {
    lateinit var pieChart: PieChart
    lateinit var pieData: PieData
    lateinit var pieDataSet: PieDataSet
    lateinit var arrayListEntries: ArrayList<PieEntry>
    lateinit var expenseAndIncome: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.transactional_activity)
        pieChart = findViewById(R.id.pieChart)
        expenseAndIncome = findViewById(R.id.expenseAndIncome)
        arrayListEntries = ArrayList()
        arrayListEntries.add(PieEntry(20f, "expenses"))
        arrayListEntries.add(PieEntry(80f, "income"))
        pieDataSet = PieDataSet(arrayListEntries, "abhinav")
        pieData = PieData(pieDataSet)
        pieChart.data = pieData;
        pieDataSet.colors = (ColorTemplate.JOYFUL_COLORS).toMutableList()
        pieDataSet.sliceSpace = 2f;
        pieDataSet.valueTextColor = Color.WHITE;
        pieDataSet.valueTextSize = 10f;
        pieDataSet.sliceSpace = 5f;

        expenseAndIncome.setOnClickListener {
            startActivity(Intent(this, ExpensesAndIncomeActivity::class.java))
        }

    }
}

