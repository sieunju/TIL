plugins {
    id("java-library")
    id("kotlin")
    id("kotlinx-serialization")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(project(":model"))
    implementation(project(":likemanager"))
    implementation(Javax.inject)

    /**
     * Rx
     */
    implementation(Rx.java)
    implementation(Rx.kotlin)
}