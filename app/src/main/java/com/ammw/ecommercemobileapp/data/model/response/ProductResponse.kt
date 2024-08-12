package com.ammw.ecommercemobileapp.data.model.response

import com.google.firebase.firestore.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
data class ProductResponse(
    var name: String = "",
    var categoryName: String = "",
    var color: List<String>? = null,
    var description: String = "",
    var free_delivery_return: String = "",
    var iconUrl: List<String>? = null,
    var price: String = "",
    var rating: String = "",
    var size: List<String>? = null,
    var type: String = "",
): Serializable {}