package com.example.cocktailmvvmcoroutine.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailmvvmcoroutine.data.model.Ingredient
import com.example.cocktailmvvmcoroutine.databinding.ItemIngredientBinding

class IngredientAdapter : ListAdapter<Ingredient, RecyclerView.ViewHolder>(diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        IngredientViewHolder(
            ItemIngredientBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as IngredientViewHolder).bind(getItem(position))
    }

    class IngredientViewHolder(private val binding: ItemIngredientBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(ingredient: Ingredient) {
            binding.apply {
                this.ingredient = ingredient
                executePendingBindings()
            }
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Ingredient>() {
            override fun areItemsTheSame(
                oldItem: Ingredient,
                newItem: Ingredient
            ): Boolean =
                oldItem.idIngredient == newItem.idIngredient

            override fun areContentsTheSame(
                oldItem: Ingredient,
                newItem: Ingredient
            ): Boolean =
                oldItem.idIngredient == newItem.idIngredient &&
                    oldItem.strIngredient == newItem.strIngredient
        }
    }
}
