package com.dsorcelli.testmvvc.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dsorcelli.testmvvc.models.Book
import com.dsorcelli.testmvvc.repositories.BookRepository
import kotlin.concurrent.thread

class MainActivityViewModel : ViewModel() {

    private val mRepo: BookRepository by lazy {
        BookRepository.getInstance()
    }


    //TODO: try to use List instead of ArrayList
    private var mBooks: MutableLiveData<ArrayList<Book>> = MutableLiveData()

    private var mIsUpdating: MutableLiveData<Boolean> = MutableLiveData()

    init {
         mBooks = mRepo.getBooks()
    }

    fun addBook(book: Book) {

        mIsUpdating.value = true

        thread(start = true) {
            val currentBooks = mBooks.value
            currentBooks?.add(Book("Added book", "Davide", 1993))
            Thread.sleep(2000)
            mIsUpdating.value = false
        }
    }

    fun getBooks(): LiveData<ArrayList<Book>> {
        return mBooks
    }

}