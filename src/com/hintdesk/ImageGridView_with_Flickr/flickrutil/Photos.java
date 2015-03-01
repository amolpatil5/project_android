package com.hintdesk.ImageGridView_with_Flickr.flickrutil;


import com.hintdesk.ImageGridView_with_Flickr.flickrutil.JSONObject.PhotoSetsJSON;
import com.hintdesk.ImageGridView_with_Flickr.flickrutil.JSONObject.PhotosJSON;
import com.hintdesk.core.utils.JSONHttpClient;
import org.apache.http.NameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ServusKevin on 12/15/13.
 */
public class Photos extends FlickrBaseItem {
    public Photos(String api_key, String format) {
        super(api_key, format);
    }

    public List<Size> getSizes(String photo_id) {

        JSONHttpClient jsonHttpClient = new JSONHttpClient();
        String url = String.format(FlickrUrls.flickr_photos_getSizes, format, api_key, photo_id);
        PhotosJSON photosJson = jsonHttpClient.Get(url, new ArrayList<NameValuePair>(), PhotosJSON.class);
        return photosJson.getSizes().getSize();

    }
}
