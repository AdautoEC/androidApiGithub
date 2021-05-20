package com.example.jya

import com.example.jya.api.response.response.IssueResponse
import java.io.Serializable

data class Item (val issue: IssueResponse): Serializable{
    val htmlUrl = issue.html_url
    val title = issue.title
    val userAvatarUrl = issue.user?.avatar_url
    val status = issue.state
    val createdAt = issue.created_at
    val body = issue.body
}