package com.ammw.ecommercemobileapp.data.datasource

import com.ammw.ecommercemobileapp.data.mapper.toCModel
import com.ammw.ecommercemobileapp.data.mapper.toPModel
import com.ammw.ecommercemobileapp.data.mapper.toProductModel
import com.ammw.ecommercemobileapp.data.service.FirebaseService
import com.ammw.ecommercemobileapp.domain.model.BrandModel
import com.ammw.ecommercemobileapp.domain.model.PopularItemModel
import com.ammw.ecommercemobileapp.domain.model.ProductModel


class FirebaseRemoteDataSource(private val service: FirebaseService) {
    suspend fun getCategories(): List<BrandModel> = service.getCategories().toCModel()
    suspend fun getProducts(): List<PopularItemModel> = service.getProducts().toPModel()
    suspend fun getProductsDetail(): List<ProductModel> = service.getProducts().toProductModel()
}