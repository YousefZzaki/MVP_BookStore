package com.example.mvp_bookstore.contract

import com.example.mvp_bookstore.model.Book

interface MainContract {

    interface MainView {
        fun onSuccess(message: String)
        fun onFail(message: String)
    }

    interface MainPresenter {
        fun searchById(id: Int): Book?
    }
}