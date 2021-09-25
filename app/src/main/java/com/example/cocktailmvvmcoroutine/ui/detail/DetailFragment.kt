package com.example.cocktailmvvmcoroutine.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.cocktailmvvmcoroutine.data.model.DetailUiModel
import com.example.cocktailmvvmcoroutine.data.model.ResultOf
import com.example.cocktailmvvmcoroutine.databinding.FragmentDetailBinding
import com.example.cocktailmvvmcoroutine.ui.adapter.IngredientAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private val viewModel: DetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDetailBinding.inflate(inflater, container, false)

        val adapter = IngredientAdapter()
        binding.containerIngredient.adapter = adapter
        subscribeUi(binding, adapter)

        //TODO: 변수가 제대로 넘어오지 않았을 때 별도 처리가 필요
        arguments?.getLong("idCocktail")?.let {
            viewModel.getDetailUiModel(it)
        }

        return binding.root
    }

    private fun subscribeUi(binding: FragmentDetailBinding, adapter: IngredientAdapter) {
        viewModel.detailUiModel.observe(viewLifecycleOwner, { result ->
            when (result) {
                is ResultOf.Loading -> {
                    Toast.makeText(requireActivity(), "loading", Toast.LENGTH_SHORT).show()
                }

                is ResultOf.Success<DetailUiModel> -> {
                    Glide.with(requireActivity())
                        .load(result.item.strDrinkThumb)
                        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(binding.ivCocktail)

                    binding.tvCocktailInstruction.text = result.item.strInstructions

                    adapter.submitList(result.item.ingredients)
                }

                is ResultOf.Error -> {
                    Toast.makeText(
                        requireActivity(),
                        "error : ${result.throwable.toString()}",
                        Toast.LENGTH_SHORT
                    ).show()

                    Log.e("TAG", result.throwable.toString())
                }
            }
        })
    }
}
