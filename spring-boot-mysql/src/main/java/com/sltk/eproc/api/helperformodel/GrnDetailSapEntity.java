package com.sltk.eproc.api.helperformodel;
/********************************************************************
* @Class Name         : GrnDetailSapEntity.java                                                                
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
public class GrnDetailSapEntity
{
	private String grnnumber;
	private String lineid;
	private String plant;
	private String quantity;
	private String grnmovementtype;
	
	public GrnDetailSapEntity(String grnnumber, String lineid, String plant, String quantity, String grnmovementtype)
	{
		this.grnnumber = grnnumber;
		this.lineid = lineid;
		this.plant = plant;
		this.quantity = quantity;
		this.grnmovementtype = grnmovementtype;
	}

	public String getGrnnumber()
	{
		return grnnumber;
	}

	public void setGrnnumber(String grnnumber)
	{
		this.grnnumber = grnnumber;
	}

	public String getLineid()
	{
		return lineid;
	}

	public void setLineid(String lineid)
	{
		this.lineid = lineid;
	}

	public String getPlant()
	{
		return plant;
	}

	public void setPlant(String plant)
	{
		this.plant = plant;
	}

	public String getQuantity()
	{
		return quantity;
	}

	public void setQuantity(String quantity)
	{
		this.quantity = quantity;
	}

	public String getGrnmovementtype()
	{
		return grnmovementtype;
	}

	public void setGrnmovementtype(String grnmovementtype)
	{
		this.grnmovementtype = grnmovementtype;
	}
	
	
}
