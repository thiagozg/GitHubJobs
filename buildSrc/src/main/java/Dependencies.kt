/*
 * Created by Thiago Zagui Giacomini on 21/05/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
object Dependencies {

    object AppModule {
        const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
        const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
        const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Version.navigationFragmentKtx}"
        const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Version.navigationUiKtx}"
        const val materialDesign = "com.google.android.material:material:${Version.materialDesign}"
        const val lottie = "com.airbnb.android:lottie:${Version.lottie}"
        const val legacySupportV4 = "androidx.legacy:legacy-support-v4:${Version.legacySupportV4}"

        object Network {
            const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Version.okHttp}"
            const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
            const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"

            const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutineCore}"
            const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutineCore}"
            const val coroutineRetrofitAdapter = "com.jakewharton.retrofit:" +
                    "retrofit2-kotlin-coroutines-experimental-adapter:${Version.coroutineRetrofitAdapter}"
        }

        /*
           architecture = Group {
        implementation "android.arch.lifecycle:viewmodel:$versions.architecture"
        implementation "android.arch.lifecycle:livedata:$versions.architecture"
        kapt "android.arch.lifecycle:compiler:$versions.architecture"
        implementation "android.arch.lifecycle:extensions:$versions.architecture"
        implementation "android.arch.lifecycle:reactivestreams:$versions.architecture"
    }
         */
    }

    object UnitTests {
        const val jUnit = "junit:junit:${Version.jUnit}"
    }

    object UiTests {
        const val extJUnit = "androidx.test.ext:junit:${Version.extJUnit}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Version.espressoCore}"
    }
}