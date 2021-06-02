package ru.maxdexter.mytranslator.contracts

import ru.maxdexter.mytranslator.model.DataState

//Знает о контексте и фреймворке
interface View {
    //Принимает состояние приложения
    fun renderData(appState: DataState)
}