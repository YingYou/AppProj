package yw.com.servicecore.model;

import java.io.Serializable;

/**
 * Created by yangwei on 16/8/17.
 */
public class appinfo implements Serializable{

    String link;
    String redBegin;
    String banner;
    String id;
    String bId;
    String redEnd;
    String title;
    String content;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getRedBegin() {
        return redBegin;
    }

    public void setRedBegin(String redBegin) {
        this.redBegin = redBegin;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public String getRedEnd() {
        return redEnd;
    }

    public void setRedEnd(String redEnd) {
        this.redEnd = redEnd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
