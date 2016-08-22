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
import android.content.SharedPreferences
import android.content.pm.LauncherApps
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
import android.telecom.TelecomManager
import android.telephony.TelephonyManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.accessibility.AccessibilityManager
import android.view.accessibility.CaptioningManager
import android.view.inputmethod.InputMethodManager
import android.view.textservice.TextServicesManager

val Context.displayWidth: Int
    get() = resources.displayMetrics.widthPixels

val Context.displayHeight: Int
    get() = resources.displayMetrics.heightPixels

fun Context.inflateLayout(layoutResId: Int, parent: ViewGroup? = null, attachToRoot: Boolean = false): View
        = LayoutInflater.from(this).inflate(layoutResId, parent, attachToRoot)

val Context.accessibilityManager: AccessibilityManager?
    get() = getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager?

val Context.accountManager: AccountManager?
    get() = getSystemService(Context.ACCOUNT_SERVICE) as AccountManager?

val Context.activityManager: ActivityManager?
    get() = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager?

val Context.alarmManager: AlarmManager?
    get() = getSystemService(Context.ALARM_SERVICE) as AlarmManager?

val Context.appWidgetManager: AppWidgetManager?
    get() = getSystemService(Context.APPWIDGET_SERVICE) as AppWidgetManager?

val Context.appOpsManager: AppOpsManager?
    get() = getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager?

val Context.audioManager: AudioManager?
    get() = getSystemService(Context.AUDIO_SERVICE) as AudioManager?

val Context.batteryManager: BatteryManager?
    get() = getSystemService(Context.BATTERY_SERVICE) as BatteryManager?

val Context.bluetoothManager: BluetoothManager?
    get() = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager?

val Context.cameraManager: CameraManager?
    get() = getSystemService(Context.CAMERA_SERVICE) as CameraManager?

val Context.captioningManager: CaptioningManager?
    get() = getSystemService(Context.CAPTIONING_SERVICE) as CaptioningManager?

val Context.clipboardManager: ClipboardManager?
    get() = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?

val Context.connectivityManager: ConnectivityManager?
    get() = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?

val Context.consumerIrManager: ConsumerIrManager?
    get() = getSystemService(Context.CONSUMER_IR_SERVICE) as ConsumerIrManager?

val Context.devicePolicyManager: DevicePolicyManager?
    get() = getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager?

val Context.displayManager: DisplayManager?
    get() = getSystemService(Context.DISPLAY_SERVICE) as DisplayManager?

val Context.downloadManager: DownloadManager?
    get() = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager?

val Context.dropBoxManager: DropBoxManager?
    get() = getSystemService(Context.DROPBOX_SERVICE) as DropBoxManager?

val Context.inputMethodManager: InputMethodManager?
    get() = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?

val Context.inputManager: InputManager?
    get() = getSystemService(Context.INPUT_SERVICE) as InputManager?

val Context.jobScheduler: JobScheduler?
    get() = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler?

val Context.keyguardManager: KeyguardManager?
    get() = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager?

val Context.launcherApps: LauncherApps?
    get() = getSystemService(Context.LAUNCHER_APPS_SERVICE) as LauncherApps?

val Context.layoutInflater: LayoutInflater?
    get() = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater?

val Context.locationManager: LocationManager?
    get() = getSystemService(Context.LOCATION_SERVICE) as LocationManager?

val Context.mediaProjectionManager: MediaProjectionManager?
    get() = getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager?

val Context.mediaRouter: MediaRouter?
    get() = getSystemService(Context.MEDIA_ROUTER_SERVICE) as MediaRouter?

val Context.mediaSessionManager: MediaSessionManager?
    get() = getSystemService(Context.MEDIA_SESSION_SERVICE) as MediaSessionManager?

val Context.nfcManager: NfcManager?
    get() = getSystemService(Context.NFC_SERVICE) as NfcManager?

val Context.notificationManager: NotificationManager?
    get() = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?

val Context.nsdManager: NsdManager?
    get() = getSystemService(Context.NSD_SERVICE) as NsdManager?

val Context.powerManager: PowerManager?
    get() = getSystemService(Context.POWER_SERVICE) as PowerManager?

val Context.printManager: PrintManager?
    get() = getSystemService(Context.PRINT_SERVICE) as PrintManager?

val Context.restrictionsManager: RestrictionsManager?
    get() = getSystemService(Context.RESTRICTIONS_SERVICE) as RestrictionsManager?

val Context.searchManager: SearchManager?
    get() = getSystemService(Context.SEARCH_SERVICE) as SearchManager?

val Context.sensorManager: SensorManager?
    get() = getSystemService(Context.SENSOR_SERVICE) as SensorManager?

val Context.storageManager: StorageManager?
    get() = getSystemService(Context.STORAGE_SERVICE) as StorageManager?

val Context.telecomManager: TelecomManager?
    get() = getSystemService(Context.TELECOM_SERVICE) as TelecomManager?

val Context.telephonyManager: TelephonyManager?
    get() = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager?

val Context.textServicesManager: TextServicesManager?
    get() = getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE) as TextServicesManager?

val Context.tvInputManager: TvInputManager?
    get() = getSystemService(Context.TV_INPUT_SERVICE) as TvInputManager?

val Context.uiModeManager: UiModeManager?
    get() = getSystemService(Context.UI_MODE_SERVICE) as UiModeManager?

val Context.usbManager: UsbManager?
    get() = getSystemService(Context.USB_SERVICE) as UsbManager?

val Context.userManager: UserManager?
    get() = getSystemService(Context.USER_SERVICE) as UserManager?

val Context.vibrator: Vibrator?
    get() = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator?

val Context.wallpaperManager: WallpaperManager?
    get() = getSystemService(Context.WALLPAPER_SERVICE) as WallpaperManager?

val Context.wifiP2pManager: WifiP2pManager?
    get() = getSystemService(Context.WIFI_P2P_SERVICE) as WifiP2pManager?

val Context.wifiManager: WifiManager?
    get() = getSystemService(Context.WIFI_SERVICE) as WifiManager?

val Context.windowManager: WindowManager?
    get() = getSystemService(Context.WINDOW_SERVICE) as WindowManager?

val Context.defaultSharedPreferences: SharedPreferences
    get() = PreferenceManager.getDefaultSharedPreferences(this)

inline fun <reified T : Any> Context.startActivity() {
    startActivity(IntentFor<T>(this))
}