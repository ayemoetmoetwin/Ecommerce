package com.ammw.ecommercemobileapp.data.repository

import com.ammw.ecommercemobileapp.data.datasource.FirebaseRemoteDataSource
import com.ammw.ecommercemobileapp.data.model.response.CategoryResponse
import com.ammw.ecommercemobileapp.data.model.response.ProductResponse
import com.ammw.ecommercemobileapp.domain.model.BrandModel
import com.ammw.ecommercemobileapp.domain.model.PopularItemModel
import com.ammw.ecommercemobileapp.domain.model.ProductModel


class FirebaseRepository(private val remoteDataSource: FirebaseRemoteDataSource) {
    suspend fun getCategories(): List<BrandModel> = remoteDataSource.getCategories()
    suspend fun getProducts(): List<PopularItemModel> = remoteDataSource.getProducts()
    suspend fun getProductsDetail(): List<ProductModel> = remoteDataSource.getProductsDetail()
}