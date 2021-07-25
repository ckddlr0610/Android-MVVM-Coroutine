package com.example.cocktailmvvmcoroutine.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.cocktailmvvmcoroutine.R
import com.example.cocktailmvvmcoroutine.data.model.Cocktails
import com.example.cocktailmvvmcoroutine.data.model.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subscribeUi()
    }

    private fun subscribeUi() {
        viewModel.cocktail.observe(viewLifecycleOwner, { result ->
            when(result) {
                is Result.Loading -> {
                    Toast.makeText(requireActivity(), "loading", Toast.LENGTH_LONG).show()
                }
                is Result.Success<Cocktails> -> {
                    Toast.makeText(requireActivity(), "success", Toast.LENGTH_LONG).show()
                }
                is Result.Error -> {
                    Toast.makeText(requireActivity(), "error : ${result.throwable.toString()}", Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}
