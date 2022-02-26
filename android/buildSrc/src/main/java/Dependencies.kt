object Apps {
    const val compileSdkVersion = 31
    const val buildToolsVersion = "30.0.3"
    const val minSdkVersion = 23
    const val targetSdkVersion = 30
    const val versionCode = 1
    const val versionName = "0.0.1"
}

object Versions {
    const val kotlin = "1.5.0"
    const val ktx = "1.5.0"
    const val retrofit = "2.9.0"
    const val glide = "4.11.0"
    const val dagger = "2.28"
    const val espresso = "3.2.0"
    const val lifecycle = "2.3.1"
    const val hilt = "2.36"
}

object AndroidX {
    const val ktx = "androidx.core:core-ktx:${Versions.ktx}"
    const val appCompat = "androidx.appcompat:appcompat:1.3.0"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.4"
    const val activity = "androidx.activity:activity-ktx:1.1.0"
    const val material = "com.google.android.material:material:1.4.0"
    const val multidex = "androidx.multidex:multidex:2.0.1"
    const val legacy = "androidx.legacy:legacy-support-v4:1.0.0"
    const val viewpager = "androidx.viewpager2:viewpager2:1.0.0"
    const val cardView = "androidx.cardview:cardview:1.0.0"
    const val fragment = "androidx.fragment:fragment-ktx:1.3.3"
    const val recyclerView = "androidx.recyclerview:recyclerview:1.2.0"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
}

object Kotlin {
    const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
}

object Javax {
    const val inject = "javax.inject:javax.inject:1"
}

object Hilt {
    const val android = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    const val androidx = "androidx.hilt:hilt-compiler:1.0.0-alpha01"
    const val lifecycle = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01"
}

object Rx {
    const val java = "io.reactivex.rxjava3:rxjava:3.1.2"
    const val android = "io.reactivex.rxjava3:rxandroid:3.0.0"
    const val kotlin = "io.reactivex.rxjava3:rxkotlin:3.0.1"
}

object Retrofit {
    const val base = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val rxjava = "com.squareup.retrofit2:adapter-rxjava3:${Versions.retrofit}"
    const val kotlinx = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"
    const val okhttp = "com.squareup.okhttp3:okhttp:4.9.0"
    const val okhttpLogger = "com.squareup.okhttp3:logging-interceptor:4.9.0"
}

object Glide {
    const val base = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val okhttp = "com.github.bumptech.glide:okhttp3-integration:${Versions.glide}"
    const val compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
}

object KotlinX {
    const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1"
}

object Log {
    const val timber = "com.jakewharton.timber:timber:5.0.1"
}

object UnitTest {
    const val junit = "junit:junit:4.12"
    const val androidXJunit = "androidx.test.ext:junit:1.1.3"

    object Espresso {
        const val core = "androidx.test.espresso:espresso-core:${Versions.espresso}"
        const val intents = "androidx.test.espresso:espresso-intents:${Versions.espresso}"
    }
}