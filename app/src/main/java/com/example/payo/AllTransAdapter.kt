package com.example.payo


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.expenses_income_adapter.view.*

class AllTransAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var listData: List<DataModel>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.expenses_income_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 20
    }

    fun setListData(listData: List<DataModel>) {
        this.listData = listData
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            val string = arrayOf("+", "-")
            holder.amount.text = string.random().plus("amount")
        }
    }

    class ViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
        val date: TextView = mView.date
        val amount: TextView = mView.amount
        val textViewTg: TextView = mView.textViewTg
    }
}