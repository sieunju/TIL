plugins {
    id("com.android.library")
    id("dagger.hilt.android.plugin")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
}

dependencies {
    /**
     * Android X
     */
    implementation(AndroidX.appCompat)

    /**
     * Hilt
     */
    implementation(Hilt.android)
    kapt(Hilt.compiler)
}