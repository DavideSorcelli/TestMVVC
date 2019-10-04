package com.dsorcelli.testmvvc.repositories

import androidx.lifecycle.MutableLiveData
import com.dsorcelli.testmvvc.models.Book

class BookRepository {

    private val dataSet: ArrayList<Book> = ArrayList()

    fun getBooks(): MutableLiveData<ArrayList<Book>> {

        // fetch data
        setBooks()

        val data: MutableLiveData<ArrayList<Book>> = MutableLiveData()
        data.value = dataSet
        return data
    }

    private fun setBooks() {
        dataSet.add(
            Book(
                title = "Rainbow Six",
                author = "Tom Clancy",
                year = 1998
            )
        )
        dataSet.add(
            Book(
                title = "Frankestein",
                author = "Mary Shelley",
                year = 1818
            )
        )
        dataSet.add(
            Book(
                title = "Alice nel paese delle meraviglie",
                author = "Lewis Carrol",
                year = 1865
            )
        )
    }

    companion object {

        private var instance: BookRepository? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: BookRepository().also { instance = it }
            }
    }

}