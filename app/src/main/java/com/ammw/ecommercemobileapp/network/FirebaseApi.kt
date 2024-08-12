package com.ammw.ecommercemobileapp.network

import com.ammw.ecommercemobileapp.data.model.response.CategoryResponse
import com.ammw.ecommercemobileapp.data.model.response.ProductResponse

interface FirebaseApi {
    fun getCategory(onSuccess: (groceries: List<CategoryResponse>) -> Unit, onFialure: (String) -> Unit)
    fun getProduct(onSuccess: (groceries: List<ProductResponse>) -> Unit, onFialure: (String) -> Unit)
}