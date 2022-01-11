plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(Apps.compileSdkVersion)
    buildToolsVersion(Apps.buildToolsVersion)

    defaultConfig {
        applicationId = "com.hmju.til"
        minSdkVersion(Apps.minSdkVersion)
        targetSdkVersion(Apps.targetSdkVersion)
        versionCode = Apps.versionCode
        versionName = Apps.versionName

        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
        }

        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
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
    implementation(project(path = ":data"))
    /**
     * Android X
     */
    implementation(AndroidX.ktx)
    implementation(AndroidX.appCompat)
    implementation(AndroidX.activity)
    implementation(AndroidX.material)
    implementation(AndroidX.constraintLayout)
    implementation(AndroidX.multidex)

    /**
     * Dagger
     */
    implementation(Dagger.dagger)
    kapt(Dagger.compiler)
    kaptTest(Dagger.compiler)
    kaptAndroidTest(Dagger.compiler)

    testImplementation(UnitTest.junit)
    androidTestImplementation(UnitTest.androidXJunit)
    androidTestImplementation(UnitTest.Espresso.core)
    androidTestImplementation(UnitTest.Espresso.intents)
}