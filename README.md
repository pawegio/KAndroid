[ ![Download](https://api.bintray.com/packages/pawegio/maven/com.pawegio.kandroid%3Akandroid/images/download.svg) ](https://bintray.com/pawegio/maven/com.pawegio.kandroid%3Akandroid/_latestVersion)

# KAndroid
Kotlin library for Android

Download
--------

Download latest version with Gradle:
```groovy
repositories {
    maven { 
        url 'http://dl.bintray.com/pawegio/maven'
    }
}

dependencies {
    compile 'com.pawegio.kandroid:kandroid:0.1.5@aar'
}
```

Usage
-----
#### Binding views
```kotlin
val textView = findView<TextView>(R.id.textView)
```
#### Using system services
```kotlin
// instead of getSystemService(Context.WINDOW_SERVICE) as WindowManager
val windowManager = getWindowManager()
// instead of getSystemService(Context.POWER_SERVICE) as PowerManager
val powerManager = getPowerManager()
// etc.
```
#### Toast messages
```kotlin
longToast("This shows toast with long duration")
shortToast("This shows toast with short duration")
```
#### Layout inflater
```kotlin
// instead of LayoutInflater.from(context).inflate(R.layout.some_layout, null, false)
inflateLayout(R.layout.some_layout)
// or
inflateLayout(R.layout.some_layout, attachToRoot = true)
```
#### Using Intents
```kotlin
// instead of Intent(this, javaClass<SampleActivity>())
val intent = IntentFor<SampleActivity>(this)
```
#### Logging
```kotlin
v("Verbose log msg")
d("Debug log msg")
i("Info log msg")
w("Warn log msg")
e("Error log msg")
// or
v("Tag", "Verbose log msg with custom tag") 
```
#### Threading
```kotlin
// instead of Thread(Runnable { sampleLongExecution() }).start()
runAsync {
    sampleLongExecution()
}
```
