package ru.maxdexter.mytranslator.state

sealed class AppState<T>(val data: T) {
     class Success<T>(data: T): AppState<T>(data)
     class Error<T>( error: T) : AppState<T>(error)
     class Loading<T>(progress: T) : AppState<T>(progress)
}

