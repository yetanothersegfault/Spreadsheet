import java.util.Scanner;

public class Grid 
{
	Node head;
	int printWidth = 10;
	int numRows = 10;
	int numCols = 6;
	
	Scanner keyboard = new Scanner(System.in);
	
	public Grid()
	{
		head = new Node();
		head.right = head;
		head.down = head;
		Node p = head;
		for(int i = 0; i < (numRows - 1); i++)
		{
			addRow(p);
			p = p.down;
		}
		
		p = head;
		
		for(int i = 0; i < numCols; i++)
		{
			addColumn(p);
			p = p.right;
		}
	}
	
	public void addRow(Node p)
	{
		Node node = new Node();
		node.right = node;
		node.down = p.down;
		p.down = node;
		Node q = p;
		while(q.right != p)
		{
			q = q.right;
			Node newNode = new Node();
			newNode.right = node.right;
			node.right = newNode;
			node = newNode;
			newNode.down = q.down;
			q.down = newNode;
		}
	}
	
	public void addRow(int num)
	{
		if(num <= numRows)
		{
			Node p = head;
			int i = 1;
			while(i < num)
			{
				p = p.down;
				i++;
			}
			if(num == 0)
			{
				for(i = 0;i < (numRows - 1); i++)
					p = p.down;
			}
			addRow(p);
			if(num == 0)
				head = p.down;
		}
		numRows++;
	}
	
	public void addColumn(Node p)
	{
		Node node = new Node();
		node.down = node;
		node.right = p.right;
		p.right = node;
		Node q = p;
		while(q.down != p)
		{
			q = q.down;
			Node newNode = new Node();
			newNode.down = node.down;
			node.down = newNode;
			node = newNode;
			newNode.right = q.right;
			q.right = newNode;
		}
	}
	
	public void addColumn(int num)
	{
		if(num <= numCols)
		{
			Node p = head;
			int i = 0;
			while(i < num)
			{
				p = p.right;
				i++;
			}
			if(num == 0)
			{
				for(i = 0;i < numCols; i++)
					p = p.right;
			}
			addColumn(p);
			if(num == 0)
				head = p.right;
		}
		numCols++;
	}
	
	public void printGrid()
	{
		System.out.printf("          ");
		for(int i = 0; i < numCols; i++)
			System.out.printf("%10s", "Column " + i);
		System.out.printf("\n");
		
		Node p = head;
		Node q = head;
		for(int i = 0; i < numRows; i++)
		{
			System.out.printf("%-10s", "Row " + i);
			while(q.right != p)
			{
				System.out.printf("%10s",q.val.toString());
				q = q.right;
			}
			System.out.printf("\n");
			p = p.down;
			q = p;
		}
	}
	
	public void fillNumbers(int fromRow, int fromCol, int toRow, int toCol)
	{
		if(toRow >= fromRow && toCol >= fromCol && toRow < numRows && toCol < numCols && fromRow >= 0 && fromCol >= 0)
		{
			Node p, q;
			p = head;
			int i = 0, j = 0, counter = 1;
			while(i < fromRow)
			{
				p = p.down;
				i++;
			}
			while(j < fromCol)
			{
				p = p.right;
				j++;
			}
			q = p;
			while(i <= toRow)
			{
				while(j <= toCol)
				{
					q.setDouble(counter++);
					q = q.right;
					j++;
				}
				j = fromCol;
				p = p.down;
				q = p;
				i++;
			}
		}
		else
			System.out.println("Invalid range!");
	}
	
	public void deleteRow(int rowToDelete)
	{
		Node p = head;
		boolean isFirst = false;
		if(rowToDelete == 0)
		{
			isFirst = true;
			rowToDelete += numRows - 1;
		}
		for(int i = 0; i < rowToDelete; i++)
		{
			p = p.down;
		}
		for(int i = 0; i < numCols; i++)
		{
			p.down = p.down.down;
			p = p.right;
		}
		if(isFirst)
		{
			p = p.right;
			head = p.down;
		}
		numRows--;
	}
	
	public void deleteColumn(int colToDelete)
	{
		Node p = head;
		boolean isFirst = false;
		if(colToDelete == 0)
		{
			isFirst = true;
			colToDelete += numCols - 1;
		}
		for(int i = 0; i < colToDelete; i++)
		{
			p = p.right;
		}
		for(int i = 0; i < numRows; i++)
		{
			p.right = p.right.right;
			p = p.down;
		}
		if(isFirst)
		{
			p = p.right;
			head = p.right;
		}
		numCols--;
	}
	
	public void fillCell(int row, int col)
	{
		if(row >= 0 && row < numRows && col >= 0 && col < numCols)
		{
			Node p = head;
			for(int i = 0; i < row; i++)
				p = p.down;
			for(int i = 0; i < col; i++)
				p = p.right;
			System.out.print("With Value: ");
			String input = keyboard.nextLine();
			if(input.startsWith("\""))
				p.val.setsVal(input.substring(1));
			else
			{
				try 
				{
					p.val.setdVal(Double.parseDouble(input));
				} catch(NumberFormatException e) 
				{
					System.out.println("Invalid String input");
				}
			}
		}
	}

	public void fillArea(int fromRow, int fromCol, int toRow, int toCol)
	{
		if(toRow >= fromRow && toCol >= fromCol && toRow < numRows && toCol < numCols && fromRow >= 0 && fromCol >= 0)
		{
			System.out.print("With Value: ");
			String input = keyboard.nextLine();
			
			Node p = head;
			Node q;
			for(int i = 0; i < fromRow; i++)
				p = p.down;
			for(int i = 0; i < fromCol; i++)
				p = p.right;
			q = p;
			int rowCounter = fromRow;
			int colCounter = fromCol;
			while(colCounter <= toCol)
			{
				while(rowCounter <= toRow)
				{
					setNodeValue(p, input);
					p = p.down;
					rowCounter++;
				}
				p = q.right;
				q = p;
				colCounter++;
				rowCounter = fromRow;
			}
			
		}
	}
	
	private void setNodeValue(Node p, String input)
	{
		if(input.startsWith("\""))
				p.val.setsVal(input.substring(1));
			else
			{
				try 
				{
					p.val.setdVal(Double.parseDouble(input));
				} catch(NumberFormatException e) 
				{
					System.out.println("Invalid String input");
				}
			}
	}
	
	public void addNodes(Node first, Node second, Node dest)
	{
		Value addVal = new Value();
		addVal.addCells(first.val, second.val);
		if(!(addVal.getTag() == Tag.INVALID))
		{
			dest.val = addVal;
		}
	}
	
	public void addCells(int firstRow, int firstCol, int secondRow, int secondCol, int destRow, int destCol)
	{
		Node first = head, second = head, dest = head;
		boolean firstBool = false, secondBool = false, destBool = false;
		
		if(firstRow < numRows && firstRow >= 0 && firstCol < numCols && firstCol >= 0)
		{
			for(int i = 0; i < firstRow; i++)
				first = first.down;
			for(int j = 0; j < firstCol; j++)
				first = first.right;
			firstBool = true;
		}
		if(secondRow < numRows && secondRow >= 0 && secondCol < numCols && secondCol >= 0)
		{
			for(int i = 0; i < secondRow; i++)
				second = second.down;
			for(int j = 0; j < secondCol; j++)
				second = second.right;
			secondBool = true;
		}
		if(destRow < numRows && destRow >= 0 && destCol < numCols && destCol >= 0)
		{
			for(int i = 0; i < destRow; i++)
				dest = dest.down;
			for(int j = 0; j < destCol; j++)
				dest = dest.right;
			destBool = true;
		}
		
		if(firstBool && secondBool && destBool)
		{
			addNodes(first, second, dest);
		}
	}
	
	public void addRows(int firstRow, int secondRow, int destRow)
	{
		Node first = head, second = head, dest = head;
		boolean firstBool = false, secondBool = false, destBool = false;
		
		if(firstRow < numRows && firstRow >= 0)
		{
			for(int i = 0; i < firstRow; i++)
				first = first.down;
			firstBool = true;
		}
		if(secondRow < numRows && secondRow >= 0)
		{
			for(int i = 0; i < secondRow; i++)
				second = second.down;
			secondBool = true;
		}
		if(destRow < numRows && destRow >= 0)
		{
			for(int i = 0; i < destRow; i++)
				dest = dest.down;
			destBool = true;
		}
		
		if(firstBool && secondBool && destBool)
		{
			for(int i = 0; i < numCols; i++)
			{
				addNodes(first, second, dest);
				first = first.right;
				second = second.right;
				dest = dest.right;
			}
		}
	}
	
	public void addCols(int firstCol, int secondCol, int destCol)
	{
		Node first = head, second = head, dest = head;
		boolean firstBool = false, secondBool = false, destBool = false;
		
		if(firstCol < numCols && firstCol >= 0)
		{
			for(int j = 0; j < firstCol; j++)
				first = first.right;
			firstBool = true;
		}
		if(secondCol < numCols && secondCol >= 0)
		{
			for(int j = 0; j < secondCol; j++)
				second = second.right;
			secondBool = true;
		}
		if(destCol < numCols && destCol >= 0)
		{
			for(int j = 0; j < destCol; j++)
				dest = dest.right;
			destBool = true;
		}
		
		if(firstBool && secondBool && destBool)
		{
			for(int i = 0; i < numRows; i++)
			{
				addNodes(first, second, dest);
				first = first.down;
				second = second.down;
				dest = dest.down;
			}
		}
	}
	
	public void subNodes(Node first, Node second, Node dest)
	{
		Value subVal = new Value();
		subVal.subCells(first.val, second.val);
		if(!(subVal.getTag() == Tag.INVALID))
		{
			dest.val = subVal;
		}
	}
	
	public void subCells(int firstRow, int firstCol, int secondRow, int secondCol, int destRow, int destCol)
	{
		Node first = head, second = head, dest = head;
		boolean firstBool = false, secondBool = false, destBool = false;
		
		if(firstRow < numRows && firstRow >= 0 && firstCol < numCols && firstCol >= 0)
		{
			for(int i = 0; i < firstRow; i++)
				first = first.down;
			for(int j = 0; j < firstCol; j++)
				first = first.right;
			firstBool = true;
		}
		if(secondRow < numRows && secondRow >= 0 && secondCol < numCols && secondCol >= 0)
		{
			for(int i = 0; i < secondRow; i++)
				second = second.down;
			for(int j = 0; j < secondCol; j++)
				second = second.right;
			secondBool = true;
		}
		if(destRow < numRows && destRow >= 0 && destCol < numCols && destCol >= 0)
		{
			for(int i = 0; i < destRow; i++)
				dest = dest.down;
			for(int j = 0; j < destCol; j++)
				dest = dest.right;
			destBool = true;
		}
		
		if(firstBool && secondBool && destBool)
		{
			subNodes(first, second, dest);
		}
	}
	
	public void subRows(int firstRow, int secondRow, int destRow)
	{
		Node first = head, second = head, dest = head;
		boolean firstBool = false, secondBool = false, destBool = false;
		
		if(firstRow < numRows && firstRow >= 0)
		{
			for(int i = 0; i < firstRow; i++)
				first = first.down;
			firstBool = true;
		}
		if(secondRow < numRows && secondRow >= 0)
		{
			for(int i = 0; i < secondRow; i++)
				second = second.down;
			secondBool = true;
		}
		if(destRow < numRows && destRow >= 0)
		{
			for(int i = 0; i < destRow; i++)
				dest = dest.down;
			destBool = true;
		}
		
		if(firstBool && secondBool && destBool)
		{
			for(int i = 0; i < numCols; i++)
			{
				subNodes(first, second, dest);
				first = first.right;
				second = second.right;
				dest = dest.right;
			}
		}
	}
	
	public void subCols(int firstCol, int secondCol, int destCol)
	{
		Node first = head, second = head, dest = head;
		boolean firstBool = false, secondBool = false, destBool = false;
		
		if(firstCol < numCols && firstCol >= 0)
		{
			for(int j = 0; j < firstCol; j++)
				first = first.right;
			firstBool = true;
		}
		if(secondCol < numCols && secondCol >= 0)
		{
			for(int j = 0; j < secondCol; j++)
				second = second.right;
			secondBool = true;
		}
		if(destCol < numCols && destCol >= 0)
		{
			for(int j = 0; j < destCol; j++)
				dest = dest.right;
			destBool = true;
		}
		
		if(firstBool && secondBool && destBool)
		{
			for(int i = 0; i < numRows; i++)
			{
				subNodes(first, second, dest);
				first = first.down;
				second = second.down;
				dest = dest.down;
			}
		}
	}
	
	public void multNodes(Node first, Node second, Node dest)
	{
		Value multVal = new Value();
		multVal.multCells(first.val, second.val);
		if(!(multVal.getTag() == Tag.INVALID))
		{
			dest.val = multVal;
		}
	}
	
	public void multCells(int firstRow, int firstCol, int secondRow, int secondCol, int destRow, int destCol)
	{
		Node first = head, second = head, dest = head;
		boolean firstBool = false, secondBool = false, destBool = false;
		
		if(firstRow < numRows && firstRow >= 0 && firstCol < numCols && firstCol >= 0)
		{
			for(int i = 0; i < firstRow; i++)
				first = first.down;
			for(int j = 0; j < firstCol; j++)
				first = first.right;
			firstBool = true;
		}
		if(secondRow < numRows && secondRow >= 0 && secondCol < numCols && secondCol >= 0)
		{
			for(int i = 0; i < secondRow; i++)
				second = second.down;
			for(int j = 0; j < secondCol; j++)
				second = second.right;
			secondBool = true;
		}
		if(destRow < numRows && destRow >= 0 && destCol < numCols && destCol >= 0)
		{
			for(int i = 0; i < destRow; i++)
				dest = dest.down;
			for(int j = 0; j < destCol; j++)
				dest = dest.right;
			destBool = true;
		}
		
		if(firstBool && secondBool && destBool)
		{
			multNodes(first, second, dest);
		}
	}
	
	public void multRows(int firstRow, int secondRow, int destRow)
	{
		Node first = head, second = head, dest = head;
		boolean firstBool = false, secondBool = false, destBool = false;
		
		if(firstRow < numRows && firstRow >= 0)
		{
			for(int i = 0; i < firstRow; i++)
				first = first.down;
			firstBool = true;
		}
		if(secondRow < numRows && secondRow >= 0)
		{
			for(int i = 0; i < secondRow; i++)
				second = second.down;
			secondBool = true;
		}
		if(destRow < numRows && destRow >= 0)
		{
			for(int i = 0; i < destRow; i++)
				dest = dest.down;
			destBool = true;
		}
		
		if(firstBool && secondBool && destBool)
		{
			for(int i = 0; i < numCols; i++)
			{
				multNodes(first, second, dest);
				first = first.right;
				second = second.right;
				dest = dest.right;
			}
		}
	}
	
	public void multCols(int firstCol, int secondCol, int destCol)
	{
		Node first = head, second = head, dest = head;
		boolean firstBool = false, secondBool = false, destBool = false;
		
		if(firstCol < numCols && firstCol >= 0)
		{
			for(int j = 0; j < firstCol; j++)
				first = first.right;
			firstBool = true;
		}
		if(secondCol < numCols && secondCol >= 0)
		{
			for(int j = 0; j < secondCol; j++)
				second = second.right;
			secondBool = true;
		}
		if(destCol < numCols && destCol >= 0)
		{
			for(int j = 0; j < destCol; j++)
				dest = dest.right;
			destBool = true;
		}
		
		if(firstBool && secondBool && destBool)
		{
			for(int i = 0; i < numRows; i++)
			{
				multNodes(first, second, dest);
				first = first.down;
				second = second.down;
				dest = dest.down;
			}
		}
	}
	
	public void divideNodes(Node first, Node second, Node dest)
	{
		Value divideVal = new Value();
		divideVal.divideCells(first.val, second.val);
		if(!(divideVal.getTag() == Tag.INVALID))
		{
			dest.val = divideVal;
		}
	}
	
	public void divideCells(int firstRow, int firstCol, int secondRow, int secondCol, int destRow, int destCol)
	{
		Node first = head, second = head, dest = head;
		boolean firstBool = false, secondBool = false, destBool = false;
		
		if(firstRow < numRows && firstRow >= 0 && firstCol < numCols && firstCol >= 0)
		{
			for(int i = 0; i < firstRow; i++)
				first = first.down;
			for(int j = 0; j < firstCol; j++)
				first = first.right;
			firstBool = true;
		}
		if(secondRow < numRows && secondRow >= 0 && secondCol < numCols && secondCol >= 0)
		{
			for(int i = 0; i < secondRow; i++)
				second = second.down;
			for(int j = 0; j < secondCol; j++)
				second = second.right;
			secondBool = true;
		}
		if(destRow < numRows && destRow >= 0 && destCol < numCols && destCol >= 0)
		{
			for(int i = 0; i < destRow; i++)
				dest = dest.down;
			for(int j = 0; j < destCol; j++)
				dest = dest.right;
			destBool = true;
		}
		
		if(firstBool && secondBool && destBool)
		{
			divideNodes(first, second, dest);
		}
	}
	
	public void divideRows(int firstRow, int secondRow, int destRow)
	{
		Node first = head, second = head, dest = head;
		boolean firstBool = false, secondBool = false, destBool = false;
		
		if(firstRow < numRows && firstRow >= 0)
		{
			for(int i = 0; i < firstRow; i++)
				first = first.down;
			firstBool = true;
		}
		if(secondRow < numRows && secondRow >= 0)
		{
			for(int i = 0; i < secondRow; i++)
				second = second.down;
			secondBool = true;
		}
		if(destRow < numRows && destRow >= 0)
		{
			for(int i = 0; i < destRow; i++)
				dest = dest.down;
			destBool = true;
		}
		
		if(firstBool && secondBool && destBool)
		{
			for(int i = 0; i < numCols; i++)
			{
				divideNodes(first, second, dest);
				first = first.right;
				second = second.right;
				dest = dest.right;
			}
		}
	}
	
	public void divideCols(int firstCol, int secondCol, int destCol)
	{
		Node first = head, second = head, dest = head;
		boolean firstBool = false, secondBool = false, destBool = false;
		
		if(firstCol < numCols && firstCol >= 0)
		{
			for(int j = 0; j < firstCol; j++)
				first = first.right;
			firstBool = true;
		}
		if(secondCol < numCols && secondCol >= 0)
		{
			for(int j = 0; j < secondCol; j++)
				second = second.right;
			secondBool = true;
		}
		if(destCol < numCols && destCol >= 0)
		{
			for(int j = 0; j < destCol; j++)
				dest = dest.right;
			destBool = true;
		}
		
		if(firstBool && secondBool && destBool)
		{
			for(int i = 0; i < numRows; i++)
			{
				divideNodes(first, second, dest);
				first = first.down;
				second = second.down;
				dest = dest.down;
			}
		}
	}
	
}
