[ ![Download](https://api.bintray.com/packages/pawegio/maven/com.pawegio.kandroid%3Akandroid/images/download.svg) ](https://bintray.com/pawegio/maven/com.pawegio.kandroid%3Akandroid/_latestVersion)

# KAndroid
<img src="art/logo.png" width="160px">

Kotlin library for Android providing useful extensions to eliminate boilerplate code in Android SDK and focus on productivity. Library is currently compatible with latest Kotlin M11 build.

Download
--------

Download latest version with Gradle:
```groovy
repositories {
    jcenter()
}

dependencies {
    compile 'com.pawegio.kandroid:kandroid:0.1.6@aar'
}
```

Usage
-----
#### Binding views
```kotlin
// instead of findViewById(R.id.textView) as TextView
val textView = findView<TextView>(R.id.textView)
```
#### Using system services
```kotlin
// instead of getSystemService(Context.WINDOW_SERVICE) as WindowManager
getWindowManager()
// instead of getSystemService(Context.POWER_SERVICE) as PowerManager
getPowerManager()
// instead of getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
getNotificationManager()
// instead of getSystemService(Context.USER_SERVICE) as UserManager
getUserManager()
// etc.
```
#### Toast messages
```kotlin
longToast("I'm long toast message!")
shortToast("Hi, I'm short one!")
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
// using javaClass.getName() as a TAG
v("Verbose log message")
d("Debug log message")
i("Info log message")
w("Warn log message")
e("Error log message")
// or with custom TAG
v("CustomTag", "Verbose log message with custom tag") 
```
#### Threading
```kotlin
// instead of Thread(Runnable { /* long execution */ }).start()
runAsync {
    // long execution
}
```
#### More
Under development so expect soon.
License
-------

    Copyright 2015 Paweł Gajda

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
