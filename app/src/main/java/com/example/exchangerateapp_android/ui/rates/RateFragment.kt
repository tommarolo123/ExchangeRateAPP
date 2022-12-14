package com.example.exchangerateapp_android.ui.rates

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exchangerateapp_android.R
import kotlinx.android.synthetic.main.fragment_rates.*


class RateFragment : Fragment(){
    val viewModel by lazy {ViewModelProvider(this).get(RatesViewModel::class.java) }
    private lateinit var adapter: RateAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_rates,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val layoutManager = LinearLayoutManager(activity)

        recyclerView.layoutManager = layoutManager
        adapter = RateAdapter(this,viewModel.rateList)
        recyclerView.adapter = adapter
        searchRateEdit.addTextChangedListener { editable ->
            val context = editable.toString()
            if(context.isNullOrEmpty()){
                viewModel.searchRates(context)
            }else{
                recyclerView.visibility = View.GONE
                bgImageView.visibility =View.VISIBLE
                viewModel.rateList.clear()
                adapter.notifyDataSetChanged()
            }
        }
        viewModel.rateLiveData.observe(viewLifecycleOwner, Observer{ result ->
            val places = result.getOrNull()
            if (places != null) {
                recyclerView.visibility = View.VISIBLE
                bgImageView.visibility = View.GONE
                viewModel.rateList.clear()
                viewModel.rateList.addAll(places)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(activity, "検索結果がなし", Toast.LENGTH_SHORT).show()
                result.exceptionOrNull()?.printStackTrace()
            }
        })


    }

}