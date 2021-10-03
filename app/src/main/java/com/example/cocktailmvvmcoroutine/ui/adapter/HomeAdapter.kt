package com.example.cocktailmvvmcoroutine.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailmvvmcoroutine.data.model.Cocktail
import com.example.cocktailmvvmcoroutine.databinding.ItemCocktailListBinding
import com.example.cocktailmvvmcoroutine.ui.home.OnClickCocktailItemListener

class HomeAdapter(private val onClickCocktailItemListener: OnClickCocktailItemListener) :
    ListAdapter<Cocktail, RecyclerView.ViewHolder>(diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        CocktailViewHolder(
            ItemCocktailListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), onClickCocktailItemListener
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CocktailViewHolder).bind(getItem(position))
    }

    class CocktailViewHolder(
        private val binding: ItemCocktailListBinding,
        private val onClickCocktailItemListener: OnClickCocktailItemListener
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cocktail: Cocktail) {
            binding.apply {
                this.cocktail = cocktail
                executePendingBindings()
            }

            binding.root.setOnClickListener {
                onClickCocktailItemListener.onClickCocktailItem(cocktail.idDrink)
            }
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Cocktail>() {
            override fun areItemsTheSame(
                oldItem: Cocktail,
                newItem: Cocktail
            ): Boolean =
                oldItem.idDrink == newItem.idDrink

            override fun areContentsTheSame(
                oldItem: Cocktail,
                newItem: Cocktail
            ): Boolean =
                oldItem.idDrink == newItem.idDrink &&
                    oldItem.strDrink == newItem.strDrink &&
                    oldItem.strDrinkThumb == newItem.strDrinkThumb

        }
    }
}
