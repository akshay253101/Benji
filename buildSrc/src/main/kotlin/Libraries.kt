object Libraries {
    val coreDependencies = listOf(
        //Kotlin
        Dependencies.Kotlin.kotlin,
        Dependencies.AndroidX.appCompat,

        //Constraint Layout
        Dependencies.ConstraintLayout.constraintlayout,

        // Android X
        Dependencies.AndroidX.androidx,

        // Android Lifecycle Architecture And View Model
        Dependencies.Lifecycle.lifecycleExtension,
        Dependencies.Lifecycle.lifecycleViewModel,

        // Espresso dependencies
        Dependencies.Esspresso.espressoIdling,

        // Recycler View
        Dependencies.RecyclerView.recycelerView,

        //Material Design
        Dependencies.MaterialDesign.material,

        // Retrofit
        Dependencies.Retrofit.retrofit,
        Dependencies.Retrofit.retrofitAdapter,
        Dependencies.Retrofit.retrofitConverterGson,
        Dependencies.Retrofit.retrofitConverterMoshi,
        Dependencies.Retrofit.okhttp3,

        // RX Java
        Dependencies.RxJava.rxjava,

        // Dagger 2
        Dependencies.Dagger.dagger,
        Dependencies.Dagger.daggerSupport,

        // Navigation
        Dependencies.Navigation.navigationFragment,
        Dependencies.Navigation.navigationFragmentKTX,
        Dependencies.Navigation.navigationUiKit,

        // Room Database
        Dependencies.Room.roomRuntime,
        Dependencies.Room.roomRxJava,

        //Google Sign In
        Dependencies.GoogleSignIn.googleAuth,

        //Glide
        Dependencies.Glide.glide,

        //FireBase
        Dependencies.Firesbase.firebaseCore,
        Dependencies.Firesbase.firebaseAuth,
        Dependencies.Firesbase.firebasePerformance,
        Dependencies.Firesbase.firebaseMessaging,

        // MultiDex
        Dependencies.MultiDex.multiDex,

        // Work Manager
        Dependencies.WorkManager.workManger
    )

    val testDependencies = listOf(
        // JUnit Test
        Dependencies.Junit.junit,

        // AndroidJUnitRunner and JUnit Rules
        Dependencies.Junit.testRunner,
        Dependencies.Junit.testCore,
        Dependencies.Junit.testRules,

        // Espresso dependencies
        Dependencies.Esspresso.espressoIdlingTest,
        Dependencies.Esspresso.espressoCore,
        Dependencies.Esspresso.espressoContrib,
        Dependencies.Esspresso.uiAutomator,
        Dependencies.Esspresso.hamcrest,

        // Room Database
        Dependencies.Room.roomTest
    )

    val kaptDependencies = listOf(
        // Dagger 2
        Dependencies.Dagger.daggerCompilerKapt,
        Dependencies.Dagger.daggerAnnotationProcesserKapt,

        // Room Database
        Dependencies.Room.roomKapt,

        // Glide
        Dependencies.Glide.glideKapt
    )
}