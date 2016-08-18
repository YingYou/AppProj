package yw.com.servicecore.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yangwei on 16/8/17.
 */
public class UserResp extends BaseEntity{

    private DataBean data;


    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

            public static class DataBean {
                private String token;
                /**
                 * userId : 10014
                 * phone : 18721889506
                 * nickName :
                 * userIcon : http://img0.bdstatic.com/img/image/shouye/xiaoxiao/4770571092781631.jpg
                 * sex : 0
                 * lastTime : 1468425990
                 * addTime : 1468425990
                 * updateTime : 1468425990
                 */

                private InfoBean info;

                public String getToken() {
                    return token;
                }

                public void setToken(String token) {
                    this.token = token;
                }

                public InfoBean getInfo() {
                    return info;
                }

                public void setInfo(InfoBean info) {
                    this.info = info;
                }

                public static class InfoBean implements Serializable {
                    private String userId;
                    private String phone;
                    private String nickName;
                    private String userIcon;
                    private String sex;
                    private String lastTime;
                    private String addTime;
                    private String updateTime;



                    @Override
                    public String toString() {
                        return "InfoBean{" +
                                "userId='" + userId + '\'' +
                                ", phone='" + phone + '\'' +
                                ", nickName='" + nickName + '\'' +
                                ", userIcon='" + userIcon + '\'' +
                                ", sex='" + sex + '\'' +
                                ", lastTime='" + lastTime + '\'' +
                                ", addTime='" + addTime + '\'' +
                                ", updateTime='" + updateTime + '\'' +
                                '}';
                    }

                    public String getUserId() {
                        return userId;
                    }

                    public void setUserId(String userId) {
                        this.userId = userId;
                    }

                    public String getPhone() {
                        return phone;
                    }

                    public void setPhone(String phone) {
                        this.phone = phone;
                    }

                    public String getNickName() {
                        return nickName;
                    }

                    public void setNickName(String nickName) {
                        this.nickName = nickName;
                    }

                    public String getUserIcon() {
                        return userIcon;
                    }

                    public void setUserIcon(String userIcon) {
                        this.userIcon = userIcon;
                    }

                    public String getSex() {
                        return sex;
                    }

                    public void setSex(String sex) {
                        this.sex = sex;
                    }

                    public String getLastTime() {
                        return lastTime;
                    }

                    public void setLastTime(String lastTime) {
                        this.lastTime = lastTime;
                    }

                    public String getAddTime() {
                        return addTime;
                    }

                    public void setAddTime(String addTime) {
                        this.addTime = addTime;
                    }

                    public String getUpdateTime() {
                        return updateTime;
                    }

                    public void setUpdateTime(String updateTime) {
                        this.updateTime = updateTime;
                    }
                }
            }


}

