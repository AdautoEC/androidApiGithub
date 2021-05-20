package com.example.jya.api.response.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserResponse (
    @SerializedName("avatar_url") val avatar_url: String = ""
): Serializable