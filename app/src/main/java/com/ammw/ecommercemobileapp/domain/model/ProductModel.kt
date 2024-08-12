package com.ammw.ecommercemobileapp.domain.model

import java.io.Serializable

data class ProductModel(
    var name: String = "",
    var categoryName: String = "",
    var color: List<String>? = null,
    var description: String = "",
    var free_delivery_return: String = "",
    var iconUrl: List<String>? = null,
    var price: String = "",
    var rating: String = "",
    var sizes: List<String>? = null,
    var type: String = "",
): Serializable {}
