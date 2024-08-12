package com.ammw.ecommercemobileapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ammw.ecommercemobileapp.data.model.response.CategoryResponse
import com.ammw.ecommercemobileapp.data.model.response.ProductResponse
import com.ammw.ecommercemobileapp.data.repository.FirebaseRepository
import com.ammw.ecommercemobileapp.domain.model.BrandModel
import com.ammw.ecommercemobileapp.domain.model.PopularItemModel
import kotlinx.coroutines.launch

class BookmarkViewModel(private val repository: FirebaseRepository) : ViewModel() {

    private val _liveData = MutableLiveData<BookmarkUiState>()

    val liveData: LiveData<BookmarkUiState> = _liveData

    init {
        _liveData.value = BookmarkUiState.Loading
        viewModelScope.launch {
            try {
                val categoryData = repository.getCategories()
                _liveData.value = BookmarkUiState.SuccessCategory(categoryData)
                val productData = repository.getProducts()
                _liveData.value = BookmarkUiState.SuccessProduct(productData)
            } catch (e: Exception) {
                _liveData.value = BookmarkUiState.Error(
                    icon = "",
                    message = e.message.toString()
                )
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        Log.d("viewmodel", "clear")
    }
}

sealed class BookmarkUiState {
    data object Loading : BookmarkUiState()
    data class SuccessCategory(val categoryData: List<BrandModel>) : BookmarkUiState()
    data class SuccessProduct(val productData: List<PopularItemModel>) : BookmarkUiState()
    data class Error(
        val icon: String,
        val message: String,
    ) : BookmarkUiState()
}
