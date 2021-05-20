package com.example.jya.api.response.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class IssueResponse (
        @SerializedName("html_url") val html_url: String = "",
        @SerializedName("title") val title: String = "",
        @SerializedName("user") val user: UserResponse? = null,
        @SerializedName("state") val state: String = "",
        @SerializedName("created_at") val created_at: String = "",
        @SerializedName("body") val body: String = ""
): Serializable