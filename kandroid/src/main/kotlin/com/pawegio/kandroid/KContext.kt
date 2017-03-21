/*
 * Copyright 2015-2016 Paweł Gajda
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pawegio.kandroid

import android.accounts.AccountManager
import android.app.*
import android.app.admin.DevicePolicyManager
import android.app.job.JobScheduler
import android.appwidget.AppWidgetManager
import android.bluetooth.BluetoothManager
import android.content.ClipboardManager
import android.content.Context
import android.content.RestrictionsManager
import android.content.pm.LauncherApps
import android.content.pm.PackageManager
import android.hardware.ConsumerIrManager
import android.hardware.SensorManager
import android.hardware.camera2.CameraManager
import android.hardware.display.DisplayManager
import android.hardware.input.InputManager
import android.hardware.usb.UsbManager
import android.location.LocationManager
import android.media.AudioManager
import android.media.MediaRouter
import android.media.projection.MediaProjectionManager
import android.media.session.MediaSessionManager
import android.media.tv.TvInputManager
import android.net.ConnectivityManager
import android.net.nsd.NsdManager
import android.net.wifi.WifiManager
import android.net.wifi.p2p.WifiP2pManager
import android.nfc.NfcManager
import android.os.*
import android.os.storage.StorageManager
import android.preference.PreferenceManager
import android.print.PrintManager
import android.support.annotation.LayoutRes
import android.support.v4.content.ContextCompat
import android.telecom.TelecomManager
import android.telephony.TelephonyManager
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import android.view.accessibility.AccessibilityManager
import android.view.accessibility.CaptioningManager
import android.view.inputmethod.InputMethodManager
import android.view.textservice.TextServicesManager

val Context.displayWidth
    get() = resources.displayMetrics.widthPixels

val Context.displayHeight
    get() = resources.displayMetrics.heightPixels

fun Context.inflateLayout(@LayoutRes layoutResId: Int, parent: ViewGroup? = null, attachToRoot: Boolean = false)
        = LayoutInflater.from(this).inflate(layoutResId, parent, attachToRoot)

val Context.accessibilityManager
    get() = getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager?

val Context.accountManager
    get() = getSystemService(Context.ACCOUNT_SERVICE) as AccountManager?

val Context.activityManager
    get() = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager?

val Context.alarmManager
    get() = getSystemService(Context.ALARM_SERVICE) as AlarmManager?

val Context.appWidgetManager
    get() = getSystemService(Context.APPWIDGET_SERVICE) as AppWidgetManager?

val Context.appOpsManager
    get() = getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager?

val Context.audioManager
    get() = getSystemService(Context.AUDIO_SERVICE) as AudioManager?

val Context.batteryManager
    get() = getSystemService(Context.BATTERY_SERVICE) as BatteryManager?

val Context.bluetoothManager
    get() = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager?

val Context.cameraManager
    get() = getSystemService(Context.CAMERA_SERVICE) as CameraManager?

val Context.captioningManager
    get() = getSystemService(Context.CAPTIONING_SERVICE) as CaptioningManager?

val Context.clipboardManager
    get() = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?

val Context.connectivityManager
    get() = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?

val Context.consumerIrManager
    get() = getSystemService(Context.CONSUMER_IR_SERVICE) as ConsumerIrManager?

val Context.devicePolicyManager
    get() = getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager?

val Context.displayManager
    get() = getSystemService(Context.DISPLAY_SERVICE) as DisplayManager?

val Context.downloadManager
    get() = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager?

val Context.dropBoxManager
    get() = getSystemService(Context.DROPBOX_SERVICE) as DropBoxManager?

val Context.inputMethodManager
    get() = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?

val Context.inputManager
    get() = getSystemService(Context.INPUT_SERVICE) as InputManager?

val Context.jobScheduler
    get() = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler?

val Context.keyguardManager
    get() = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager?

val Context.launcherApps
    get() = getSystemService(Context.LAUNCHER_APPS_SERVICE) as LauncherApps?

val Context.layoutInflater
    get() = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater?

val Context.locationManager
    get() = getSystemService(Context.LOCATION_SERVICE) as LocationManager?

val Context.mediaProjectionManager
    get() = getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager?

val Context.mediaRouter
    get() = getSystemService(Context.MEDIA_ROUTER_SERVICE) as MediaRouter?

val Context.mediaSessionManager
    get() = getSystemService(Context.MEDIA_SESSION_SERVICE) as MediaSessionManager?

val Context.nfcManager
    get() = getSystemService(Context.NFC_SERVICE) as NfcManager?

val Context.notificationManager
    get() = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?

val Context.nsdManager
    get() = getSystemService(Context.NSD_SERVICE) as NsdManager?

val Context.powerManager
    get() = getSystemService(Context.POWER_SERVICE) as PowerManager?

val Context.printManager
    get() = getSystemService(Context.PRINT_SERVICE) as PrintManager?

val Context.restrictionsManager
    get() = getSystemService(Context.RESTRICTIONS_SERVICE) as RestrictionsManager?

val Context.searchManager
    get() = getSystemService(Context.SEARCH_SERVICE) as SearchManager?

val Context.sensorManager
    get() = getSystemService(Context.SENSOR_SERVICE) as SensorManager?

val Context.storageManager
    get() = getSystemService(Context.STORAGE_SERVICE) as StorageManager?

val Context.telecomManager
    get() = getSystemService(Context.TELECOM_SERVICE) as TelecomManager?

val Context.telephonyManager
    get() = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager?

val Context.textServicesManager
    get() = getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE) as TextServicesManager?

val Context.tvInputManager
    get() = getSystemService(Context.TV_INPUT_SERVICE) as TvInputManager?

val Context.uiModeManager
    get() = getSystemService(Context.UI_MODE_SERVICE) as UiModeManager?

val Context.usbManager
    get() = getSystemService(Context.USB_SERVICE) as UsbManager?

val Context.userManager
    get() = getSystemService(Context.USER_SERVICE) as UserManager?

val Context.vibrator
    get() = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator?

val Context.wallpaperManager
    get() = getSystemService(Context.WALLPAPER_SERVICE) as WallpaperManager?

val Context.wifiP2pManager
    get() = getSystemService(Context.WIFI_P2P_SERVICE) as WifiP2pManager?

val Context.wifiManager
    get() = getSystemService(Context.WIFI_SERVICE) as WifiManager?

val Context.windowManager
    get() = getSystemService(Context.WINDOW_SERVICE) as WindowManager?

val Context.defaultSharedPreferences
    get() = PreferenceManager.getDefaultSharedPreferences(this)

inline fun <reified T : Any> Context.startActivity() = startActivity(IntentFor<T>(this))

fun Context.isPermissionGranted(permission: String): Boolean =
        ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED

fun Context.arePermissionsGranted(vararg permissions: String): Boolean =
        permissions.all { ContextCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_GRANTED }