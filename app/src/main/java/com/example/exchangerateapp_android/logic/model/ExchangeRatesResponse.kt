package com.example.exchangerateapp_android.logic.model

import com.google.gson.annotations.SerializedName


data class ExchangeRatesResponse(val disclaimer: String, val license: String,val timestamp: Int, val base:String, val rates: List <ExchangeRates>)
data class ExchangeRates(val areaName: String, val areaRate: Float)

