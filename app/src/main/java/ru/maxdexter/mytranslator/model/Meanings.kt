package ru.maxdexter.mytranslator.model

import com.google.gson.annotations.SerializedName
import ru.maxdexter.mytranslator.model.Translation

class Meanings(
    @field:SerializedName("translation") val translation: Translation?,
    @field:SerializedName("imageUrl") val imageUrl: String?
)
