plugins {
    id("com.android.application")
    id("kotlinx-serialization")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

android {
    signingConfigs {
        create("release") {
            storeFile = file("/Users/juhongmin/Documents/workStudio/tilkeystore/tilkeystore")
            storePassword = "apple1234!"
            keyAlias = "til"
            keyPassword = "apple1234!"
        }
    }
    compileSdk = Apps.compileSdkVersion
    buildToolsVersion = Apps.buildToolsVersion

    defaultConfig {
        applicationId = "com.hmju.til"
        minSdk = Apps.minSdkVersion
        targetSdk = Apps.targetSdkVersion
        versionCode = Apps.versionCode
        versionName = Apps.versionName
        setProperty("archivesBaseName", "til_${versionCode}_${versionName}")
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
        }

        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("release")
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
}

dependencies {
    implementation(project(path = ":data"))
    implementation(project(path = ":model"))
    implementation(project(path = ":domain"))
    implementation(project(path = ":loginmanager"))
    implementation(project(path = ":presentation"))
    implementation(project(path = ":rxbus"))

    /**
     * Network
     */
    implementation(Retrofit.base)
    implementation(Retrofit.okhttp)
    implementation(Retrofit.okhttpLogger)
    implementation(Retrofit.rxjava)
    implementation(Retrofit.kotlinx)

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
     * Hilt
     */
    implementation(Hilt.android)
    kapt(Hilt.compiler)

    /**
     * Kotlinx Serialization
     */
    implementation(KotlinX.serialization)
    implementation(Kotlin.stdLib)

    /**
     * Rx
     */
    implementation(Rx.java)
    implementation(Rx.kotlin)

    /**
     * Timber
     */
    implementation(Log.timber)

    testImplementation(UnitTest.junit)
    androidTestImplementation(UnitTest.androidXJunit)
    androidTestImplementation(UnitTest.Espresso.core)
    androidTestImplementation(UnitTest.Espresso.intents)
}