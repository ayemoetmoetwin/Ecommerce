package com.ammw.ecommercemobileapp.data.service


import com.ammw.ecommercemobileapp.data.model.response.CategoryResponse
import com.ammw.ecommercemobileapp.data.model.response.ProductResponse
import com.ammw.ecommercemobileapp.network.CloudFirestoreFirebaseApiImpl
import com.ammw.ecommercemobileapp.network.CloudFirestoreFirebaseApiImpl.db
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

/*class PersonalizeService(private val httpClient: HttpClient) {
    suspend fun getPersonalize(): PersonalizeResponse {

        val response: PersonalizeResponse = withContext(Dispatchers.IO) {
            val httpResponse : HttpResponse = httpClient.get("") //get is suspend fun
            //meta data,body
            httpResponse.body() //body json //body is suspend fun
        }
        return response
    }
}*/
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
        /*db.collection("Product")
            .addSnapshotListener { value, error -> //support realtime data upgrade and refresh data in application
                error?.let {

                } ?: run {


                    val result =
                        value?.documents ?: arrayListOf() //'value' refer the whole collection

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
                }
            }
        return productList
    }*/
    }
}
