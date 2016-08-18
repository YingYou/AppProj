package yw.com.servicecore.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 获取网络状态
 * Created by 吴同 on 2016/5/16 0016.
 */
public class NetConnectionUtils {
    /***
     * 获取当前网络状态*
     *
     * @param context
     * @return ConnectivityManager.TYPE_WIFI; ConnectivityManager.TYPE_MOBILE; ...;{@link ConnectivityManager}
     */
    public static int checkNetworkConnection(Context context) {
        Context ctx = context.getApplicationContext();
        ConnectivityManager connMgr = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeInfo = connMgr.getActiveNetworkInfo();
        if (activeInfo != null && activeInfo.isConnected()) {
            return activeInfo.getType();
        } else {
            return -999;
        }
    }
}
