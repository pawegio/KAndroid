import com.beust.kobalt.*
import com.beust.kobalt.plugin.packaging.*
import com.beust.kobalt.plugin.application.*
import com.beust.kobalt.plugin.java.*

val kotlin_version = "1.0.6"
val p = project {

    name = "KAndroid"
    group = "com.example"
    artifactId = name
    version = "0.1"

    dependencies {
        compile("com.android.tools.build:gradle:2.1.0",
            "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version",
            "com.github.dcendents:android-maven-gradle-plugin:1.5")
    }

    assemble {
        jar {
        }
    }

}
