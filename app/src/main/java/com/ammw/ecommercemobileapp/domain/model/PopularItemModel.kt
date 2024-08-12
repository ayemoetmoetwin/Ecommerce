package com.ammw.ecommercemobileapp.domain.model

data class PopularItemModel (
    val id:Int,
    val name:String?,
    val categoryName: String?,
    val imageUrl:String?,
    val price:String?,
    val isFavourite:Boolean? = false
){
}