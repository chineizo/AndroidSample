package com.example.chinedunweze.androidsample.data

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable

/**
 * Class that represents Data from API
 */
class Data : Serializable {
    @SerializedName("id")
    @Expose
    val id: String? = null

    @SerializedName("name")
    @Expose
    val name: String? = null

    @SerializedName("full_name")
    @Expose
    val fullName: String? = null

    @SerializedName("owner")
    @Expose
    val owner: Owner? = null

    @SerializedName("watchers_count")
    @Expose
    val watchers: Int = 0

    @Expose
    val forks: Int = 0

    @SerializedName("open_issues")
    @Expose
    val openIssues: Int = 0


    @SerializedName("updated_at")
    @Expose
    val lastUpdate: String? = null

    @SerializedName("created_at")
    @Expose
    val creationDate: String? = null


    @SerializedName("url")
    @Expose
    val url: String? = null

}