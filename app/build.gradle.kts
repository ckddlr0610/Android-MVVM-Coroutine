import com.example.buildsrc.Versions

plugins {
    id ("com.android.application")
    id("kotlin-android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    compileSdk = Versions.androidCompileSdkVersion
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId  = "com.example.cocktailmvvmcoroutine"
        minSdk = Versions.androidMinSdkVersion
        targetSdk = Versions.androidTargetSdkVersion
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation(Versions.AndroidX.coreKtx)
    implementation(Versions.AndroidX.appCompat)
    implementation(Versions.AndroidX.material)
    implementation (Versions.AndroidX.constraint)
    implementation(Versions.AndroidX.livedata)
    implementation(Versions.AndroidX.viewModel)
    implementation (Versions.AndroidX.Navigation.fragmentKtx)
    implementation (Versions.AndroidX.Navigation.uiKtx)
    testImplementation(Versions.Test.jUnit)
    androidTestImplementation(Versions.Test.jUnitExt)
    androidTestImplementation(Versions.Test.espresso)
    androidTestImplementation(Versions.Test.mockitoAndroid)
    testImplementation (Versions.Test.mockitoInline)
    testImplementation (Versions.Test.coroutineTest)

    //kotlin
    implementation(Versions.Kotlin.coroutineCore)

    // hilt
    implementation (Versions.Hilt.hiltAndroid)
    kapt(Versions.Hilt.hiltCompiler)
    kapt(Versions.Hilt.hiltAndroidCompiler)
    implementation(Versions.Hilt.hiltViewModel)

    // network
    implementation (Versions.Network.retrofit)
    implementation (Versions.Network.okHttpLoggingIntercepter)
    implementation(Versions.Network.gson)
    implementation (Versions.Network.gsonConverter)
    testImplementation (Versions.Network.mockWebServer)

    // room
    implementation(Versions.Room.roomRuntime)
    annotationProcessor (Versions.Room.roomCompiler)
    kapt(Versions.Room.roomCompiler)
    implementation(Versions.Room.roomKtx)

    // image
    implementation (Versions.Library.glide)
    annotationProcessor (Versions.Library.glideCompiler)
}
