package com.example.wakeupbuddy

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.com.example.wakeupbuddy.models.AlarmModel

interface MyAPI {
    @GET("/alarms")
    suspend fun getAllAlarms(): List<AlarmModel> //Call class not needed if call is suspended/in a coroutine -> return data directly

    @GET("/alarms/{id}")
    suspend fun getAlarm(@Path("id") id: String): AlarmModel

    companion object {
        private const val baseUrl =
            "http://192.168.178.31:8080/" //todo: use internal ip and port of pc to access localhost api

        fun create(): MyAPI {
            val gson: Gson = GsonBuilder().setLenient().create()
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
            return retrofit.create(MyAPI::class.java)
        }
    }

}
