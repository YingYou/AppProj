package yw.com.servicecore.requestparams;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import yw.com.servicecore.coreconstants.CoreConstants;
import yw.com.servicecore.utils.APPUtils;
import yw.com.servicecore.utils.MD5Util;
import yw.com.servicecore.utils.SharePreferencesUtil;
import yw.com.servicecore.utils.UUIDUtil;

/**
 * Created by yangwei on 16/8/18.
 */
public class YWRequestParams {

    //    'AND-USER' => 'Yg4I6pAKvJzM0MsMwQ0uKO8z9iS3piQs',
//    'AND-WORK' => 'Hx00oPFx0RsNEgYpEIXQFQe2UZbkQeog',

    /**
     * 用户端
     */
    public static final String CLIENT_KEY_APP_USER = "AND-USER";
    /**
     * 工作端
     */
    public static final String CLIENT_KEY_APP_WORK = "AND-WORK";

    /**
     * 用户版请求参数
     *
     * @param map
     * @param context
     * @return
     */
    public static HashMap<String, String> getUserRequestParams(HashMap<String, String> map, Context context) {
        if (map == null) {
            map = new HashMap<>();
        }

        return getRequestParams(CLIENT_KEY_APP_USER, map, context.getApplicationContext());
    }

    /**
     * 工作版请求参数
     *
     * @param map
     * @param context
     * @return
     */
    public static HashMap<String, String> getWorkRequestParams(HashMap<String, String> map, Context context) {
        return getRequestParams(CLIENT_KEY_APP_WORK, map, context.getApplicationContext());
    }


    private static HashMap<String, String> getRequestParams(String _aKey, HashMap<String, String> map, Context context) {
        String _token = SharePreferencesUtil.getString(
                context, "token", CoreConstants.USER_TOKEN, "");

        map.put("_token", _token);
        map.put("_aKey", _aKey);
        map.put("_udid", MD5Util.MD5Encode(UUIDUtil.getUniqueID(context), "UTF-8"));
        map.put("_vApp", APPUtils.getAppVersionInfo(context, APPUtils.TYPE_VERSION_NAME));
        map.put("_vOs", APPUtils.getSystemVersion());
        map.put("_t", System.currentTimeMillis() + "");
        map.put("_sign", getSign(_aKey, map));

        return map;
    }

    private static String getSign(String _aKey, HashMap<String, String> map) {
        if (map == null) return null;
        StringBuilder stringBuilder = new StringBuilder();

        List<Map.Entry<String, String>> mappingList = new ArrayList<>(map.entrySet());

        Collections.sort(mappingList, new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> mapping1, Map.Entry<String, String> mapping2) {
                return mapping1.getKey().compareTo(mapping2.getKey());
            }
        });

        for (Map.Entry<String, String> mapping : mappingList) {
            stringBuilder.append(mapping.getKey()).append(mapping.getValue());
        }

        String secret = CLIENT_KEY_APP_USER.equals(_aKey) ? "Yg4I6pAKvJzM0MsMwQ0uKO8z9iS3piQs" : "Hx00oPFx0RsNEgYpEIXQFQe2UZbkQeog";
        String _sign = MD5Util.MD5Encode((stringBuilder.toString() + secret), "UTF-8").substring(2, 22);
        return _sign;

    }

    /**
     * 文件上传的map
     * @param reqMap
     * @param context
     * @return
     */
//    public static HashMap<String, RequestBody> getMultiRequestBody(HashMap<String, Object> reqMap, Context context) {
//
//        HashMap<String, Object> map = getUserRequestParams(reqMap, context);
//        Iterator iter = map.entrySet().iterator();
//        HashMap<String, RequestBody> bodyMap = new HashMap<>();
//        while (iter.hasNext()) {
//            Map.Entry entry = (Map.Entry) iter.next();
//            RequestBody requestBody = RequestBody.create(MultipartBody.FORM, String.valueOf(entry.getValue()));
//            bodyMap.put(String.valueOf(entry.getKey()), requestBody);
//
//        }
//        return bodyMap;
//
//    }
}
