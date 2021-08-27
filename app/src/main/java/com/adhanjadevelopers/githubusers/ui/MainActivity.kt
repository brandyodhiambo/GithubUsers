package com.adhanjadevelopers.githubusers.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.adhanjadevelopers.githubusers.adapters.UsersAdapter
import com.adhanjadevelopers.githubusers.databinding.ActivityMainBinding
import com.adhanjadevelopers.githubusers.utils.Resource
import com.adhanjadevelopers.githubusers.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val adapter: UsersAdapter by lazy {
        UsersAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.usersResponse.observe(this, Observer { users ->
            when (users) {
                is Resource.Loading -> {
                    binding.progressBar.isVisible = true
                }
                is Resource.Success -> {
                    binding.progressBar.isVisible = false
                    adapter.submitList(users.data)
                    binding.recyclerView.adapter = adapter
                }
                is Resource.Failure -> {
                    binding.progressBar.isVisible = false
                    binding.errortextview.text = "Failed"
                    binding.errortextview.isVisible = true

                }
            }

        })


    }


}