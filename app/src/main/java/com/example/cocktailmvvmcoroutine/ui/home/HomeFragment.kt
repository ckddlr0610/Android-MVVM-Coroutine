package com.example.cocktailmvvmcoroutine.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.cocktailmvvmcoroutine.R
import com.example.cocktailmvvmcoroutine.data.model.Cocktails
import com.example.cocktailmvvmcoroutine.data.model.Result
import com.example.cocktailmvvmcoroutine.databinding.FragmentHomeBinding
import com.example.cocktailmvvmcoroutine.ui.adapter.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        val adapter = HomeAdapter()
        binding.rvCocktailList.adapter = adapter

        subscribeUi(adapter)

        return binding.root
    }

    private fun subscribeUi(adapter: HomeAdapter) {
        viewModel.cocktail.observe(viewLifecycleOwner, { result ->
            when(result) {
                is Result.Loading -> {
                    Toast.makeText(requireActivity(), "loading", Toast.LENGTH_LONG).show()
                }
                is Result.Success<Cocktails> -> {
                    adapter.submitList(result.item.drinks)
                }
                is Result.Error -> {
                    Toast.makeText(requireActivity(), "error : ${result.throwable.toString()}", Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}