[ ![Download](https://api.bintray.com/packages/pawegio/maven/com.pawegio.kandroid%3Akandroid/images/download.svg) ](https://bintray.com/pawegio/maven/com.pawegio.kandroid%3Akandroid/_latestVersion) [![Build Status](https://travis-ci.org/pawegio/KAndroid.svg?branch=master)](https://travis-ci.org/pawegio/KAndroid) [![Average time to resolve an issue](http://isitmaintained.com/badge/resolution/pawegio/KAndroid.svg)](http://isitmaintained.com/project/pawegio/KAndroid "Average time to resolve an issue") [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-KAndroid-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/1705) [![](https://img.shields.io/badge/AndroidWeekly-%23148-blue.svg)](http://androidweekly.net/issues/issue-148) <a href="http://www.methodscount.com/?lib=com.pawegio.kandroid%3Akandroid%3A0.8.3"><img src="https://img.shields.io/badge/Methods count-407-e91e63.svg"/></a>

# KAndroid
<img src="art/logo.png" width="160px">

Kotlin library for Android providing useful extensions to eliminate boilerplate code in Android SDK and focus on productivity. Library is compatible with **Kotlin 1.1.51** build.

Download
--------

Download latest version with Gradle:
```groovy
repositories {
    jcenter()
}

dependencies {
    compile 'com.pawegio.kandroid:kandroid:0.8.5@aar'
}
```

Usage
-----
#### Binding views
```kotlin
// instead of findViewById(R.id.textView) as TextView
val textView = find<TextView>(R.id.textView)
```
#### Accessing ViewGroup children
```kotlin
/* instead of:
for (i in 0..layout - 1) {
    layout.getChildAt(i).visibility = View.GONE
}
*/
layout.views.forEach { it.visibility = View.GONE }
```
#### TextWatcher
```kotlin
/* instead of:
editText.addTextChangedListener(object : TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        before()
    }
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        onChange()
    }
    override fun afterTextChanged(s: Editable?) {
        after()
    }
}) */
editText.textWatcher {
    beforeTextChanged { text, start, count, after -> before() }
    onTextChanged { text, start, before, count -> onChange() }
    afterTextChanged { text -> after() }
}
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
#### SeekBar extension
```kotlin
/* instead of:
seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
    override fun onStopTrackingTouch(seekBar: SeekBar) {

    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
        mediaPlayer.seekTo(progress)
    }

}) */
seekBar.onProgressChanged { progress, fromUser -> 
    if (fromUser) mediaPlayer.seekTo(progress) 
}
```
#### Using system services
```kotlin
// instead of getSystemService(Context.WINDOW_SERVICE) as WindowManager?
windowManager
// instead of getSystemService(Context.POWER_SERVICE) as PowerManager?
powerManager
// instead of getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?
notificationManager
// instead of getSystemService(Context.USER_SERVICE) as UserManager?
userManager
// etc.
```
#### Toast messages
```kotlin
longToast("I'm long toast message!")
toast("Hi, I'm short one!")

longToast(R.string.my_string)
toast(R.string.my_string)
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
// instead of startActivity(Intent(this, javaClass<SampleActivity>()))
startActivity<SampleActivity>()
// instead of startActivityForResult(Intent(this, javaClass<SampleActivity>()), REQUEST_CODE)
startActivityForResult<SampleActivity>(REQUEST_CODE)
```
#### Logging
```kotlin
// using javaClass.simpleName as a TAG
w("Warn log message")
e("Error log message")
wtf("WTF log message")
// using lambda log method
v { "Verbose log message" }
d { "Debug log message" }
i { "Info log message" }
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
#### From/To API SDK
```kotlin
// instead of if (Build.VERSION.SDK_INT >= 21) { /* run methods available since API 21 */ }
fromApi(21) {
    // run methods available since API 21
}

// instead of if (Build.VERSION.SDK_INT < 16) { /* handle devices using older APIs */ }
toApi(16) {
    // handle devices running older APIs
}
// or
// instead of if (Build.VERSION.SDK_INT <= 16) { /* handle devices using older APIs */ }
toApi(16, inclusive = true) {
    // handle devices running older APIs
}
```
#### Loading animation from xml
```kotlin
// instead of AnimationUtils.loadAnimation(applicationContext, R.anim.slide_in_left)
loadAnimation(R.anim.slide_in_left)
```
#### Animation listener
```kotlin

/*instead of:
animation.setAnimationListener(object : Animation.AnimationListener{
	override fun onAnimationStart(animation: Animation?) {
		onStart()
	}
	override fun onAnimationEnd(animation: Animation?) {
		onEnd()
	}
	override fun onAnimationRepeat(animation: Animation) {
		onRepeat()
	}
})*/

animation.animListener {
	onAnimationStart { onStart() }
	onAnimationEnd { onEnd() }
	onAnimationRepeat { onRepeat() }
}
```
#### Web intents with url validation
```kotlin
// instead of Intent(Intent.ACTION_VIEW, Uri.parse("http://github.com"))
WebIntent("http://github.com")
```
#### More
Under development so expect soon.
Apps using KAndroid
-------
(contact me or create new pull request to add your apps)
* [Recorder](https://play.google.com/store/apps/details?id=com.pawegio.recandsave)

License
-------

    Copyright 2015-2017 Paweł Gajda

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
