import com.example.buildsrc.Versions

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    compileSdk = Versions.androidCompileSdkVersion
    buildToolsVersion = "30.0.3"

    defaultConfig {
        minSdk = Versions.androidMinSdkVersion
        targetSdk = Versions.androidTargetSdkVersion
        var versionCode = 1
        var versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    implementation(Versions.AndroidX.coreKtx)
    implementation(Versions.AndroidX.appCompat)
    implementation(Versions.AndroidX.material)
    testImplementation(Versions.Test.jUnit)
    androidTestImplementation(Versions.Test.jUnitExt)
    androidTestImplementation(Versions.Test.espresso)

    // hilt
    implementation (Versions.Hilt.hiltAndroid)
    kapt(Versions.Hilt.hiltCompiler)
}
