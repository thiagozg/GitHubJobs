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
    }

    object UnitTests {
        const val jUnit = "junit:junit:${Version.jUnit}"
    }

    object UiTests {
        const val extJUnit = "androidx.test.ext:junit:${Version.extJUnit}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Version.espressoCore}"
    }
}