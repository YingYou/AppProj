package yw.com.servicecore.utils;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;

//import com.tbruyelle.rxpermissions.RxPermissions;
//
//import rx.functions.Action1;

/**
 * Created by 吴同 on 2016/5/12 0012.
 */
public class PermissionUtils {

//    @TargetApi(Build.VERSION_CODES.M)
//    public void check(final Activity activity, final PermissionListener listener) {
//        if (activity == null) {
//            throw new IllegalArgumentException("activity must not be null");
//        }
//        final String[] permissions = new String[]{
//                Manifest.permission.ACCESS_FINE_LOCATION,
//                Manifest.permission.WRITE_EXTERNAL_STORAGE,
//
//        };
//
//        RxPermissions.getInstance(activity).request(permissions).subscribe(new Action1<Boolean>() {
//            @Override
//            public void call(Boolean granted) {
//                if (listener != null) {
//                    listener.onPermissionResult(granted);
//                }
//
//                if (!granted) {
//                    activity.requestPermissions(permissions, 0);
//                }
//            }
//        });
//    }

    public interface PermissionListener {
        void onPermissionResult(boolean granted);
    }

    public boolean isSDKM() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }
}
