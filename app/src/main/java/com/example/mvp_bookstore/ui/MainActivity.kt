package com.example.mvp_bookstore.ui

import android.os.Bundle
import android.view.View.INVISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mvp_bookstore.contract.MainContract
import com.example.mvp_bookstore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainContract.MainView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()

    }

    private fun initPresenter() {
        mainPresenter = MainPresenter(this)
        binding.btnSearch.setOnClickListener {

            binding.et.visibility = INVISIBLE
            binding.btnSearch.visibility = INVISIBLE

            val id = binding.et.text.toString().toInt()
            val result = mainPresenter.searchById(id)

            binding.tv.text = result?.name
        }
    }

    override fun onSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onFail(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}