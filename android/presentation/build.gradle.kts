plugins {
    id("com.android.library")
    id("kotlinx-serialization")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = Apps.compileSdkVersion

    defaultConfig {
        minSdk = Apps.minSdkVersion
        targetSdk = Apps.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {

        debug {
            isMinifyEnabled = false
        }

        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        dataBinding = true
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation(project(":model"))
    implementation(project(":domain"))
    implementation(project(":loginmanager"))
    implementation(project(":likemanager"))
    implementation(project(":rxbus"))
    implementation(project(":lifecycle"))

    /**
     * Android X
     */
    implementation(AndroidX.ktx)
    implementation(AndroidX.appCompat)
    implementation(AndroidX.constraintLayout)
    implementation(AndroidX.activity)
    implementation(AndroidX.material)
    implementation(AndroidX.multidex)
    implementation(AndroidX.legacy)
    implementation(AndroidX.viewpager)
    implementation(AndroidX.cardView)
    implementation(AndroidX.fragment)
    implementation(AndroidX.recyclerView)
    implementation(AndroidX.lifecycle)
    implementation(AndroidX.viewModel)
    implementation(AndroidX.liveData)

    /**
     * Kotlinx Serialization
     */
    implementation(KotlinX.serialization)

    /**
     * Hilt
     */
    implementation(Hilt.android)
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    kapt(Hilt.compiler)

    /**
     * Rx
     */
    implementation(Rx.java)
    implementation(Rx.kotlin)
    implementation(Rx.android)

    /**
     * Glide
     */
    implementation(Glide.base)
    implementation(Glide.compiler)
    implementation(Glide.okhttp)

    /**
     * Timber
     */
    implementation(Log.timber)

    /**
     * Libs
     */
    implementation(Libs.binding)
    implementation(Libs.bindingReflection)

    /**
     * Unit Test
     */
    androidTestImplementation(Retrofit.okhttp)
    androidTestImplementation(Retrofit.base)
    androidTestImplementation(Retrofit.rxjava)
    androidTestImplementation(Retrofit.kotlinx)
    androidTestImplementation(KotlinX.serialization)

}