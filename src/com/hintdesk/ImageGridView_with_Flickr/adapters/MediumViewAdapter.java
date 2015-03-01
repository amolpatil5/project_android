package com.hintdesk.ImageGridView_with_Flickr.adapters;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amp.syadav.R;
import com.hintdesk.ImageGridView_with_Flickr.implementations.CurrentAppData;
import com.hintdesk.core.activities.AlertMessageBox;
import com.hintdesk.core.utils.IOUtil;

/**
 * Created by ServusKevin on 12/18/13.
 */
public class MediumViewAdapter extends PagerAdapter {

	public static CurrentAppData currentAppData;
    public Activity activity;
     public ImageView imageView;
    public TextView textView;

    public MediumViewAdapter(Activity activity,CurrentAppData currentAppData) {
        /*RoboGuice.getInjector(activity).injectMembers(this);*/
        this.activity = activity;
        this.currentAppData=currentAppData;
    }

    @Override
    public int getCount() {
        return currentAppData.getImageInfos().size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == (LinearLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {


        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewLayout = inflater.inflate(R.layout.layout_medium_view, container, false);

        imageView = (ImageView) viewLayout.findViewById(R.id.imageView);
        imageView.setImageBitmap(currentAppData.getImageInfos().get(position).getMediumBitmap());

        ImageButton buttonBack = (ImageButton) viewLayout.findViewById(R.id.imageButtonBack);
        buttonBack.setOnClickListener(ButtonBackOnClickListener);

        ImageButton buttonDownload = (ImageButton) viewLayout.findViewById(R.id.imageButtonDownload);
        buttonDownload.setOnClickListener(ButtonDownloadOnClickListener);

        textView = (TextView) viewLayout.findViewById(R.id.textViewName);
        textView.setText(currentAppData.getImageInfos().get(position).getName());


//        new LoadMediumImageTask().execute();
        ((ViewPager) container).addView(viewLayout);
        return viewLayout;
    }

    private View.OnClickListener ButtonDownloadOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Bitmap bitmap = currentAppData.getImageInfos().get(currentAppData.getCurrentPosition()).getMediumBitmap();
            String fileName = currentAppData.getImageInfos().get(currentAppData.getCurrentPosition()).getName() + ".png";
            String hdImagesPath = Environment.getExternalStorageDirectory() + "/hdimages/";
            File hdImagesPathDir = new File(hdImagesPath);
            hdImagesPathDir.mkdir();
            String filePath = IOUtil.pathCombine(hdImagesPath.toString(), fileName);
            File filePathInfo = new File(filePath);
            try {
                filePathInfo.createNewFile();
                FileOutputStream fileOutputStream = null;
                fileOutputStream = new FileOutputStream(filePathInfo);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                AlertMessageBox.Show(activity, "Info", "Successfully saved", AlertMessageBox.AlertMessageBoxIcon.Info);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    };

    private View.OnClickListener ButtonBackOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            activity.finish();
        }
    };



    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((LinearLayout) object);
    }
}
