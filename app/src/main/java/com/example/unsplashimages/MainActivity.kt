package com.example.unsplashimages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.unsplashimages.Adapter.ImageAdapter
import com.example.unsplashimages.ViewModel.ImageViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ImageAdapter
    private lateinit var viewModel: ImageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRecyclerView()
        initViewModel()
        searchButton()
    }

    private fun searchButton() {
        btn_Search.setOnClickListener {
            if (!et_search.text.isNullOrEmpty()) {
                viewModel.makeApiCall(et_search.text.toString())
            } else {
                viewModel.makeApiCall("travelling")
            }
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(ImageViewModel::class.java)

        viewModel.getAllImages().observe(this, Observer {
            adapter.submitList(it)
        })

        viewModel.makeApiCall("travelling")

    }

    private fun setRecyclerView() {
        adapter = ImageAdapter(this)
        image_RecyclerView.adapter = adapter
        image_RecyclerView.layoutManager = LinearLayoutManager(this)
    }


}