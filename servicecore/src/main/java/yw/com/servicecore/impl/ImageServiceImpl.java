package yw.com.servicecore.impl;

import android.util.Log;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.util.Map;

import okhttp3.Call;
import yw.com.servicecore.ImageService;
import yw.com.servicecore.common.MsgUtil;
import yw.com.servicecore.common.ServiceCallBack;
import yw.com.servicecore.common.UrlHelper;
import yw.com.servicecore.coreconstants.CoreConstants;
import yw.com.servicecore.model.SimpleEntity;
import yw.com.servicecore.model.UserResp;

/**
 * Created by yangwei on 16/8/18.
 */
public class ImageServiceImpl implements ImageService{

    public ImageServiceImpl(){



    }

    @Override
    public void uploadImagePath(Map<String, String> params, final ServiceCallBack<SimpleEntity> callBack) {

        //测试数据
        File file = new File("/mnt/sdcard/haimawan/download/advert.jpg");

        OkHttpUtils.post()//
                .addFile("file", "advert.jpg", file)//
                .url(UrlHelper.IMAGE_URL)
                .params(params)//
                .build()//
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {

                        Log.e("-----yw---------",response);
                        SimpleEntity resp = MsgUtil.str2Obj(response,SimpleEntity.class);

                        if (resp != null && CoreConstants.CODE_SUCCESS.equals(resp.getCode())) {

                            callBack.callBack(resp);

                        }

                    }
                });
    }
}
