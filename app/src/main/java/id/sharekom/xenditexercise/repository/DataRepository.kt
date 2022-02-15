package id.sharekom.xenditexercise.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DataRepository private constructor(private val remoteDataSource: RemoteDataSource) : DataService {
    companion object {
        @Volatile
        private var instance: DataRepository? = null

        fun getInstance(remoteData: RemoteDataSource): DataRepository =
            instance ?: synchronized(this) {
                DataRepository(remoteData).apply { instance = this }
            }
    }

    override fun getAllData(): LiveData<ArrayList<String>> {
        val dataResult = MutableLiveData<ArrayList<String>>()
        remoteDataSource.getAllCourses(object : RemoteDataSource.LoadDataCallback {
            override fun onAllDataReceived(dataResponse: List<String>) {
                val dataList = ArrayList<String>()
                for (data in dataResponse) {
                    dataList.add(data)
                }
                dataResult.postValue(dataList)
            }
        })

        return dataResult
    }
}