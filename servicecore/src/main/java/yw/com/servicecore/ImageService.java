package yw.com.servicecore;

import java.util.Map;

import yw.com.servicecore.common.ServiceCallBack;
import yw.com.servicecore.model.SimpleEntity;
import yw.com.servicecore.model.UserResp;

/**
 * Created by yangwei on 16/8/18.
 */
public interface ImageService {


    public abstract void uploadImagePath(Map<String, String> params, ServiceCallBack<SimpleEntity> callBack );
}
