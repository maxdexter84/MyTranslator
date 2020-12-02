package ru.maxdexter.mytranslator.interactor

import geekbrains.ru.translator.model.data.DataModel
import geekbrains.ru.translator.model.data.SearchResult
import io.reactivex.Observable
import ru.maxdexter.mytranslator.contracts.Interactor
import ru.maxdexter.mytranslator.contracts.Repository
import ru.maxdexter.mytranslator.state.AppState


class MainInteractor(
    private val remoteRepository: Repository<List<SearchResult>>,
    private val localRepository: Repository<List<SearchResult>>
) : Interactor<DataModel> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<DataModel> {
        return if (fromRemoteSource) {
            remoteRepository.getData(word).map { DataModel.Success(it) }
        } else {
            localRepository.getData(word).map { DataModel.Success(it) }
        }
    }
}