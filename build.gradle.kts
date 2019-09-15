// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
        maven(url = "https://maven.fabric.io/public")
        maven(url = "https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath(Libs.com_android_tools_build_gradle) // Gradle Build Tools
        classpath(Libs.kotlin_gradle_plugin) // Kotlin
        classpath(Libs.google_services) // Google Play Service
        classpath(Libs.io_fabric_tools_gradle) // Fabric Tools
        classpath(Libs.perf_plugin)  // Performance Monitoring plugin
        classpath(Libs.ktlint_gradle)
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
