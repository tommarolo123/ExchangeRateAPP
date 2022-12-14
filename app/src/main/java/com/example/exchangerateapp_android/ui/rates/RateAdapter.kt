package com.example.exchangerateapp_android.ui.rates
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.exchangerateapp_android.R
import com.example.exchangerateapp_android.logic.model.ExchangeRates

class RateAdapter(private val fragment: Fragment,private val rateList: List<ExchangeRates>): RecyclerView.Adapter<RateAdapter.ViewHolder>(){
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val areaName : TextView = view.findViewById(R.id.areaName)
        val areaRate : TextView = view.findViewById(R.id.areaRate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rate_item,parent,false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rate = rateList[position]
        holder.areaName.text = rate.areaName
        holder.areaRate.text = rate.areaRate.toString()
    }

    override fun getItemCount() = 10
}