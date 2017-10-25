
public class Value 
{
	private double dval;
	private String sval;
	private Tag tag;
	
	public Value()
	{
		this(0, null, Tag.STRING);
	}
	
	public Value(double dval, String sval, Tag tag)
	{
		this.dval = dval;
		this.sval = sval;
		this.tag = tag;
	}
	
	public String toString()
	{
		String retStr = null;
		if(tag == Tag.STRING)
		{
			if(sval == null)
			{
				retStr = "";
			}
			else
			{
				retStr = sval;
			}
		}
		else
			retStr = dval + "";
		if(retStr.length() > 10 )
			return retStr.substring(0,10);
		else
			return retStr;
	}
	
	public void setdVal(double num)
	{
		dval = num;
		setTag(Tag.DBL);
	}
	
	public double getdVal()
	{
		return dval;
	}
	
	public void setsVal(String str)
	{
		sval = str;
		setTag(Tag.STRING);
	}
	
	public String getsVal()
	{
		return sval;
	}
	
	public void setTag(Tag tag)
	{
		this.tag = tag;
	}
	
	public Tag getTag()
	{
		return tag;
	}
	
	public void addCells(Value first, Value second)
	{
		if(first.tag == Tag.DBL && second.tag == Tag.DBL)
		{
			dval = first.dval + second.dval;
			setTag(Tag.DBL);
		}
		else
		{
			setTag(Tag.INVALID);
		}
	}
	
	public void subCells(Value first, Value second)
	{
		if(first.tag == Tag.DBL && second.tag == Tag.DBL)
		{
			dval = first.dval - second.dval;
			setTag(Tag.DBL);
		}
		else
		{
			setTag(Tag.INVALID);
		}
	}
	
	public void multCells(Value first, Value second)
	{
		if(first.tag == Tag.DBL && second.tag == Tag.DBL)
		{
			dval = first.dval * second.dval;
			setTag(Tag.DBL);
		}
		else
		{
			setTag(Tag.INVALID);
		}
	}
	
	public void divideCells(Value first, Value second)
	{
		if(first.tag == Tag.DBL && second.tag == Tag.DBL && second.dval != 0)
		{
			dval = first.dval / second.dval;
			setTag(Tag.DBL);
		}
		else
		{
			setTag(Tag.INVALID);
		}
	}

}