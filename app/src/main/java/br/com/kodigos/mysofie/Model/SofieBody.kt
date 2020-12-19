package br.com.kodigos.mysofie.Model

import com.google.gson.annotations.SerializedName

data class SofieBody(
    var _id: String,
    var title: String,
    var email: String,
    var description: String,
    @SerializedName("when") var whenDate: String
)