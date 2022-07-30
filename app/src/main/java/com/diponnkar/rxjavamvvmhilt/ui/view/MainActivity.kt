package com.diponnkar.rxjavamvvmhilt.ui.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.diponnkar.rxjavamvvmhilt.ui.view.adapter.MainAdapter
import com.diponnkar.rxjavamvvmhilt.databinding.ActivityMainBinding
import com.diponnkar.rxjavamvvmhilt.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModels()

    private val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
        observeMovieList()
        observeError()
        observeLoading()
    }

    private fun setupUI() {
        binding.recyclerview.adapter = adapter

        mainViewModel.getAllMovies()
    }

    private fun observeMovieList() {
        mainViewModel.movieList.observe(this) { movieList ->
            if (movieList != null) {
                adapter.setMovieList(movieList)
            } else {
                Toast.makeText(this, "Error in fetching data", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun observeError() {
        mainViewModel.errorMessage.observe(this) {
            Toast.makeText(this, "Error: $it", Toast.LENGTH_SHORT).show()
        }
    }

    private fun observeLoading() {
        mainViewModel.loading.observe(this) {
            if (it) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }
    }
}