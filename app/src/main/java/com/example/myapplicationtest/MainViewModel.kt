package com.example.myapplicationtest

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainViewModel : ViewModel() {
    var newshops = mutableStateListOf<Shop>()
    private set
    fun addNewShop(shop:Shop){
    newshops.add(shop)
}
    fun newShopAddFromDataBase() {
    Firebase.firestore
        .collection("new").limit(5)
        .addSnapshotListener { snapshot, e ->
            if (e != null || snapshot == null) {
                Log.e("ERROR", "listen:error", e)
                return@addSnapshotListener
            }
            for (dc in snapshot.documentChanges) {
                val doc = dc.document.toObject(Shop::class.java)
                addNewShop(doc)
            }
        }
}

    var areashops = mutableStateListOf<Shop>()
    fun addAreaShop(shop:Shop){
        areashops.add(shop)
    }
    fun areaShopAddFromDataBase() {
        Firebase.firestore
            .collection("new").whereEqualTo("area", "渋谷")
            .addSnapshotListener { snapshot, e ->
                if (e != null || snapshot == null) {
                    Log.e("ERROR", "listen:error", e)
                    return@addSnapshotListener
                }
                for (dc in snapshot.documentChanges) {
                    val doc = dc.document.toObject(Shop::class.java)
                    addAreaShop(doc)
                }
            }
    }

    var PRshops = mutableStateListOf<Shop>()
    fun addPRShop(shop:Shop){
        PRshops.add(shop)
    }
    fun PRShopAddFromDataBase() {
        Firebase.firestore
            .collection("new").whereEqualTo("PR", "")
            .addSnapshotListener { snapshot, e ->
                if (e != null || snapshot == null) {
                    Log.e("ERROR", "listen:error", e)
                    return@addSnapshotListener
                }
                for (dc in snapshot.documentChanges) {
                    val doc = dc.document.toObject(Shop::class.java)
                    addPRShop(doc)
                }
            }
    }


    init {
        newShopAddFromDataBase()
        areaShopAddFromDataBase()
        PRShopAddFromDataBase()
    }
}

