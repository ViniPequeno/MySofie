package br.com.kodigos.mysofie.WebClient.Services

import br.com.kodigos.mysofie.Model.ResultSofieBody
import br.com.kodigos.mysofie.Model.SofieBody
import br.com.kodigos.mysofie.Model.SofieList
import retrofit2.Call
import retrofit2.http.*

interface SofieService {
    @GET("task")
    fun GetTask(): Call<SofieList>

    @POST("task")
    fun PostTask(@Body body: SofieBody): Call<ResultSofieBody>
}