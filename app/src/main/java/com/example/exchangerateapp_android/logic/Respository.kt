package com.example.exchangerateapp_android.logic

import android.util.Log
import androidx.lifecycle.liveData
import com.example.exchangerateapp_android.logic.model.ExchangeRatesResponse
import com.example.exchangerateapp_android.logic.network.ExchangeRatesNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.RuntimeException

object Respository {
    fun searchRates() = liveData(Dispatchers.IO){
        val result = try {
            val exchangeRatesResponse = ExchangeRatesNetwork.searchRates()
            Log.e(exchangeRatesResponse.toString(),"exchangeRateResponse")
            if (!exchangeRatesResponse.base.isNullOrEmpty()){
                Log.e(exchangeRatesResponse.toString(),"exchangeRateResponse_true")
                val rates = exchangeRatesResponse.rates
                Result.success(rates)
            } else {
                Log.e(exchangeRatesResponse.toString(),"exchangeRateResponse_false")
                Result.failure(RuntimeException("response status is error"))
            }
        }catch (e:Exception){
            Result.failure(e)
        }
        emit(result)
    }

}