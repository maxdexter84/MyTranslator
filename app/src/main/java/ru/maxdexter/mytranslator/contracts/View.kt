package ru.maxdexter.mytranslator.contracts

import geekbrains.ru.translator.model.data.DataModel

//Знает о контексте и фреймворке
interface View {
    //Принимает состояние приложения
    fun renderData(appState: DataModel)
}