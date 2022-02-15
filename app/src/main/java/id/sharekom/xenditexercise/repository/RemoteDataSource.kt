package id.sharekom.xenditexercise.repository

import android.os.Handler
import android.os.Looper
import id.sharekom.xenditexercise.utils.JsonParser

class RemoteDataSource private constructor(private val jsonParser: JsonParser) {
    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val LATENCY : Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(parser: JsonParser): RemoteDataSource =
            instance ?: synchronized(this) {
                RemoteDataSource(parser).apply { instance = this }
            }
    }

    fun getAllCourses(callback: LoadDataCallback) {
        handler.postDelayed({ callback.onAllDataReceived(jsonParser.loadData()) }, LATENCY)
    }

    interface LoadDataCallback {
        fun onAllDataReceived(dataResponse: List<String>)
    }
}