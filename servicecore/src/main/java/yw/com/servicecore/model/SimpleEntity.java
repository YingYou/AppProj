package yw.com.servicecore.model;

import java.io.Serializable;

import yw.com.servicecore.model.BaseEntity;

/**
 * Created by 吴同 on 2016/4/20 0020.
 */
public class SimpleEntity extends BaseEntity {

    /**
     * code : A0000
     * msg : ok
     * data : {"ret":"1"}
     * time : 1469848239
     * _ut : 0.01589
     */

    /**
     * ret : 1
     */

    private DataBean data;


    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }


    public static class DataBean implements Serializable{
        private String ret;
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getRet() {
            return ret;
        }

        public void setRet(String ret) {
            this.ret = ret;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "ret='" + ret + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "SimpleEntity{" +
                "data=" + data +
                '}';
    }
}
