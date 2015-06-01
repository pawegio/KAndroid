[ ![Download](https://api.bintray.com/packages/pawegio/maven/com.pawegio.kandroid%3Akandroid/images/download.svg) ](https://bintray.com/pawegio/maven/com.pawegio.kandroid%3Akandroid/_latestVersion) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-KAndroid-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/1705) [![](https://img.shields.io/badge/AndroidWeekly-%23148-blue.svg)](http://androidweekly.net/issues/issue-148)

# KAndroid
<img src="art/logo.png" width="160px">

Kotlin library for Android providing useful extensions to eliminate boilerplate code in Android SDK and focus on productivity. Library is currently compatible with latest **Kotlin M12** build.

Download
--------

Download latest version with Gradle:
```groovy
repositories {
    jcenter()
}

dependencies {
    compile 'com.pawegio.kandroid:kandroid:0.1.13@aar'
}
```

Usage
-----
#### Binding views
```kotlin
// instead of findViewById(R.id.textView) as TextView
val textView = find<TextView>(R.id.textView)
```
#### SearchView extensions
```kotlin
/* instead of:
searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
    override fun onQueryTextChange(q: String): Boolean {
        update(q)
        return false
    }
    
    override fun onQueryTextSubmit(q: String): Boolean {
        return false
    }
}) */
searchView.onQueryChange { query -> update(query) }

/* instead of:
searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
    override fun onQueryTextChange(q: String): Boolean {
        return false
    }
    
    override fun onQueryTextSubmit(q: String): Boolean {
        update(q)
        return false
    }
}) */
searchView.onQuerySubmit { query -> update(query) }
```
#### Accessing Activity methods from Fragment
```kotlin
// instead of (getActivity() as SampleActivity).foo()
getActivity<SampleActivity>().foo()
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
toast("Hi, I'm short one!")
```
#### Layout inflater
```kotlin
// instead of LayoutInflater.from(context).inflate(R.layout.some_layout, null, false)
context.inflateLayout(R.layout.some_layout)
// or
context.inflateLayout(R.layout.some_layout, attachToRoot = true)
```
#### Using Intents
```kotlin
// instead of Intent(this, javaClass<SampleActivity>())
val intent = IntentFor<SampleActivity>(this)
```
#### Logging
```kotlin
// using javaClass.getSimpleName() as a TAG
v("Verbose log message")
d("Debug log message")
i("Info log message")
w("Warn log message")
e("Error log message")
wtf("WTF log message")
// or with custom TAG
v("CustomTag", "Verbose log message with custom tag") 
```
#### Threading
```kotlin
// instead of Thread(Runnable { /* long execution */ }).start()
runAsync {
    // long execution
}

// delayed run (e.g. after 1000 millis)
// equals Handler().postDelayed(Runnable { /* delayed execution */ }, delayMillis)
runDelayed(1000) {
    // delayed execution
}

// run on Main Thread outside Activity
// equals Handler(Looper.getMainLooper()).post(Runnable { /* UI update */ })
runOnUiThread {
    // UI update
}

// delayed run on Main Thread
// equals Handler(Looper.getMainLooper()).postDelayed(Runnable { /* delayed UI update */ }, delayMillis)
runDelayedOnUiThread(5000) {
    // delayed UI update
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
