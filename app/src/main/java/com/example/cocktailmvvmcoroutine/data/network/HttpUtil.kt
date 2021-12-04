package com.example.cocktailmvvmcoroutine.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.example.cocktailmvvmcoroutine.CocktailApplication

fun isConnectedNetwork() : Boolean {
    val cm = CocktailApplication.getApplicationContext()?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    return if (android.os.Build.VERSION.SDK_INT < 29) {
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        activeNetwork?.isConnectedOrConnecting == true
    } else {
        cm.activeNetwork != null
    }
}