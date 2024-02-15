package com.example.mvp_bookstore.ui

import com.example.mvp_bookstore.database.BooksDatabase
import com.example.mvp_bookstore.model.Book
import com.example.mvp_bookstore.contract.MainContract

class MainPresenter(private val mainView: MainContract.MainView) : MainContract.MainPresenter {
    override fun searchById(id: Int): Book? {
        val result = BooksDatabase.booksList.find {
            id == it.id
        }

        return if (result != null){
            mainView.onSuccess("Success")
            result
        }else {
            mainView.onFail("Fail")
            Book()
        }

    }
}