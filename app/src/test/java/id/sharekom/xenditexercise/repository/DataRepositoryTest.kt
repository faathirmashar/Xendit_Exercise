package id.sharekom.xenditexercise.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import id.sharekom.xenditexercise.utils.DataDummy
import id.sharekom.xenditexercise.utils.LiveDataTestUtil
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule

import org.junit.Test
import org.mockito.Mockito.mock

class DataRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remoteData = mock(RemoteDataSource::class.java)
    private val dataRepository = FakeDataRepository(remoteData)

    private val dataResponses = DataDummy.generateDummyData()

    @Test
    fun getAllData() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadDataCallback).onAllDataReceived(dataResponses)
            null
        }.`when`(remoteData).getAllCourses(any())
        val data = LiveDataTestUtil.getValue(dataRepository.getAllData())
        verify(remoteData).getAllCourses(any())
        assertNotNull(data)
        assertEquals(dataResponses.size, data.size)
    }
}