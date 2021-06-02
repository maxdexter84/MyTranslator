package ru.maxdexter.mytranslator.model

sealed class DataState {
    data class Success(val data: List<SearchResult>?) : DataState()
    data class Error(val error: Throwable) : DataState()
    data class Loading(val progress: Int?) : DataState()
}
