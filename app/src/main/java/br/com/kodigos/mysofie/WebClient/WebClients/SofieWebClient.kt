package br.com.kodigos.mysofie.WebClient.WebClients

import android.util.Log
import br.com.kodigos.mysofie.Model.ResultSofieBody
import br.com.kodigos.mysofie.Model.SofieBody
import br.com.kodigos.mysofie.Model.SofieList
import br.com.kodigos.mysofie.WebClient.WebClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SofieWebClient {

    fun getTask(
        success: (SofieList) -> Unit,
        fail: () -> Unit
    ) {

        val call = WebClient().sofieServices().GetTask()


        call.enqueue(object : Callback<SofieList> {
            override fun onResponse(
                call: Call<SofieList>?,
                response: Response<SofieList>?
            ) {
                response?.body()?.let {
                    val resultado = it

                    success(resultado)
                }
            }

            override fun onFailure(call: Call<SofieList?>, t: Throwable) {

                Log.e("Erro GetTask", t.message!!)
                fail()
            }
        })

    }


    fun postTask(
        body: SofieBody,
        success: (ResultSofieBody) -> Unit,
        fail: () -> Unit
    ) {

        val call = WebClient().sofieServices().PostTask(body)


        call.enqueue(object : Callback<ResultSofieBody> {
            override fun onResponse(
                call: Call<ResultSofieBody>?,
                response: Response<ResultSofieBody>?
            ) {
                response?.body()?.let {
                    val resultado = it

                    success(resultado)
                }
            }

            override fun onFailure(call: Call<ResultSofieBody?>, t: Throwable) {

                Log.e("Erro GetTask", t.message!!)
                fail()
            }
        })

    }

}