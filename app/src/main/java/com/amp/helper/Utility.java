package com.amp.helper;

import com.amp.syadav.R;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;





public class Utility 
{
	private static Utility ut; 
	 private Context mcontext;

		public Utility(Context context) {
			mcontext = context;
		}

		public static Utility getFontManager(Context context) {
			if (ut == null) {
				ut = new Utility(context);
			}
			return ut;
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
//			  AlertDialog alert = new AlertDialog.Builder(context).create();
//	            alert.setTitle("Connection Error");
//	          //  String errorMsg = getResources().getString(R.string.NETWORK_ERROR);
//	            alert.setMessage("Unable to connect,Please check your internet connection.");
//	            alert.setCancelMessage(null);
//	            alert.show();

			
			AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setCancelable(true);
            builder.setTitle("Connection Error");
            builder.setMessage("Unable to connect, Please check your internet connection.");
            builder.setInverseBackgroundForced(true);
            builder.setPositiveButton("OK",null);
            AlertDialog alert = builder.create();
            alert.show();
			
		}
}
