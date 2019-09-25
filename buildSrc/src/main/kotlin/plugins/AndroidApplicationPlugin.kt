package plugins

import Version.Android.appId
import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

/*
 * Created by Thiago Zagui Giacomini on 21/09/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
class AndroidApplicationPlugin : Plugin<Project> {

    override fun apply(target: Project): Unit = target.run {
        plugins.apply("com.android.application")
        target.run {
            val android = extensions.getByName("android") as? BaseExtension
            android?.defaultConfig { applicationId = appId }
            configurePlugins()
            configureAndroid()
        }
    }
}
