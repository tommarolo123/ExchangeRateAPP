package com.example.exchangerateapp_android.logic.network

import com.example.exchangerateapp_android.logic.model.ExchangeRatesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object ExchangeRatesNetwork {
    private val exchangeRatesService = ServiceCreator.create<ExchangeRatesService>()
    suspend fun searchRates() = exchangeRatesService.searchRates().await()
    private suspend fun <T> Call<T>.await(): T{
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T>{
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(
                        RuntimeException("response body is null"))
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            }
            )
        }
    }
}