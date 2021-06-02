package ru.maxdexter.mytranslator.repository

import ru.maxdexter.mytranslator.model.SearchResult
import io.reactivex.Observable
import ru.maxdexter.mytranslator.contracts.DataSource
import ru.maxdexter.mytranslator.network.RetrofitImplementation

class DataSourceRemote(private val remoteProvider: RetrofitImplementation = RetrofitImplementation()) :
    DataSource<List<SearchResult>> {

    override fun getData(word: String): Observable<List<SearchResult>> =
        remoteProvider.getData(word)
}
