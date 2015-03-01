package com.hintdesk.ImageGridView_with_Flickr.flickrutil;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ServusKevin on 12/15/13.
 */
public class PhotoSet implements Serializable {
    private String id;
    private String owner;
    private String ownername;
    private String page;
    private String pages;
    private String per_page;
    private String perpage;

    public List<Photo> getPhoto() {
        return photo;
    }

    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
    }

    private List<Photo> photo;
    private String primary;
    private String title;
    private String total;
}
