package ru.maxdexter.mytranslator.repository

import ru.maxdexter.mytranslator.model.SearchResult
import io.reactivex.Observable
import ru.maxdexter.mytranslator.contracts.DataSource

class DataSourceLocal(private val remoteProvider: RoomDataBaseImplementation = RoomDataBaseImplementation()) :
    DataSource<List<SearchResult>> {

    override fun getData(word: String): Observable<List<SearchResult>> =
        remoteProvider.getData(word)
}
