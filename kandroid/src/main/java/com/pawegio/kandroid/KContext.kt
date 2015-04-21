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

/**
 * @author pawegio
 */
public fun Context.inflateLayout(layoutResId: Int, parent: ViewGroup? = null, attachToRoot: Boolean = false): View
        = LayoutInflater.from(this).inflate(layoutResId, parent, attachToRoot)

public fun Context.getAccessibilityManager(): AccessibilityManager = getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager

public fun Context.getAccountManager(): AccountManager = getSystemService(Context.ACCOUNT_SERVICE) as AccountManager

public fun Context.getActivityManager(): ActivityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

public fun Context.getAlarmManager(): AlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

public fun Context.getAppWidgetManager(): AppWidgetManager = getSystemService(Context.APPWIDGET_SERVICE) as AppWidgetManager

public fun Context.getAppOpsManager(): AppOpsManager = getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager

public fun Context.getAudioManager(): AudioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager

public fun Context.getBatteryManager(): BatteryManager = getSystemService(Context.BATTERY_SERVICE) as BatteryManager

public fun Context.getBluetoothManager(): BluetoothManager = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager

public fun Context.getCameraManager(): CameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager

public fun Context.getCaptioningManager(): CaptioningManager = getSystemService(Context.CAPTIONING_SERVICE) as CaptioningManager

public fun Context.getClipboardManager(): ClipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

public fun Context.getConnectivityManager(): ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

public fun Context.getConsumerIrManager(): ConsumerIrManager = getSystemService(Context.CONSUMER_IR_SERVICE) as ConsumerIrManager

public fun Context.getDevicePolicyManager(): DevicePolicyManager = getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager

public fun Context.getDisplayManager(): DisplayManager = getSystemService(Context.DISPLAY_SERVICE) as DisplayManager

public fun Context.getDownloadManager(): DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

public fun Context.getDropBoxManager(): DropBoxManager = getSystemService(Context.DROPBOX_SERVICE) as DropBoxManager

public fun Context.getInputMethodManager(): InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

public fun Context.getInputManager(): InputManager = getSystemService(Context.INPUT_SERVICE) as InputManager

public fun Context.getJobScheduler(): JobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

public fun Context.getKeyguardManager(): KeyguardManager = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager

public fun Context.getLauncherApps(): LauncherApps = getSystemService(Context.LAUNCHER_APPS_SERVICE) as LauncherApps

public fun Context.getLayoutInflater(): LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

public fun Context.getLocationManager(): LocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

public fun Context.getMediaProjectionManager(): MediaProjectionManager = getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager

public fun Context.getMediaRouter(): MediaRouter = getSystemService(Context.MEDIA_ROUTER_SERVICE) as MediaRouter

public fun Context.getMediaSessionManager(): MediaSessionManager = getSystemService(Context.MEDIA_SESSION_SERVICE) as MediaSessionManager

public fun Context.getNfcManager(): NfcManager = getSystemService(Context.NFC_SERVICE) as NfcManager

public fun Context.getNotificationManager(): NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

public fun Context.getNsdManager(): NsdManager = getSystemService(Context.NSD_SERVICE) as NsdManager

public fun Context.getPowerManager(): PowerManager = getSystemService(Context.POWER_SERVICE) as PowerManager

public fun Context.getPrintManager(): PrintManager = getSystemService(Context.PRINT_SERVICE) as PrintManager

public fun Context.getRestrictionsManager(): RestrictionsManager = getSystemService(Context.RESTRICTIONS_SERVICE) as RestrictionsManager

public fun Context.getSearchManager(): SearchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager

public fun Context.getSensorManager(): SensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

public fun Context.getStorageManager(): StorageManager = getSystemService(Context.STORAGE_SERVICE) as StorageManager

public fun Context.getTelecomManager(): TelecomManager = getSystemService(Context.TELECOM_SERVICE) as TelecomManager

public fun Context.getTelephonyManager(): TelephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

public fun Context.getTextServicesManager(): TextServicesManager = getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE) as TextServicesManager

public fun Context.getTvInputManager(): TvInputManager = getSystemService(Context.TV_INPUT_SERVICE) as TvInputManager

public fun Context.getUiModeManager(): UiModeManager = getSystemService(Context.UI_MODE_SERVICE) as UiModeManager

public fun Context.getUsbManager(): UsbManager = getSystemService(Context.USB_SERVICE) as UsbManager

public fun Context.getUserManager(): UserManager = getSystemService(Context.USER_SERVICE) as UserManager

public fun Context.getVibrator(): Vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

public fun Context.getWallpaperManager(): WallpaperManager = getSystemService(Context.WALLPAPER_SERVICE) as WallpaperManager

public fun Context.getWifiP2pManager(): WifiP2pManager = getSystemService(Context.WIFI_P2P_SERVICE) as WifiP2pManager

public fun Context.getWifiManager(): WifiManager = getSystemService(Context.WIFI_SERVICE) as WifiManager

public fun Context.getWindowManager(): WindowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager

public fun Context.getDefaultSharedPreferences(): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)