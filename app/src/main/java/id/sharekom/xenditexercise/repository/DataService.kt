package id.sharekom.xenditexercise.repository

import androidx.lifecycle.LiveData

interface DataService {
    fun getAllData(): LiveData<ArrayList<String>>
}