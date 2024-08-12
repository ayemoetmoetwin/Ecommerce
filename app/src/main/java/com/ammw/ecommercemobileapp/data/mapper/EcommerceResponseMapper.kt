package com.ammw.ecommercemobileapp.data.mapper

import com.ammw.ecommercemobileapp.data.model.response.CategoryResponse
import com.ammw.ecommercemobileapp.data.model.response.ProductResponse
import com.ammw.ecommercemobileapp.domain.model.BrandModel
import com.ammw.ecommercemobileapp.domain.model.PopularItemModel
import com.ammw.ecommercemobileapp.domain.model.ProductModel

fun List<CategoryResponse>.toCModel(): List<BrandModel> {
    return this.map { categoryResponse ->
        BrandModel(
            id = categoryResponse.id.toInt(),
            name = categoryResponse.name.orEmpty(),
            imageUrl = categoryResponse.iconUrl.orEmpty()
        )
    }
}

fun List<ProductResponse>.toPModel(): List<PopularItemModel> {
    return this.mapIndexed {index, response ->
        PopularItemModel(
            id = index,
            name = response.name,
            categoryName = response.categoryName,
            imageUrl= if (!response.iconUrl.isNullOrEmpty()) {
                response.iconUrl!![index]
            }else {
                ""
            },
            price = response.price
        )
    }
}

fun List<ProductResponse>.toProductModel(): List<ProductModel> {
    return this.map { response ->
        ProductModel(
            name = response.name,
            categoryName = response.categoryName,
            description = response.description,
            free_delivery_return = response.free_delivery_return,
            iconUrl = response.iconUrl,
            price = response.price,
            rating = response.rating,
            sizes = response.size,
            type = response.type,
            color = response.color
        )
    }
}
