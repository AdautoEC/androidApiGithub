package com.example.jya.api.request.request

import com.example.jya.api.response.response.IssueResponse
import io.reactivex.Observable
import retrofit2.http.*

interface IssueApiService {
    @Headers("Content-Type: application/json")
    @GET("issues")
    fun getIssue(): Observable<List<IssueResponse>>
}