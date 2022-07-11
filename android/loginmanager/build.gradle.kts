plugins {
    id("com.android.library")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

android {
}

dependencies {
    implementation(project(":rxbus"))

    /**
     * Hilt
     */
    implementation(Hilt.android)
    kapt(Hilt.compiler)

    /**
     * Rx
     */
    implementation(Rx.java)
    implementation(Rx.kotlin)

    androidTestImplementation(UnitTest.junit)
    testImplementation(UnitTest.junit)
    testImplementation(UnitTest.ext)
}