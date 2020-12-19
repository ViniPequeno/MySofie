package br.com.kodigos.mysofie.WebClient

import br.com.kodigos.mysofie.BuildConfig
import br.com.kodigos.mysofie.WebClient.Services.SofieService
import br.com.kodigos.mysofie.WebClient.WebClients.SofieWebClient
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class WebClient {

    private val URL = BuildConfig.BASE_URL

    private val cliente: OkHttpClient =
        OkHttpClient()
            .newBuilder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build()


    private val retrofit =
        Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create()).client(cliente)
            .build()

    fun sofieServices() = retrofit.create(SofieService::class.java)
}