package com.hintdesk.ImageGridView_with_Flickr.implementations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import com.hintdesk.ImageGridView_with_Flickr.vo.ImageInfo;

/**
 * Created by ServusKevin on 12/18/13.
 */
public class CurrentAppData implements Parcelable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public List<ImageInfo> imageInfos;
	public int currentPosition;
	public List<Bitmap> mediumBitmaps;

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }


    public Bitmap getMediumImage(int position) {
        return mediumBitmaps.get(position);
    }


    public void setMediumImage(int position, Bitmap bitmap) {
        mediumBitmaps.set(position, bitmap);
    }

    public List<ImageInfo> getImageInfos() {
        return imageInfos;
    }


    public void setImageInfos(List<ImageInfo> imageInfos) {
        this.imageInfos = imageInfos;
        mediumBitmaps = new ArrayList<Bitmap>(Collections.nCopies(imageInfos.size(), (Bitmap) null));
    }

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(currentPosition);
        dest.writeList(imageInfos);
        dest.writeList(mediumBitmaps);
		
	}
	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
	    public CurrentAppData createFromParcel(Parcel in) {
	        return new CurrentAppData();
	    }

		@Override
		public Object[] newArray(int size) {
			// TODO Auto-generated method stub
			return null;
		}

	};

}
