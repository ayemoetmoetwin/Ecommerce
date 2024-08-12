package com.ammw.ecommercemobileapp.network

import com.ammw.ecommercemobileapp.data.model.response.CategoryResponse
import com.ammw.ecommercemobileapp.data.model.response.ProductResponse
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object CloudFirestoreFirebaseApiImpl : FirebaseApi {

    val db = Firebase.firestore
    override fun getCategory(
        onSuccess: (groceries: List<CategoryResponse>) -> Unit,
        onFialure: (String) -> Unit
    ) {

    }

    override fun getProduct(
        onSuccess: (groceries: List<ProductResponse>) -> Unit,
        onFialure: (String) -> Unit
    ) {
        db.collection("Product")
            .addSnapshotListener { value, error -> //support realtime data upgrade and refresh data in application
                error?.let {
                    onFialure(it.message ?: "Please check connection")
                } ?: run{
                    val productList: MutableList<ProductResponse> = arrayListOf()

                    val result = value?.documents ?: arrayListOf() //'value' refer the whole collection

                    for (document in result) {
                        val data = document.data
                        val product = ProductResponse()
                        product.name = data?.get("name") as String
                        product.categoryName = data?.get("categoryName") as String
                        product.color = data["color"] as List<String>?
                        product.description = data["description"] as String
                        product.free_delivery_return = data["free_delivery_return"] as String
                        product.iconUrl = data["iconUrl"] as List<String>?
                        product.price = data["price"] as String
                        product.rating = data["rating"] as String
                        product.size = data["size"] as List<String>?
                        product.type = data["type"] as String
                        productList.add(product)
                    }
                    onSuccess(productList)
                }
            }
    }

}