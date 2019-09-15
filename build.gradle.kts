// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
        maven(url = "https://maven.fabric.io/public")
        maven(url = "https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.5.0") // Gradle Build Tools
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.org_jetbrains_kotlin}") // Kotlin
        classpath("com.google.gms:google-services:4.3.2") // Google Play Service
        classpath("io.fabric.tools:gradle:${Versions.io_fabric_tools_gradle}") // Fabric Tools
        classpath("com.google.firebase:perf-plugin:1.3.1")  // Performance Monitoring plugin
        classpath("org.jlleitschuh.gradle:ktlint-gradle:${Versions.ktlint_gradle}")
        // NOTE: Do not place your application Versions here they belong
        // in the individual module build.gradle.kts files
    }
}

plugins {
    id("de.fayard.buildSrcVersions") version "0.4.2"
}

allprojects {
    repositories {
        google()
        jcenter()
    }
    /*gradle.projectsEvaluated {
        tasks.withType(JavaCompile) {
            options.compilerArgs << "-Xlint:unchecked"
        }
    }*/
}

tasks {
    registering(Delete::class) {
        delete(buildDir)
    }
}
