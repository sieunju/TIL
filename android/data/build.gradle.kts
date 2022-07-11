plugins {
    id("com.android.library")
    id("kotlinx-serialization")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

android {
}

dependencies {
    implementation(project(":model"))
    implementation(project(":domain"))
    implementation(project(":loginmanager"))
    implementation(project(":likemanager"))
    implementation(project(":rxhandling"))

    implementation(Kotlin.stdLib)
    implementation(AndroidX.ktx)

    /**
     * Kotlinx Serialization
     */
    implementation(KotlinX.serialization)

    /**
     * Network
     */
    implementation(Retrofit.base)
    implementation(Retrofit.okhttp)
    implementation(Retrofit.rxjava)
    implementation(Retrofit.kotlinx)
    implementation(Retrofit.okhttpLogger)

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

    /**
     * Libs
     */
    implementation(Libs.httpTracking)

    implementation(Log.timber)

    /**
     * Unit Test
     */
    testImplementation(UnitTest.junit)
    androidTestImplementation(UnitTest.junit)
    testImplementation(UnitTest.ext)
    androidTestImplementation(UnitTest.rules)
    androidTestImplementation(UnitTest.runner)
}
