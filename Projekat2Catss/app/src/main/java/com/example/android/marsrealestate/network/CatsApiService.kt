

package com.example.android.marsrealestate.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

enum class CatsApiFilter(val value: String) {
    SHOW_UDOMI("udomi"),
    SHOW_UDOMLJENE("udomljene"),
    SHOW_ALL("all") }

private const val BASE_URL = "https://api.thecatapi.com/v1/images/"


private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()


private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()


interface CatsApiService {

    @GET("search?limit=100&page=100&order=DESC")
    suspend fun dajMacke(@Query("filter") type: String): List<Macke>
}


object MackeApi {
    val RETROFIT_SERVICE : CatsApiService by lazy { retrofit.create(CatsApiService::class.java) }
}
