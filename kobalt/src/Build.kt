import com.beust.kobalt.buildScript
import com.beust.kobalt.plugin.packaging.assemble
import com.beust.kobalt.project
import com.beust.kobalt.plugin.android.*

val kandroidVersion = "0.6.16"

val bs = buildScript {
    plugins("com.beust:kobalt-android:0.95")
}

val p = project {

    name = "KAndroid"
    group = "com.pawegio.kandroid"
    artifactId = name
    version = kandroidVersion
    directory = "kandroid"

    android {
        defaultConfig {
            minSdkVersion = 16
            versionCode = 1
            versionName = kandroidVersion
            compileSdkVersion = "25"
            buildToolsVersion = "25.0.1"
            applicationId = "com.pawegio.kandroid"
        }
    }

    dependencies {
        compile("com.android.support:appcompat-v7:25.1.0")
    }

    assemble {
        jar {
        }
    }

}
