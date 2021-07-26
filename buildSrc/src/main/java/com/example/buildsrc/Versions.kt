package com.example.buildsrc

object Versions {
    val androidTargetSdkVersion = 30
    val androidCompileSdkVersion = 30
    val androidMinSdkVersion = 21

    object GradlePlugin {
        val android = "com.android.tools.build:gradle:7.0.0-beta04"
        val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.20"
    }

    object Kotlin {
        val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.8"
    }

    object Test {
        val jUnit = "junit:junit:4.12"
        val jUnitExt = "androidx.test.ext:junit:1.1.3"
        val espresso = "androidx.test.espresso:espresso-core:3.4.0"
    }

    object AndroidX {
        val coreKtx = "androidx.core:core-ktx:1.6.0"
        val appCompat = "androidx.appcompat:appcompat:1.3.0"
        val material = "com.google.android.material:material:1.4.0"
        val constraint = "androidx.constraintlayout:constraintlayout:2.0.4"
        val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0"
        val viewModel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01"

        object Navigation {
            val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:2.3.5"
            val uiKtx = "androidx.navigation:navigation-ui-ktx:2.3.5"
        }
    }

    object Network {
        val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        val okHttpLoggingIntercepter = "com.squareup.okhttp3:logging-interceptor:4.9.1"
        val gson = "com.google.code.gson:gson:2.8.7"
        val gsonConverter = "com.squareup.retrofit2:converter-gson:2.9.0"
    }

    object Room {
        val roomRuntime = "androidx.room:room-runtime:2.3.0"
        val roomCompiler = "androidx.room:room-compiler:2.3.0"
        val roomKtx= "androidx.room:room-ktx:2.3.0"
    }

    object Hilt {
        val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:2.28-alpha"
        val hiltAndroid = "com.google.dagger:hilt-android:2.37"
        val hiltCompiler = "com.google.dagger:hilt-android-compiler:2.37"
        val hiltAndroidCompiler = "com.google.dagger:hilt-android:2.37"
        val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
    }

    object Library {
        val ktlint = "org.jlleitschuh.gradle:ktlint-gradle:10.1.0"
        val glide = "com.github.bumptech.glide:glide:4.12.0"
        val glideCompiler = "com.github.bumptech.glide:compiler:4.12.0"
    }
}
