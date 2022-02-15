package id.sharekom.xenditexercise.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeDataRepository (private val remoteDataSource: RemoteDataSource) : DataService {

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