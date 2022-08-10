package com.example.myapplicationtest



import com.google.firebase.firestore.DocumentId
import androidx.compose.runtime.Immutable

@Immutable
data class Shop(
    @DocumentId val id: String = "",
    val name: String = "",
    val area: String = "",
    val image: String = "",
)

