package com.example.chinedunweze.androidsample.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Class the represents Owner in the Data class
 */
class Owner : Serializable {
    @SerializedName("avatar_url")
    @Expose
    val avatarUrl: String = ""
}