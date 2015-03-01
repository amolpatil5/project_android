package com.hintdesk.ImageGridView_with_Flickr.interfaces;

import java.util.List;

import com.hintdesk.ImageGridView_with_Flickr.vo.ImageInfo;

/**
 * Created by ServusKevin on 12/18/13.
 */
public interface ICurrentAppData {
    List<ImageInfo> getImageInfos();

    void setImageInfos(List<ImageInfo> imageInfos);

    int getCurrentPosition();

    void setCurrentPosition(int currentPosition);
}
