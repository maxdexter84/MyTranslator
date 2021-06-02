package ru.maxdexter.mytranslator.repository

import ru.maxdexter.mytranslator.model.SearchResult
import io.reactivex.Observable
import ru.maxdexter.mytranslator.contracts.DataSource
import ru.maxdexter.mytranslator.contracts.Repository

class RepositoryImplementation(private val dataSource: DataSource<List<SearchResult>>) :
    Repository<List<SearchResult>> {

    override fun getData(word: String): Observable<List<SearchResult>> {
        return dataSource.getData(word)
    }
}