plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
}

dependencies {
    implementation(AndroidX.appCompat)
    implementation(AndroidX.ktx)

    /**
     * Unit Test
     */
    androidTestImplementation(UnitTest.junit)
    testImplementation(UnitTest.junit)
    testImplementation(UnitTest.ext)
}