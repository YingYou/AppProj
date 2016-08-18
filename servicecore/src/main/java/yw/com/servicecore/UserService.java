package yw.com.servicecore;

import java.util.Map;

import yw.com.servicecore.common.ServiceCallBack;
import yw.com.servicecore.model.UserResp;

/**
 * Created by yangwei on 16/8/17.
 */
public abstract interface UserService {

    public abstract void queryUserPoint(Map<String, String> params, ServiceCallBack<UserResp> callBack );
}
