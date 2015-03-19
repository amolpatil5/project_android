package com.amp.helper;

public class DepartmentsData 
{
	public String departmentName;
	public String deptURL;
	
    public DepartmentsData()
    {
        super();
    }
   
    public DepartmentsData(String deptName, String dURL) 
    {
        super();
        this.departmentName = deptName;
        this.deptURL =dURL;
      
    }

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDeptURL() {
		return deptURL;
	}

	public void setDeptURL(String deptURL) {
		this.deptURL = deptURL;
	}
}
