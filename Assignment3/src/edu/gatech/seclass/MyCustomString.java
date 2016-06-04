package edu.gatech.seclass;
import java.util.*;

/**
 * This is an interface for a simple class that represents a string, defined
 * as a sequence of characters.
 * 
 * @author Rufus
 * 
 */
public class MyCustomString implements MyCustomStringInterface 
{

	private String string;
	
	
	
	/**
	 * Sets the value of the current string.
	 * 
	 * @param string
	 *            The value to be set
	 */
	public void setString(String string) 
	{
		this.string = string;
	}

	
	
	/**
	 * Returns the current string
	 * 
	 * @return Current string
	 */
    public String getString() 
    {
		return this.string;
	}	
	

    
	/**
	 * Returns a string that consists of all and only the characters
	 * in positions n, 2n, 3n, and so on in the current string, in the 
	 * same order and with the same case as in the current string (i.e., 
	 * for n=3, the method would return the 3rd, 6th, 9th, and so on 
	 * characters in the string). Value n is passed as a parameter. The 
	 * first character in the string is considered to be in Position 1.
	 * 
	 * @param n
	 *            Determines the positions of the characters to be returned
	 * @return String made of characters at positions n, 2n, and so on
	 * in the current string
	 */	
	public String getEveryNthCharacter(int n) 
	{
		String new_string = "";		
		
		if ( n < 0 ) {
			new_string = "";
		}
		
		else {
			
			for (int i=0; i <= string.length(); i++) 
			{
				if ( (i+1) % n == 0 && i < string.length() ) 
				{
					new_string = new_string + string.charAt(i);
				}	
			}
	
		}
		//System.out.println(new_string);
		return new_string;
	}

	
	
	/**
	 * Returns the number of digits in the current string
	 * 
	 * @return Number of digits in the current string
	 */
	 public int countDigits() 
	 {
	
		String[] string_chars;
		List digits = Arrays.asList("0","1","2","3","4","5","6","7","8","9");
		int digit_count = 0;
		String digit_list = "";
		
		string_chars = this.string.split("");
		
		for (int i=0; i<string_chars.length; i++) 
		{
			if (digits.contains(string_chars[i])) 
			{
				digit_count = digit_count + 1;
				digit_list = digit_list + string_chars[i];
			}
		}

        //System.out.println(digit_list);	
		//System.out.println("Digit Count = "+ digit_count);

		return digit_count;
	}
	


		/**
		 * Replace the individual digits (except in the case of "10", as
	     * explained below) in the current string, between startPosition and
	     * endPosition (included), with the corresponding English names of
	     * those digits, with the first letter capitalized.
		 * The first character in the string is considered to be in Position 1.
		 * Digits are converted individually, even if contiguous, with the only
	     * exception of "10", which is converted to "Ten". Some examples:
	     * - 460 would be converted to FourSixZero
	     * - 410 would be converted to FourTen
	     * - 416 would be converted to FourOneSix
		 * 
		 * @param startPosition
		 *            Position of the first character to consider
		 * @param endPosition
		 *            Position of the last character to consider
		 * @return
	     * @throws IllegalArgumentException
	     *            If "startPosition" > "endPosition"
		 * @throws MyIndexOutOfBoundsException
		 *            If "startPosition" <= "endPosition", but either
	     *            "startPosition" or "endPosition" are out of
		 *            bounds (i.e., either less than 1 or greater then the
		 *            length of the string)
		 */
	@Override
	public void convertDigitsToNamesInSubstring(int startPosition,int endPosition) throws MyIndexOutOfBoundsException,IllegalArgumentException	{
		String newstring = "",  new_left_string="", new_mid_string_temp="", new_mid_string="", new_right_string=""; 
		if (startPosition > endPosition) 
			throw new IllegalArgumentException();
		
		if (startPosition < 1 || endPosition > string.length()) 
			throw new MyIndexOutOfBoundsException();
		
		List strlist = Arrays.asList("0","1","2","3","4","5","6","7","8","9");
		String[] digits = {"Zero", "One", "Two", "Three", "Four", "Five" , "Six" , "Seven" , "Eight" , "Nine" };
		String[] stringtemp = {};
		int j=0;
		
		new_left_string = this.string.substring(0, startPosition-1);
		new_right_string = this.string.substring(endPosition, this.string.length());
		new_mid_string_temp = this.string.substring(startPosition-1, endPosition);	
		
		
		//System.out.println(new_left_string);	
		//System.out.println(new_mid_string_temp);	
		//System.out.println(new_right_string);	
		
		stringtemp = new_mid_string_temp.split("");		
		
		for (int i=0; i<stringtemp.length; i++) {
					
			if( strlist.contains(stringtemp[i]) ) {
	
				if (i<(stringtemp.length-1) && stringtemp[i].equals("1") && stringtemp[i+1].equals("0")) {
					new_mid_string = new_mid_string + "Ten";
				}
				
				else if ( (i > 0) && stringtemp[i].equals("0") && stringtemp[i-1].equals("1") ) {	
				}
								
				else {
					j = strlist.indexOf(stringtemp[i]);
					new_mid_string = new_mid_string + digits[j];					
				}
			}
			
			else {
				new_mid_string = new_mid_string + stringtemp[i];
			}
		

		}

		newstring = new_left_string + new_mid_string + new_right_string;
		string = newstring; 
		//System.out.println("New String:  " + string);	
		
	}	
}
