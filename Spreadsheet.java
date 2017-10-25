

import java.util.Scanner;

public class Spreadsheet 
{
	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) 
	{
		
		Grid grid = new Grid();
		
		boolean cont = true;
		String input;
				
		while(cont)
		{
			printMenu();
			printCursor();
			input = keyboard.nextLine();
			
			switch(input.toLowerCase())
			{
				case "dis":
					grid.printGrid();
					break;
					
				case "as":
					grid.fillCell(rowNum(), colNum());
					break;
					
				case "f":
					grid.fillArea(fromRowRange(),fromColRange(),toRowRange(),toColRange());
					break;
					
				case "n":
					grid.fillNumbers(fromRowRange(),fromColRange(),toRowRange(),toColRange());
					break;
					
				case "a":
					grid.addCells(firstRow(), firstCol(), secondRow(), secondCol(), destRow(), destCol());
					break;
					
				case "s":
					grid.subCells(firstRow(), firstCol(), secondRow(), secondCol(), destRow(), destCol());
					break;
					
				case "m":
					grid.multCells(firstRow(), firstCol(), secondRow(), secondCol(), destRow(), destCol());
					break;
					
				case "d":
					grid.divideCells(firstRow(), firstCol(), secondRow(), secondCol(), destRow(), destCol());
					break;
					
				case "ar":
					grid.addRows(firstRow(), secondRow(), destRow());
					break;
					
				case "sr":
					grid.subRows(firstRow(), secondRow(), destRow());
					break;
					
				case "mr":
					grid.multRows(firstRow(), secondRow(), destRow());
					break;
					
				case "dr":
					grid.divideRows(firstRow(), secondRow(), destRow());
					break;

				case "ac":
					grid.addCols(firstCol(), secondCol(), destCol());
					break;
					
				case "sc":
					grid.subCols(firstCol(), secondCol(), destCol());
					break;
					
				case "mc":
					grid.multCols(firstCol(), secondCol(), destCol());
					break;
					
				case "dc":
					grid.divideCols(firstCol(), secondCol(), destCol());
					break;
					
				case "ir":
					grid.addRow(atRow());
					break;
					
				case "ic":
					grid.addColumn(atCol());
					break;
					
				case "delr":
					grid.deleteRow(rowNum());
					break;
					
				case "delc":
					grid.deleteColumn(colNum());
					break;
					
				case "q":
					cont = false;
					break;
					
			}
			
		}

	}
	
	public static void printMenu()
	{
		System.out.println("Operations");
		System.out.println("  display           dis           assign cell       as");
		System.out.println("  fill              f             number            n");
		System.out.println("  add cells         a             subtract cells    s");
		System.out.println("  multiply cells    m             divide cells      d");
		System.out.println("  add rows          ar            subtract rows     sr");
		System.out.println("  multiply rows     mr            divide rows       dr");
		System.out.println("  add columns       ac            subtract columns  sc");
		System.out.println("  multiply columns  mc            divide columns    dc");
		System.out.println("  insert row        ir            insert column     ic");
		System.out.println("  delete row        delr          delete column     delc");
		System.out.println("  quit              q   ");
	}
	
	public static void printCursor()
	{
		System.out.print("->  ");
	}
	
	public static int fromRowRange()
	{
		System.out.print("From Row: ");
		return Integer.parseInt(keyboard.nextLine());
	}
	
	public static int fromColRange()
	{
		System.out.print("From Column: ");
		return Integer.parseInt(keyboard.nextLine());
	}
	
	public static int toRowRange()
	{
		System.out.print("To Row: ");
		return Integer.parseInt(keyboard.nextLine());
	}
	
	public static int toColRange()
	{
		System.out.print("To Column: ");
		return Integer.parseInt(keyboard.nextLine());
	}
	
	public static int atRow()
	{
		System.out.print("At Row: ");
		return Integer.parseInt(keyboard.nextLine());
	}
	
	public static int atCol()
	{
		System.out.print("At Column: ");
		return Integer.parseInt(keyboard.nextLine());
	}
	
	public static int colNum()
	{
		System.out.print("Column Number: ");
		return Integer.parseInt(keyboard.nextLine());
	}
	
	public static int rowNum()
	{
		System.out.print("Row Number: ");
		return Integer.parseInt(keyboard.nextLine());
	}
	
	public static int firstRow()
	{
		System.out.print("first node row: ");
		return Integer.parseInt(keyboard.nextLine());
	}
	
	public static int secondRow()
	{
		System.out.print("second node row: ");
		return Integer.parseInt(keyboard.nextLine());
	}
	
	public static int destRow()
	{
		System.out.print("destination node row: ");
		return Integer.parseInt(keyboard.nextLine());
	}
	
	public static int firstCol()
	{
		System.out.print("first node column: ");
		return Integer.parseInt(keyboard.nextLine());
	}
	
	public static int secondCol()
	{
		System.out.print("second node column: ");
		return Integer.parseInt(keyboard.nextLine());
	}
	
	public static int destCol()
	{
		System.out.print("destination node column: ");
		return Integer.parseInt(keyboard.nextLine());
	}
}
