plugins {
    id("com.android.library")
    kotlin("android")
}

android {
}

dependencies {
    implementation(project(":model"))

    /**
     * Rx
     */
    implementation(Rx.java)
    implementation(Rx.kotlin)

    androidTestImplementation(UnitTest.junit)
    testImplementation(UnitTest.junit)
    testImplementation(UnitTest.ext)
}
