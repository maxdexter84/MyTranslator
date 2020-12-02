package ru.maxdexter.mytranslator.repository

import geekbrains.ru.translator.model.data.SearchResult
import io.reactivex.Observable
import ru.maxdexter.mytranslator.contracts.DataSource
import ru.maxdexter.mytranslator.contracts.Repository

class RepositoryImplementation(private val dataSource: DataSource<List<SearchResult>>) :
    Repository<List<SearchResult>> {

    override fun getData(word: String): Observable<List<SearchResult>> {
        return dataSource.getData(word)
    }
}