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
import com.ammw.ecommercemobileapp.domain.model.ProductModel
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: FirebaseRepository) : ViewModel() {

    private val _liveData = MutableLiveData<DetailUiState>()

    val liveData: LiveData<DetailUiState> = _liveData

    init {
        _liveData.value = DetailUiState.Loading
        viewModelScope.launch {
            try {
                val productData = repository.getProductsDetail()
                _liveData.value = DetailUiState.SuccessProduct(productData)
            } catch (e: Exception) {
                _liveData.value = DetailUiState.Error(
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

sealed class DetailUiState {
    data object Loading : DetailUiState()
    data class SuccessProduct(val productData: List<ProductModel>) : DetailUiState()
    data class Error(
        val icon: String,
        val message: String,
    ) : DetailUiState()
}
