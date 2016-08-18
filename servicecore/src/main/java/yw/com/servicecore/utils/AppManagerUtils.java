package yw.com.servicecore.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.ArrayList;

/**
 *
 * Created by l on 2015/7/6.
 */
public class AppManagerUtils {
    private Context mContext;

    /**
     * 获取手机中安装的所有应用信息
     * @param context
     * @return
     */
    public static ArrayList<PackageInfo> getAppList(Context context){
        ArrayList<PackageInfo> apps = new ArrayList<PackageInfo>();
        PackageManager pManager = context.getPackageManager();
        apps = (ArrayList<PackageInfo>) pManager.getInstalledPackages(0);
        return apps;
    }

    /**
     * 判断是否安装微信
     * @return
     */
    public static boolean isInstalledWXPay(Context context){
        ArrayList<PackageInfo> apps = getAppList(context);
        for (int i = 0; i < apps.size(); i++) {
            PackageInfo info = apps.get(i);
            if(info.packageName.equals("com.tencent.mm")){
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否安装支付宝
     * @return
     */
    public static boolean isInstalledAlipay(Context context){
        ArrayList<PackageInfo> apps = getAppList(context);
        for (int i = 0; i < apps.size(); i++) {
            PackageInfo info = apps.get(i);
            if(info.packageName.contains("Alipay")){
                return true;
            }
        }
        return false;
    }



}
