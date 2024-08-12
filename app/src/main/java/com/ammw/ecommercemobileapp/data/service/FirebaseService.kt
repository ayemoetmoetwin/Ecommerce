package com.ammw.ecommercemobileapp.data.service


import com.ammw.ecommercemobileapp.data.model.response.CategoryResponse
import com.ammw.ecommercemobileapp.data.model.response.ProductResponse
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

interface FirebaseInterface {
    suspend fun getCategories(): List<CategoryResponse>
    suspend fun getProducts(): List<ProductResponse>
}

class FirebaseService (

): FirebaseInterface {
    val db = Firebase.firestore
    override suspend fun getCategories(): List<CategoryResponse> {
         val snapshot = db.collection("categories").get().await()
        return snapshot.toObjects(CategoryResponse::class.java)


    }

    override suspend fun getProducts(): List<ProductResponse> {
        val snapshot = db.collection("Product").get().await()
        return snapshot.toObjects(ProductResponse::class.java)
        val productList: MutableList<ProductResponse> = arrayListOf()
    }
}
