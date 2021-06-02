package ru.maxdexter.mytranslator.presenter

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import ru.maxdexter.mytranslator.contracts.Presenter
import ru.maxdexter.mytranslator.contracts.View
import ru.maxdexter.mytranslator.interactor.MainInteractor
import ru.maxdexter.mytranslator.model.DataState
import ru.maxdexter.mytranslator.repository.DataSourceLocal
import ru.maxdexter.mytranslator.repository.DataSourceRemote
import ru.maxdexter.mytranslator.repository.RepositoryImplementation
import ru.maxdexter.mytranslator.rx.SchedulerProvider

class MainPresenterImpl<T : DataState, V : View>(
    private val interactor: MainInteractor = MainInteractor(
        RepositoryImplementation(DataSourceRemote()),
        RepositoryImplementation(DataSourceLocal())
    ),
    private val compositeDisposable: CompositeDisposable = CompositeDisposable(),
    private val schedulerProvider: SchedulerProvider = SchedulerProvider()
) : Presenter<T, V> {

    private var currentView: V? = null

    override fun attachView(view: V) {
        if (view != currentView) {
            currentView = view
        }
    }

    override fun detachView(view: V) {
        compositeDisposable.clear()
        if (view == currentView) {
            currentView = null
        }
    }

    override fun getData(word: String, isOnline: Boolean) {
        compositeDisposable.add(
            interactor.getData(word, isOnline)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe(doOnSubscribe())
                .subscribeWith(getObserver())
        )
    }

    private fun doOnSubscribe(): (Disposable) -> Unit =
        { currentView?.renderData(DataState.Loading(null)) }

    private fun getObserver(): DisposableObserver<DataState> {
        return object : DisposableObserver<DataState>() {

            override fun onNext(data: DataState) {
                currentView?.renderData(data)
            }

            override fun onError(e: Throwable) {
                currentView?.renderData(DataState.Error(e))
            }

            override fun onComplete() {
            }
        }
    }
}
