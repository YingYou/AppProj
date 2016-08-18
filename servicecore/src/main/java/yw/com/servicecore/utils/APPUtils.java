package yw.com.servicecore.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.widget.Toast;

import java.io.File;
import java.util.UUID;

/**
 * 设备及系统相关工具类
 * Created by wutong on 2014/10/5.
 */
public class APPUtils {
    public static final int TYPE_VERSION_NAME = 0X01;
    public static final int TYPE_VERSION_CODE = 0X02;
    /**
     * 获取设备唯一id
     *
     * @param context
     * @return
     */
    public static final String getUniqueID(Context context) {
        if (context == null) {
            return null;
        }
        Context appContent = context.getApplicationContext();
        final TelephonyManager tm = (TelephonyManager) appContent.getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);

        final String tmDevice, tmSerial, androidId;
        tmDevice = "" + tm.getDeviceId();
        tmSerial = "" + tm.getSimSerialNumber();
        androidId = "" + android.provider.Settings.Secure.getString(appContent.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);

        UUID deviceUuid = new UUID(androidId.hashCode(), ((long) tmDevice.hashCode() << 32) | tmSerial.hashCode());
        String uniqueId = deviceUuid.toString();
        return uniqueId;
    }

    /**
     * 获取version_name或者version_code
     *
     * @param context
     * @param version_type TYPE_VERSION_NAME,TYPE_VERSION_CODE
     * @return
     */
    public static final String getAppVersionInfo(Context context, int version_type) {
        if (context == null) {
            return null;
        }
        String versionCode = null;
        String versionName = null;
        Context appContent = context.getApplicationContext();

        PackageManager pm = appContent.getPackageManager();
        PackageInfo pi = null;
        try {
            pi = pm.getPackageInfo(appContent.getPackageName(), 0);
            versionName = pi.versionName;
            versionCode = pi.versionCode + "";
        } catch (PackageManager.NameNotFoundException e) {
            versionName = null;
            versionCode = null;
        }
        if (version_type == TYPE_VERSION_CODE) {
            return versionCode;
        } else {
            return versionName;
        }

    }

    /**
     * 获取android 系统版本
     *
     * @return
     */
    public static final String getSystemVersion() {
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        String sysVersion = "Android" + currentapiVersion;
        return sysVersion;
    }

    /**
     * show Toast
     *
     * @param context
     * @param message
     */
    public static void showToast(Context context, String message) {
        if (TextUtils.isEmpty(message))return;
        Toast.makeText(context.getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 清理缓存
     *
     * @param context
     */
    public synchronized static void clearCache(Context context) {
        File file = context.getApplicationContext().getCacheDir();
        File[] list = file.listFiles();
        for (File f : list) {
            if (f.isFile() && f.getName().contains("tmp_image"))
                f.delete();
        }
    }

    /**
     * 检查是否有新版本
     *
     * @param localVersionName
     * @param serviceVersionName
     * @return
     */
    public static boolean hasNewVersion(String localVersionName, String serviceVersionName) {
        localVersionName = localVersionName.replace(".","_");
        serviceVersionName = serviceVersionName.replace(".","_");
        boolean hasNew = false;
        if (TextUtils.isEmpty(localVersionName) || TextUtils.isEmpty(serviceVersionName)) {
            hasNew = false;
        } else {
            String localArrays[] = localVersionName.split("_");
            String servicesArrays[] = serviceVersionName.split("_");
            if (localArrays != null && localArrays.length > 0 && servicesArrays != null && servicesArrays.length > 0) {
                int localLen = localArrays.length;
                int servicesLen = servicesArrays.length;

                for (int i = 0; i < servicesLen; i++) {
                    int li = 0;
                    if (localLen > i) {
                        li = Integer.parseInt(localArrays[i]);
                    }
                    int si = Integer.parseInt(servicesArrays[i]);
                    if (si > li) {
                        hasNew = true;
                        break;
                    }else if (si<li){
                        hasNew = false;
                        break;
                    }else {
                        continue;
                    }
                }
            } else {
                hasNew = false;
            }
        }
        return hasNew;
    }


}
