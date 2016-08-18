package yw.com.appproj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Request;
import yw.com.servicecore.common.ServiceCallBack;
import yw.com.servicecore.common.UrlHelper;
import yw.com.servicecore.model.SimpleEntity;
import yw.com.servicecore.model.UserResp;
import yw.com.servicecore.model.appinfo;
import yw.com.servicecore.requestparams.YWRequestParams;


public class MainActivity extends AppCompatActivity {
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView2 = (TextView)findViewById(R.id.tv);

        /**测试登录接口*/
//        HashMap<String, String> params = new HashMap<>();
//        params.put("phone", "18995637623");
//        params.put("password", "111111");
//
//        UrlHelper.getUserService().queryUserPoint(YWRequestParams.getUserRequestParams(params,MainActivity.this), new ServiceCallBack<UserResp>() {
//
//            @Override
//            public void callBack(UserResp paramT) {
//
//                textView2.setText(paramT.getData().getInfo().toString());
//
//            }
//        });

        /**测试图片上传接口*/
        final HashMap<String, String> params = new HashMap<>();
        UrlHelper.getImageService().uploadImagePath(YWRequestParams.getUserRequestParams(params, MainActivity.this), new ServiceCallBack<SimpleEntity>() {
            @Override
            public void callBack(SimpleEntity paramT) {

                textView2.setText(paramT.getData().getUrl());
            }
        });

    }



}
