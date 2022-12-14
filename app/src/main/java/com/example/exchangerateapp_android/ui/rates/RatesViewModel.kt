package com.example.exchangerateapp_android.ui.rates

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.exchangerateapp_android.logic.Respository
import com.example.exchangerateapp_android.logic.model.ExchangeRates
import retrofit2.http.Query

class RatesViewModel : ViewModel(){
    private val searchLiveData = MutableLiveData<String>()
    val rateList = ArrayList<ExchangeRates>()
    val rateLiveData = Transformations.switchMap(searchLiveData){ query ->
        Respository.searchRates()
    }

    fun searchRates(query: String){
        searchLiveData.value = query
    }
}