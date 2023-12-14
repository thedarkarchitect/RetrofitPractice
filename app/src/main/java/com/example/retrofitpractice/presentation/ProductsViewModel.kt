package com.example.retrofitpractice.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitpractice.data.remote.model.Product
import com.example.retrofitpractice.data.repository.ProductRepository
import com.example.retrofitpractice.utils.Results
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


class ProductsViewModel(
    private val repository: ProductRepository
): ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products = _products.asStateFlow()

    private val _showErrorToastChannel = Channel<Boolean>()
    val showErrorToastChannel = _showErrorToastChannel.receiveAsFlow()

    init{
        viewModelScope.launch {
            repository.getProductList().collectLatest { result ->
                when(result){
                    is Results.Error -> {
                        _showErrorToastChannel.send(true)
                    }
                    is Results.Success -> {
                        result.data?.let { listData ->
                            _products.update {
                                listData
                            }
                        }
                    }
                }
            }
        }
    }

}