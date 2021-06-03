package com.example.unsplashimages.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unsplashimages.LoadImages.ImageService
import com.example.unsplashimages.Model.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ImageViewModel : ViewModel() {

    companion object {
        const val API_KEY = "upjc8Q0QCOX3S1gxpNbDRt5fe7ovrx1Gk1GjWRk9jUU"
        const val PAGE = 1
        const val ORDER_BY = "latest"
    }

    private var imageLiveData: MutableLiveData<List<Result>> = MutableLiveData()

    fun getAllImages(): LiveData<List<Result>> {
        return imageLiveData
    }

    fun makeApiCall(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val images = ImageService.instance.getAllImages(API_KEY, query, PAGE, ORDER_BY).body()
            if (images != null) {
                this@ImageViewModel.imageLiveData.postValue(images.results)
            }
        }
    }

}