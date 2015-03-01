package com.hintdesk.ImageGridView_with_Flickr.vo;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ServusKevin on 12/16/13.
 */
public class ImageInfo implements Parcelable{

  

	public void setName(String name) {
        this.name = name;
    }

    private String name;

    public ImageInfo(String name, Bitmap bitmap, Bitmap mediumBitmap) {
        this.name = name;
        this.thumbnailBitmap = bitmap;
        this.mediumBitmap = mediumBitmap;
    }

    private String mediumUrl;


    private Bitmap thumbnailBitmap;

    public Bitmap getThumbnailBitmap() {
        return thumbnailBitmap;
    }

    public void setThumbnailBitmap(Bitmap thumbnailBitmap) {
        this.thumbnailBitmap = thumbnailBitmap;
    }

    public String getName() {
        return name;
    }

    public Bitmap getMediumBitmap() {
        return mediumBitmap;
    }

    public void setMediumBitmap(Bitmap mediumBitmap) {
        this.mediumBitmap = mediumBitmap;
    }

    private Bitmap mediumBitmap;

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(name);
        dest.writeParcelable(mediumBitmap, flags);
        dest.writeParcelable(thumbnailBitmap, flags);
		
	}

}
