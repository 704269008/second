package com.jns.entity;

import java.io.Serializable;

public class Photo implements Serializable{
    private int id;
    private String photoName;
    private int photoType;
    private long shelfTime;
    private long downTime;
    private String guestbook;
    private String img;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public int getPhotoType() {
        return photoType;
    }

    public void setPhotoType(int photoType) {
        this.photoType = photoType;
    }

    public long getShelfTime() {
        return shelfTime;
    }

    public void setShelfTime(long shelfTime) {
        this.shelfTime = shelfTime;
    }

    public long getDownTime() {
        return downTime;
    }

    public void setDownTime(long downTime) {
        this.downTime = downTime;
    }

    public String getGuestbook() {
        return guestbook;
    }

    public void setGuestbook(String guestbook) {
        this.guestbook = guestbook;
    }

    @Override
    public String toString() {
        return "photoName:"+photoName+",message:"+guestbook+",downTime:"+downTime+"";
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
