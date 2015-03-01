package com.hintdesk.ImageGridView_with_Flickr.flickrutil.JSONObject;

import com.hintdesk.ImageGridView_with_Flickr.flickrutil.FlickrBaseItem;
import com.hintdesk.ImageGridView_with_Flickr.flickrutil.PhotoSet;

/**
 * Created by ServusKevin on 12/15/13.
 */
public class PhotoSetsJSON extends FlickrBaseItemJSON {
    public PhotoSet getPhotoset() {
        return photoset;
    }

    public void setPhotoset(PhotoSet photoset) {
        this.photoset = photoset;
    }

    private PhotoSet photoset;


}
