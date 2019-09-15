import org.jlleitschuh.gradle.ktlint.reporter.ReporterType
import java.io.FileInputStream
import java.util.*

plugins {
    id("com.android.application")
    id("io.fabric")
    id("com.google.firebase.firebase-perf")
    id("org.jlleitschuh.gradle.ktlint")

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

    ktlintRuleset("com.github.username:rulseset:master-SNAPSHOT")
    ktlintRuleset(files("/path/to/custom/rulseset.jar"))
}

ktlint {
    android.set(true)
    version.set(Versions.ktlintPlugin)
    debug.set(true)
    verbose.set(true)
    android.set(false)
    outputToConsole.set(true)
    reporters.set(setOf(ReporterType.PLAIN, ReporterType.CHECKSTYLE))
    ignoreFailures.set(true)
    enableExperimentalRules.set(true)
    additionalEditorconfigFile.set(file("/some/additional/.editorconfig"))
    kotlinScriptAdditionalPaths {
        include(fileTree("scripts/"))
    }
    filter {
        exclude("**/generated/**")
        include("**/kotlin/**")
    }
}


apply(mapOf("plugin" to "com.google.gms.google-services"))

