package dependencies

/*
 * Created by Thiago Zagui Giacomini on 21/05/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
object Dependencies {

    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
    const val materialDesign = "com.google.android.material:material:${Version.materialDesign}"
    const val lottie = "com.airbnb.android:lottie:${Version.lottie}"
    const val legacySupportV4 = "androidx.legacy:legacy-support-v4:${Version.legacySupportV4}"
    const val glide = "com.github.bumptech.glide:glide:${Version.glide}"
    const val gson = "com.google.code.gson:gson:${Version.gson}"

    object Network {
        const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Version.okHttp}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
        const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"
    }

    object Coroutine {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutineCore}"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutineCore}"
        const val retrofitAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Version.coroutineRetrofitAdapter}"
    }

    object Architecture {
        const val navigationKtx = "androidx.navigation:navigation-fragment-ktx:${Version.navigationFragmentKtx}"
        const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Version.navigationUiKtx}"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel:${Version.architecture}"
        const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.architecture}"
        const val liveDataCore = "androidx.lifecycle:lifecycle-livedata-core:${Version.architecture}"
        const val liveData = "androidx.lifecycle:lifecycle-livedata:${Version.architecture}"
        const val liveDataCompiler = "android.arch.lifecycle:compiler:${Version.architecture}"
    }

    object Koin {
        const val core = "org.koin:koin-core:${Version.koin}"
        const val android = "org.koin:koin-android:${Version.koin}"
        const val androidScope = "org.koin:koin-androidx-scope:${Version.koin}"
        const val androidViewModel = "org.koin:koin-androidx-viewmodel:${Version.koin}"
    }

    object UnitTests {
        const val jUnit = "junit:junit:${Version.jUnit}"
    }

    object UiTests {
        const val extJUnit = "androidx.test.ext:junit:${Version.extJUnit}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Version.espressoCore}"

        operator fun invoke() = arrayOf(extJUnit, espressoCore)
    }
}