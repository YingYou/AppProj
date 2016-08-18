package yw.com.servicecore.impl;

import android.util.Log;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.Map;

import okhttp3.Call;
import yw.com.servicecore.UserService;
import yw.com.servicecore.common.MsgUtil;
import yw.com.servicecore.common.ServiceCallBack;
import yw.com.servicecore.common.UrlHelper;
import yw.com.servicecore.coreconstants.CoreConstants;
import yw.com.servicecore.model.UserResp;

/**
 * Created by yangwei on 16/8/17.
 */
public class UserServiceImpl implements UserService{

    public UserServiceImpl(){



    }

    @Override
    public void queryUserPoint(Map<String, String> params, final ServiceCallBack<UserResp> callBack) {

        Log.e("-----yw---------","queryUserPoint");
        OkHttpUtils
                .post()
                .url(UrlHelper.LOGIN_URL)
                .params(params)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("-----yw---------",response);
                        UserResp resp = MsgUtil.str2Obj(response,UserResp.class);

                        if (resp != null && CoreConstants.CODE_SUCCESS.equals(resp.getCode())) {

                            callBack.callBack(resp);

                        }

                    }
                });

    }
}
