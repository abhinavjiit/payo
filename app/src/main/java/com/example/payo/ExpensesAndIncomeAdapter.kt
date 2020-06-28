package com.example.payo


import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.expenses_income_activity_layout.view.*

class ExpensesAndIncomeAdapter(val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var listData: List<DataModel>? = null
    lateinit var pieData: PieData
    lateinit var pieDataSet: PieDataSet
    var arrayListEntries = ArrayList<PieEntry>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.expenses_income_activity_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (listData.isNullOrEmpty()) 0 else listData?.size!!
    }

    fun setListData(listData: List<DataModel>) {
        this.listData = listData
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            arrayListEntries.clear()
            listData?.get(position)?.expense?.let {
                arrayListEntries.add(PieEntry(it, "expense"))
            }
            listData?.get(position)?.income?.let {
                arrayListEntries.add(PieEntry(it, "income"))
            }
            pieDataSet = PieDataSet(arrayListEntries, "")
            pieData = PieData(pieDataSet)
            holder.pieChart.data = pieData
            pieDataSet.colors = (ColorTemplate.JOYFUL_COLORS).toMutableList()
            pieDataSet.sliceSpace = 2f;
            pieDataSet.valueTextColor = Color.WHITE;
            pieDataSet.valueTextSize = 10f;
            pieDataSet.sliceSpace = 5f;
            holder.view.setOnClickListener {
                context.startActivity(Intent(context, AllTransactionalDataActivity::class.java))
            }
            holder.monthOrdaily.text = listData?.get(position)?.tag

        }
    }

    class ViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
        val pieChart: PieChart = mView.pieChart
        val view: View = mView.view
        val monthOrdaily = mView.monthOrdaily

    }
}