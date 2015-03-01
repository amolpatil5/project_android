package com.hintdesk.ImageGridView_with_Flickr.flickrutil.JSONObject;

import com.hintdesk.ImageGridView_with_Flickr.flickrutil.Sizes;

/**
 * Created by ServusKevin on 12/15/13.
 */
public class PhotosJSON extends FlickrBaseItemJSON {
    public Sizes getSizes() {
        return sizes;
    }

    public void setSizes(Sizes sizes) {
        this.sizes = sizes;
    }

    private Sizes sizes;
}
