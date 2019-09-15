object Dependencies {

    // Kotlin
    object Kotlin {
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin_version}"
    }

    //Androidx
    object AndroidX {
        const val androidx = "androidx.legacy:legacy-support-v4:${Versions.androidx_version}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.app_compat_version}"
    }

    //Constraint Layout
    object ConstraintLayout {
        const val constraintlayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout_version}"
    }

    // Android Lifecycle Architecture And View Model
    object Lifecycle {
        const val lifecycleExtension =
            "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle_version}"
        const val lifecycleViewModel =
            "androidx.lifecycle:lifecycle-viewmodel:${Versions.lifecycle_version}"
    }

    // Recycler View
    object RecyclerView {
        const val recycelerView =
            "androidx.recyclerview:recyclerview:${Versions.recycler_view_version}"
    }

    //Material Design
    object MaterialDesign {
        const val material = "com.google.android.material:material:${Versions.material_version}"
    }

    // Retrofit
    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit_version}"
        const val retrofitAdapter =
            "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit_version}"
        const val retrofitConverterGson =
            "com.squareup.retrofit2:converter-gson:${Versions.retrofit_version}"
        const val retrofitConverterMoshi =
            "com.squareup.retrofit2:converter-moshi:${Versions.retrofit_version}"
        const val okhttp3 = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3_version}"
    }

    // RX Java
    object RxJava {
        const val rxjava = "io.reactivex.rxjava2:rxandroid:${Versions.rxjava_version}"
    }

    // Dagger 2
    object Dagger {
        const val dagger = "com.google.dagger:dagger-android:${Versions.dagger_version}"
        const val daggerSupport =
            "com.google.dagger:dagger-android-support:${Versions.dagger_version}"
        const val daggerCompilerKapt =
            "com.google.dagger:dagger-compiler:${Versions.dagger_version}"
        const val daggerAnnotationProcesserKapt =
            "com.google.dagger:dagger-android-processor:${Versions.dagger_version}"
    }

    // Navigation
    object Navigation {
        const val navigationFragment =
            "android.arch.navigation:navigation-fragment:${Versions.navigation_version}"
        const val navigationFragmentKTX =
            "android.arch.navigation:navigation-fragment-ktx:${Versions.navigation_version}"
        const val navigationUiKit =
            "android.arch.navigation:navigation-ui-ktx:${Versions.navigation_version}"
    }

    // Room Database
    object Room {
        const val roomKapt = "androidx.room:room-compiler:${Versions.room_version}"
        const val roomRuntime = "androidx.room:room-runtime:${Versions.room_version}"
        const val roomRxJava = "androidx.room:room-rxjava2:${Versions.room_version}"
        const val roomTest = "androidx.room:room-testing:${Versions.room_version}"
    }

    //Google Sign In
    object GoogleSignIn {
        const val googleAuth =
            "com.google.android.gms:play-services-auth:${Versions.google_play_service_version}"
    }

    //Glide
    object Glide {
        const val glideKapt = "com.github.bumptech.glide:compiler:${Versions.glide_version}"
        const val glide = "com.github.bumptech.glide:glide:${Versions.glide_version}"
    }

    //FireBase
    object Firesbase {
        const val firebaseCore = "com.google.firebase:firebase-core:${Versions.firebase_version}"
        const val firebaseAuth =
            "com.google.firebase:firebase-auth:${Versions.firebase_analytics_version}"
        const val firebasePerformance =
            "com.google.firebase:firebase-perf:${Versions.firebase_analytics_version}"
        const val firebaseMessaging =
            "com.google.firebase:firebase-messaging:${Versions.firebase_messaging_version}"
    }

    // MultiDex
    object MultiDex {
        const val multiDex = "com.android.support:multidex:${Versions.multidex_version}"
    }

    //Crashlytics
    object Crashlytics {
        const val crashlytics =
            "com.crashlytics.sdk.android:crashlytics:${Versions.crashlytics_version}"
    }

    // Work Manager
    object WorkManager {
        const val workManger = "androidx.work:work-runtime-ktx:${Versions.work_version}"
    }

    // JUnit Test
    object Junit {
        const val junit = "androidx.test.ext:junit:1.1.0"
        const val testRunner = "androidx.test:runner:1.2.0-beta01"
        const val testCore = "androidx.test:core:1.1.0"
        const val testRules = "androidx.test:rules:1.1.1"
    }

    object Esspresso {
        const val espressoIdlingTest = "androidx.test.espresso.idling:idling-concurrent:3.1.1"
        const val espressoCore = "androidx.test.espresso:espresso-core:3.2.0-beta01"
        const val espressoContrib = "androidx.test.espresso:espresso-contrib:3.1.1"
        const val uiAutomator = "androidx.test.uiautomator:uiautomator:2.2.0"
        const val hamcrest = "org.hamcrest:hamcrest-integration:1.3"
        const val espressoIdling =
            "androidx.test.espresso:espresso-idling-resource:${Versions.idling_resources}"

    }
}