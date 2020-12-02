package ru.maxdexter.mytranslator.network

import geekbrains.ru.translator.model.data.SearchResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("words/search")
    fun search(@Query("search") wordToSearch: String): Observable<List<SearchResult>>
}