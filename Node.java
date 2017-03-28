
public class Node 
{
	Node right;
	Node down;
	Value val;
	
	//constructor to make empty node
	public Node()
	{
		val = new Value();
		right = null;
		down = null;
	}
	
	//constructor to make node with value
	public Node(String value)
	{
		if(value.startsWith("\""))
		{
			val = new Value(0, value.substring(1), Tag.STRING);
		}
		else
		{
			val = new Value(Double.parseDouble(value), null, Tag.DBL);
		}
		
		right = null;
		down = null;
		
	}
}
