import com.beust.kobalt.buildScript
import com.beust.kobalt.plugin.packaging.assemble
import com.beust.kobalt.project

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

    assemble {
        jar {
        }
    }

}
