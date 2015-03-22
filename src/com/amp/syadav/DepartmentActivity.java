package com.amp.syadav;



import java.util.ArrayList;
import java.util.Arrays;

import com.amp.helper.DepartmentCellAdapter;
import com.amp.helper.DepartmentsData;
import com.amp.helper.EventCellAdaptor;
import com.twostars.syadav.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class DepartmentActivity extends Activity 
{
	ArrayList<DepartmentsData> departmentList;
	 ListView deptListViewView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_department);
		headerSettings();
		departmentList = new ArrayList<DepartmentsData>();
		
		DepartmentsData dep1 = new DepartmentsData("Public Works Department","http://uppwd.up.nic.in/","#4a90e2");  
		DepartmentsData dep2 = new DepartmentsData("Irrigation","http://irrigation.up.nic.in/","#4a90e2");
		DepartmentsData dep3 = new DepartmentsData("Co-operative","http://cooperative.up.nic.in/","#4a90e2");
		DepartmentsData dep4 = new DepartmentsData("Land Development & Water Resources","http://upldwr.up.nic.in/","#4a90e2");
		DepartmentsData dep5 = new DepartmentsData("Flood Control","http://irrigation.up.nic.in/","#4a90e2");
		DepartmentsData dep6 = new DepartmentsData("Irrigation (Mechanical)","http://irrigation.up.nic.in/","#4a90e2");
		DepartmentsData dep7 = new DepartmentsData("Revenue","http://revenue.up.nic.in/","#4a90e2");
		DepartmentsData dep8 = new DepartmentsData("Uttar Pradesh Cooperative Federation Limited","http://uppcf.org/","#4a90e2");
		DepartmentsData dep9 = new DepartmentsData("Sodic &Ravine Land development","http://upldwr.up.nic.in/","#4a90e2");
		DepartmentsData dep10 = new DepartmentsData("Waste Land Development","","#ffffff");
		DepartmentsData dep11= new DepartmentsData("Disaster & Rehabilitation","","#ffffff");
		DepartmentsData dep12 = new DepartmentsData("Public Service Management","","#ffffff");

		departmentList.add(dep1);
		departmentList.add(dep2);
		departmentList.add(dep3);
		departmentList.add(dep4);
		departmentList.add(dep5);
		departmentList.add(dep6);
		departmentList.add(dep7);
		departmentList.add(dep8);
		departmentList.add(dep9);
		departmentList.add(dep10);
		departmentList.add(dep11);
		departmentList.add(dep12);
		
		 deptListViewView = (ListView) findViewById(R.id.departmentListView);
		DepartmentCellAdapter adapter  = new DepartmentCellAdapter(this, departmentList);
		
		deptListViewView.setAdapter(adapter);

		deptListViewView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> myAdapter, View myView,
					int myIntent, long myLng) 
			{
				DepartmentsData deptData = departmentList.get(myIntent);
				if(deptData.deptURL.length()>1)
				{
				Intent webViewIntent3 = new Intent(getApplicationContext(),
						WebViewActivity.class);
				webViewIntent3.putExtra("SOCIAL_URL", deptData.deptURL);
			    webViewIntent3.putExtra("TITLE", deptData.departmentName);
				startActivity(webViewIntent3);
				}
			}
			}
		);
	}
	private void headerSettings() {
		findViewById(R.id.btnBackHeader).setVisibility(View.VISIBLE);
		findViewById(R.id.btnHomeHeader).setVisibility(View.GONE);	
		TextView headerTitle =(TextView)findViewById(R.id.txtHeading);
		headerTitle.setText(R.string.title_activity_department);
	}
	public void gotoBack(View v){
		finish();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.department, menu);
		return true;
	}
	static class DepartmentData
	{
		String deptName;
		String deptURL;	
		}
}
