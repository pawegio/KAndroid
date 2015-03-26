package com.pawegio.kandroid

import android.app.Activity
import android.app.AlarmManager
import android.app.NotificationManager
import android.content.Context
import android.hardware.SensorManager
import android.os.PowerManager
import android.view.View
import android.view.WindowManager
import android.widget.Toast

/**
 * @author pawegio
 */
[suppress("UNCHECKED_CAST")]
public fun Activity.findView<T : View>(id: Int): T = findViewById(id) as T

public fun Activity.getWindowManager(): WindowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager

public fun Activity.getPowerManager(): PowerManager = getSystemService(Context.POWER_SERVICE) as PowerManager

public fun Activity.getAlarmManager(): AlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

public fun Activity.getNotificationManager(): NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

public fun Activity.getSensorManager(): SensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

public fun Activity.longToast(text: CharSequence): Unit = Toast.makeText(this, text, Toast.LENGTH_LONG).show()

public fun Activity.shortToast(text: CharSequence): Unit = Toast.makeText(this, text, Toast.LENGTH_SHORT).show()