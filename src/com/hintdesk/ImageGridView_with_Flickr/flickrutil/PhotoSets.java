package com.hintdesk.ImageGridView_with_Flickr.flickrutil;

import com.hintdesk.ImageGridView_with_Flickr.flickrutil.JSONObject.PhotoSetsJSON;
import com.hintdesk.core.utils.JSONHttpClient;
import org.apache.http.NameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ServusKevin on 12/15/13.
 */
public class PhotoSets extends FlickrBaseItem {

    public PhotoSets(String api_key, String format) {
        super(api_key, format);

    }

    public List<Photo> getPhotos(String photoset_id) {
        JSONHttpClient jsonHttpClient = new JSONHttpClient();
        String url = String.format(FlickrUrls.flickr_photosets_getPhotos, format, api_key, photoset_id);
        PhotoSetsJSON photoSetJson = jsonHttpClient.Get(url, new ArrayList<NameValuePair>(), PhotoSetsJSON.class);
        return photoSetJson.getPhotoset().getPhoto();
    }
}
