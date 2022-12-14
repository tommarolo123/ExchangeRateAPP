package com.example.exchangerateapp_android.logic.network

import com.example.exchangerateapp_android.ExchangeRateApplication
import com.example.exchangerateapp_android.logic.model.ExchangeRatesResponse
import retrofit2.Call
import retrofit2.http.GET

interface ExchangeRatesService {
    @GET("latest.json?app_id=${ExchangeRateApplication.TOKEN}")
    fun searchRates(): Call<ExchangeRatesResponse>
}