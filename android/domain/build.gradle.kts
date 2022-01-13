plugins {
    id("java-library")
    id("kotlin")
    id("kotlinx-serialization")
}

//android {
//    compileSdkVersion(Apps.compileSdkVersion)
//
//    defaultConfig {
//        minSdkVersion(Apps.minSdkVersion)
//        targetSdkVersion(Apps.targetSdkVersion)
//
//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//    }
//
//    buildTypes {
//        getByName("debug") {
//            isMinifyEnabled = false
//        }
//
//        getByName("release") {
//            isMinifyEnabled = true
//            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
//        }
//    }
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_1_8
//        targetCompatibility = JavaVersion.VERSION_1_8
//    }
//    kotlinOptions {
//        jvmTarget = "1.8"
//    }
//}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(project(":model"))

//    /**
//     * Hilt
//     */
//    implementation(Hilt.android)
//    kapt(Hilt.compiler)

    implementation(Javax.inject)

    /**
     * Rx
     */
    implementation(Rx.java)
    implementation(Rx.kotlin)
}