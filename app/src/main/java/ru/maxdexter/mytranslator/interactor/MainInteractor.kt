package ru.maxdexter.mytranslator.interactor

import ru.maxdexter.mytranslator.model.DataState
import ru.maxdexter.mytranslator.model.SearchResult
import io.reactivex.Observable
import ru.maxdexter.mytranslator.contracts.Interactor
import ru.maxdexter.mytranslator.contracts.Repository


class MainInteractor(
    private val remoteRepository: Repository<List<SearchResult>>,
    private val localRepository: Repository<List<SearchResult>>
) : Interactor<DataState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<DataState> {
        return if (fromRemoteSource) {
            remoteRepository.getData(word).map { DataState.Success(it) }
        } else {
            localRepository.getData(word).map { DataState.Success(it) }
        }
    }
}