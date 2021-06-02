package ru.maxdexter.mytranslator.repository

import ru.maxdexter.mytranslator.model.SearchResult
import io.reactivex.Observable
import ru.maxdexter.mytranslator.contracts.DataSource

class RoomDataBaseImplementation : DataSource<List<SearchResult>> {

    override fun getData(word: String): Observable<List<SearchResult>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
