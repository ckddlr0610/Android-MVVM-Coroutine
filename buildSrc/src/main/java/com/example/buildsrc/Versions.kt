package com.example.buildsrc

object Versions {
    const val androidTargetSdkVersion = 30
    const val androidCompileSdkVersion = 30
    const val androidMinSdkVersion = 21

    object GradlePlugin {
        const val android = "com.android.tools.build:gradle:7.0.0-beta04"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.20"
    }

    object Kotlin {
        const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.8"
    }

    object Test {
        const val jUnit = "junit:junit:4.12"
        const val jUnitExt = "androidx.test.ext:junit:1.1.3"
        const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
        const val mockitoAndroid = "org.mockito:mockito-android:2.24.5"
        const val mockitoInline = "org.mockito:mockito-inline:3.5.13"
        const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.1"
    }

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:1.6.0"
        const val appCompat = "androidx.appcompat:appcompat:1.3.0"
        const val material = "com.google.android.material:material:1.4.0"
        const val constraint = "androidx.constraintlayout:constraintlayout:2.0.4"
        const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0"
        const val viewModel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01"

        object Navigation {
            const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:2.3.5"
            const val uiKtx = "androidx.navigation:navigation-ui-ktx:2.3.5"
        }
    }

    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        const val okHttpLoggingIntercepter = "com.squareup.okhttp3:logging-interceptor:4.9.1"
        const val gson = "com.google.code.gson:gson:2.8.7"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:2.9.0"
        const val mockWebServer = "com.squareup.okhttp3:mockwebserver:4.9.1"
    }

    object Room {
        const val roomRuntime = "androidx.room:room-runtime:2.3.0"
        const val roomCompiler = "androidx.room:room-compiler:2.3.0"
        const val roomKtx= "androidx.room:room-ktx:2.3.0"
    }

    object Hilt {
        const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:2.28-alpha"
        const val hiltAndroid = "com.google.dagger:hilt-android:2.37"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:2.37"
        const val hiltAndroidCompiler = "com.google.dagger:hilt-android:2.37"
        const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
    }

    object Library {
        const val ktlint = "org.jlleitschuh.gradle:ktlint-gradle:10.1.0"
        const val glide = "com.github.bumptech.glide:glide:4.12.0"
        const val glideCompiler = "com.github.bumptech.glide:compiler:4.12.0"
        const val timber = "com.jakewharton.timber:timber:4.7.1"
    }
}
