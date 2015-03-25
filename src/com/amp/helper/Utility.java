package com.amp.helper;

import java.util.Locale;
import com.twostars.syadav.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;

public class Utility 
{
	private static Utility ut; 
	private Context mcontext;
	static SharedPreferences pref;
	static Editor editor; 
	private static final String PREF_NAME = "YADAVPREF";
	public static final String KEY_NAME = "LANGUAGENAME";

	public Utility(Context context) {
		mcontext = context;
		pref = context.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);
		editor = pref.edit();
	}
	public static void storeCurrentLanuage(String name)
	{
		editor.putString(KEY_NAME, name);
		editor.commit();
	}

	// Get Login State
	public static String getCurrentLanguage()
	{
		return pref.getString(KEY_NAME, "");
	}

	public static Utility getFontManager(Context context) {
		if (ut == null)
		{
			ut = new Utility(context);
		}
		return ut;
	}
	public static String getAppVersion (Context context) throws NameNotFoundException
	{
		PackageManager manager = context.getPackageManager();
		PackageInfo info = manager.getPackageInfo(
				context.getPackageName(), 0);
		String version = info.versionName;
		return version;
	}
	public static boolean isNetworkStatusAvialable (Context context) 
	{
		ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connectivityManager != null) 
		{
			NetworkInfo netInfos = connectivityManager.getActiveNetworkInfo();
			if(netInfos != null)
				if(netInfos.isConnected()) 
					return true;
		}
		return false;
	}

	public static void showNetworkConnectionError(final Context context)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setCancelable(true);
		builder.setTitle("Connection Error");
		builder.setMessage("Unable to connect, Please check your internet connection.");
		builder.setInverseBackgroundForced(true);
		builder.setPositiveButton("OK",null);
		AlertDialog alert = builder.create();
		alert.show();
	}
	public static void updateLocaleWithLanguage(final Context context, String language_code)
	{
		Resources res = context.getResources();
		DisplayMetrics dm = res.getDisplayMetrics();
		android.content.res.Configuration conf = res.getConfiguration();
		conf.locale = new Locale(language_code.toLowerCase());
		res.updateConfiguration(conf, dm);
	}
}
