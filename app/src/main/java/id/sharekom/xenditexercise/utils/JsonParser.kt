package id.sharekom.xenditexercise.utils

import android.content.Context
import org.json.JSONArray
import java.io.IOException

class JsonParser(private val context: Context) {
    private fun parsingFileToString(): String? {
        return try {
            val fs = context.assets.open("content_data.json")
            val buffer = ByteArray(fs.available())
            fs.read(buffer)
            fs.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadData(): List<String> {
        val data = ArrayList<String>()
        try {
            val jsonArray = JSONArray(parsingFileToString().toString())

            for (i in 0 until jsonArray.length()) {
                data.add(jsonArray.getString(i))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return data
    }
}