package ru.maxdexter.mytranslator.contracts
//Знает о контексте и фреймворке
interface View {
    //Принимает состояние приложения
    fun renderData(appState: AppState)
}