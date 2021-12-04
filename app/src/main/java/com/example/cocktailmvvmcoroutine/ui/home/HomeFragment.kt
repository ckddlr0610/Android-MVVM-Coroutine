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
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailmvvmcoroutine.R
import com.example.cocktailmvvmcoroutine.databinding.FragmentHomeBinding
import com.example.cocktailmvvmcoroutine.ui.adapter.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), OnClickCocktailItemListener {
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val adapter = HomeAdapter(this)

        binding.rvCocktailList.apply {
            this.adapter = adapter
            this.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    if (!binding.rvCocktailList.canScrollVertically(1)) {
                        viewModel.incrementPageNum()
                        viewModel.getCocktailList()
                    }
                }
            })
        }

        subscribeUi(adapter)
        viewModel.getCocktailList()

        return binding.root
    }

    private fun subscribeUi(adapter: HomeAdapter) {
        viewModel.showProgress.observe(viewLifecycleOwner, {
            if (it) {
                binding.pbHome.visibility = View.VISIBLE
            } else {
                binding.pbHome.visibility = View.INVISIBLE
            }
        })

        viewModel.cocktails.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })

        viewModel.showError.observe(viewLifecycleOwner, {
            Toast.makeText(requireActivity(), "error : $it", Toast.LENGTH_SHORT).show()
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
