import java.io.FileInputStream
import java.util.*

plugins {
    id("com.android.application")
    id("io.fabric")
    id("com.google.firebase.firebase-perf")

    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(29)
    dataBinding.isEnabled = true

    defaultConfig {
        applicationId = "com.example.beetlestance.benji"
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        manifestPlaceholders = mapOf("FABRIC_API_KEY" to getFabricApiKey())
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            isDebuggable = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildToolsVersion = "28.0.3"
}

fun getFabricApiKey(): Any? {
    val properties = Properties()
    properties.load(FileInputStream("fabric.properties"))
    return properties["FABRIC_API_KEY"]
}

dependencies {
    implementation(fileTree(mapOf("include" to listOf("*.jar"), "dir" to "libs")))

    for (dependency in Libraries.coreDependencies) {
        implementation(dependency)
    }

    for (dependency in Libraries.testDependencies) {
        implementation(dependency)
    }

    for (dependency in Libraries.kaptDependencies) {
        kapt(dependency)
    }

    // Crashlytics
    implementation(Dependencies.Crashlytics.crashlytics) {
        isTransitive = true
    }
}

apply(mapOf("plugin" to "com.google.gms.google-services"))

