object Dependencies {
    val coreDependencies = listOf(
        //Kotlin
        Libs.kotlin_stdlib_jdk7,
        Libs.appcompat,

        //Constraint Layout
        Libs.constraintlayout,

        // Android X
        Libs.legacy_support_v4,

        // Android Lifecycle Architecture And View Model
        Libs.lifecycle_extensions,
        Libs.lifecycle_viewmodel,

        // Espresso dependencies
        Libs.espresso_idling_resource,

        // Recycler View
        Libs.recyclerview,

        //Material Design
        Libs.material,

        // Retrofit
        Libs.retrofit,
        Libs.adapter_rxjava2,
        Libs.converter_gson,
        Libs.converter_moshi,
        Libs.logging_interceptor,

        // RX Java
        Libs.rxandroid,

        // Dagger 2
        Libs.dagger_android,
        Libs.dagger_android_support,

        // Navigation
        Libs.navigation_fragment,
        Libs.navigation_fragment_ktx,
        Libs.navigation_ui_ktx,

        // Room Database
        Libs.room_runtime,
        Libs.room_rxjava2,

        //Google Sign In
        Libs.play_services_auth,

        //Glide
        Libs.glide,

        //FireBase
        Libs.firebase_core,
        Libs.firebase_core,
        Libs.firebase_perf,
        Libs.firebase_messaging,

        // MultiDex
        Libs.multidex,

        // Work Manager
        Libs.work_runtime_ktx
    )

    val testDependencies = listOf(
        // JUnit Test
        Libs.junit,

        // AndroidJUnitRunner and JUnit Rules
        Libs.androidx_test_runner,
        Libs.androidx_test_core,
        Libs.androidx_test_rules,

        // Espresso dependencies
        Libs.idling_concurrent,
        Libs.espresso_core,
        Libs.espresso_contrib,
        Libs.uiautomator,
        Libs.hamcrest_integration,

        // Room Database
        Libs.room_testing
    )

    val kaptDependencies = listOf(
        // Dagger 2
        Libs.dagger_compiler,
        Libs.dagger_android_processor,

        // Room Database
        Libs.room_compiler,

        // Glide
        Libs.com_github_bumptech_glide_compiler
    )
}