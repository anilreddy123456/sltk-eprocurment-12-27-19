package com.sltk.app.entity.sap;

import java.util.ArrayList;
import java.util.List;

/********************************************************************
* @Class Name         : GrnSapEntity.java                                                                
*                                                                                                                                        
* @author             : Dheeraj Singh                                                                
* @version            :                                                                        
* @Creation Date      : 06-Jan-2020                                                                
* @Last Modified By   : Dheeraj Singh                                                                
* @Last Modified Date : 06-Jan-2020                                                                                
*********************************************************************
*    
*********************************************************************
*/
public class GrnSapEntity
{
    private String grnnumber;
    private String ponumber;
    private String grncreatedby;
    private String grncreateddate;
    private String grnpostingdate;
    
    private List<GrnDetailSapEntity> grndetailslist = new ArrayList<GrnDetailSapEntity>();
    
    public GrnSapEntity ()
    {}

	public GrnSapEntity(String grnnumber, String ponumber, String grncreatedby, String grncreateddate, String grnpostingdate, List<GrnDetailSapEntity> grndetailslist)
	{
		this.grnnumber = grnnumber;
		this.ponumber = ponumber;
		this.grncreatedby = grncreatedby;
		this.grncreateddate = grncreateddate;
		this.grnpostingdate = grnpostingdate;
		this.grndetailslist = grndetailslist;
	}
	
	public GrnSapEntity(String grnnumber, String ponumber, String grncreatedby, String grncreateddate, String grnpostingdate)
	{
		this.grnnumber = grnnumber;
		this.ponumber = ponumber;
		this.grncreatedby = grncreatedby;
		this.grncreateddate = grncreateddate;
		this.grnpostingdate = grnpostingdate;
	}

	public String getGrnnumber()
	{
		return grnnumber;
	}

	public void setGrnnumber(String grnnumber)
	{
		this.grnnumber = grnnumber;
	}

	public String getPonumber()
	{
		return ponumber;
	}

	public void setPonumber(String ponumber)
	{
		this.ponumber = ponumber;
	}

	public String getGrncreatedby()
	{
		return grncreatedby;
	}

	public void setGrncreatedby(String grncreatedby)
	{
		this.grncreatedby = grncreatedby;
	}

	public String getGrncreateddate()
	{
		return grncreateddate;
	}

	public void setGrncreateddate(String grncreateddate)
	{
		this.grncreateddate = grncreateddate;
	}

	public String getGrnpostingdate()
	{
		return grnpostingdate;
	}

	public void setGrnpostingdate(String grnpostingdate)
	{
		this.grnpostingdate = grnpostingdate;
	}

	public List<GrnDetailSapEntity> getGrndetailslist()
	{
		return grndetailslist;
	}

	public void setGrndetailslist(List<GrnDetailSapEntity> grndetailslist)
	{
		this.grndetailslist = grndetailslist;
	}

	@Override
	public String toString() {
		return "GrnSapEntity [grnnumber=" + grnnumber + ", ponumber=" + ponumber + ", grncreatedby=" + grncreatedby
				+ ", grncreateddate=" + grncreateddate + ", grnpostingdate=" + grnpostingdate + ", grndetailslist="
				+ grndetailslist + "]";
	}

}
