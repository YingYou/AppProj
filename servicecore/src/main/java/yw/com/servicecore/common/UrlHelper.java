package yw.com.servicecore.common;

import yw.com.servicecore.ImageService;
import yw.com.servicecore.UserService;
import yw.com.servicecore.impl.ImageServiceImpl;
import yw.com.servicecore.impl.UserServiceImpl;

/**
 * Created by yangwei on 16/8/17.
 */
public class UrlHelper {

    public static final  String BASE_API = "http://121.43.113.120:8001/";

    private static volatile UrlHelper instance = null;

    public static final  String LOGIN_URL = BASE_API + "v1/user/login.json";

    public static  final String IMAGE_URL = BASE_API + "v1/basic/upload.json";

    private  static UserService userService = null;
    private  static ImageService imageService = null;

    private UrlHelper() {
    }

    public static UrlHelper getInstance() {
        if (null == instance) {
            synchronized (UrlHelper.class) {
                if (null == instance) {
                    instance = new UrlHelper();
                }
            }
        }
        return instance;
    }

    public static synchronized  UserService getUserService(){

        if (userService == null){

            userService =  new UserServiceImpl();
        }

        return userService;
    }

    public  static synchronized ImageService getImageService(){

        if (imageService == null){

            imageService = new ImageServiceImpl();
        }

        return imageService;

    }
}
