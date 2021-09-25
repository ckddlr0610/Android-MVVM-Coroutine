package com.example.cocktailmvvmcoroutine.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.cocktailmvvmcoroutine.R
import com.example.cocktailmvvmcoroutine.data.model.Cocktail
import com.example.cocktailmvvmcoroutine.data.model.ResultOf
import com.example.cocktailmvvmcoroutine.databinding.FragmentHomeBinding
import com.example.cocktailmvvmcoroutine.ui.adapter.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), OnClickCocktailItemListener {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        val adapter = HomeAdapter(this)
        binding.rvCocktailList.adapter = adapter

        subscribeUi(adapter)

        return binding.root
    }

    private fun subscribeUi(adapter: HomeAdapter) {
        viewModel.cocktails.observe(viewLifecycleOwner, { result ->
            when(result) {
                is ResultOf.Loading -> {
                    Toast.makeText(requireActivity(), "loading", Toast.LENGTH_SHORT).show()
                }
                is ResultOf.Success<List<Cocktail>> -> {
                    adapter.submitList(result.item)
                }
                is ResultOf.Error -> {
                    Toast.makeText(requireActivity(), "error : ${result.throwable.toString()}", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun onClickCocktailItem(idCocktail: Long) {
        val bundle = bundleOf("idCocktail" to idCocktail)
        findNavController().navigate(R.id.action_homeFragment_to_detailFragment, bundle)
    }
}

interface OnClickCocktailItemListener {
    fun onClickCocktailItem(idCocktail: Long)
}
