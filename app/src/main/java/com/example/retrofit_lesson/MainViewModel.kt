package com.example.retrofit_lesson

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_lesson.model.Post
import com.example.retrofit_lesson.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    var repo = Repository()
    var myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    var myResponse2: MutableLiveData<Response<Post>> = MutableLiveData()
    var myCustomPost: MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            myResponse.value = repo.getPost()
        }
    }

    fun getPost2(number: Int) {
        viewModelScope.launch {
            myResponse2.value = repo.getPost2(number)
        }
    }

    fun getCustomPosts(userId: Int) {
        viewModelScope.launch {
            myCustomPost.value = repo.getCustomPosts(userId)
        }
    }

}