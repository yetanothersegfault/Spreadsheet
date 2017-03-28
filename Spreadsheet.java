

import java.util.Scanner;

public class Spreadsheet 
{

	public static void main(String[] args) 
	{
		
		Scanner keyboard = new Scanner(System.in);
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
					break;
					
				case "as":
					break;
					
				case "f":
					break;
					
				case "n":
					break;
					
				case "a":
					break;
					
				case "s":
					break;
					
				case "m":
					break;
					
				case "d":
					break;
					
				case "ar":
					break;
					
				case "sr":
					break;
					
				case "mr":
					break;
					
				case "dr":
					break;

				case "ac":
					break;
					
				case "sc":
					break;
					
				case "mc":
					break;
					
				case "dc":
					break;
					
				case "ir":
					break;
					
				case "ic":
					break;
					
				case "delr":
					break;
					
				case "delc":
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

}
