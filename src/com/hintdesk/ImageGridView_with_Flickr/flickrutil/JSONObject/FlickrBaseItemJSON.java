package com.hintdesk.ImageGridView_with_Flickr.flickrutil.JSONObject;

import java.io.Serializable;

/**
 * Created by ServusKevin on 12/15/13.
 */
public class FlickrBaseItemJSON implements Serializable {
    private String stat;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
