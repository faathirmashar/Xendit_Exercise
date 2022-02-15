package id.sharekom.xenditexercise.views.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.sharekom.xenditexercise.repository.DataRepository

class HomeViewModel(private val dataRepository: DataRepository) : ViewModel() {
    fun getListData(): LiveData<ArrayList<String>> = dataRepository.getAllData()
}