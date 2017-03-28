
public class Value 
{
	double dval;
	String sval;
	Tag tag;
	
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

}