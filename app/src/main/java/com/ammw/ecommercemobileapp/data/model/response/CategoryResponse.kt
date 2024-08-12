package com.ammw.ecommercemobileapp.data.model.response
import com.google.firebase.firestore.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
data class CategoryResponse(
    var id :Int = 0,
    var name: String? = "",
    var iconUrl: String? = ""
): Serializable {}
