package edu.gatech.seclass;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MyCustomStringTest {

	private MyCustomStringInterface mycustomstring;

	@Before
	public void setUp() throws Exception
	{
		mycustomstring = new MyCustomString();
	}

	@After
	public void tearDown() throws Exception 
	{
		mycustomstring = null;
	}

	// This test checks whether the testCountDigits can count digits in a long string.
    @Test
    public void testCountDigits1()	{
        mycustomstring.setString("I'd better put s10me d1gits in this 5tr1n9, right?");
        assertEquals(6, mycustomstring.countDigits());
    }

    // This test checks whether the testCountDigits can count digits in a shorter string.
	@Test
	public void testCountDigits2() 	{
        mycustomstring.setString("What 1s thr33 plus 4ty 4?");
        assertEquals(5, mycustomstring.countDigits());
	}

	// This test checks whether the testCountDigits can count digits in a string with special characters.
	@Test
	public void testCountDigits3() 	{
        mycustomstring.setString("?$?%>^?&>S?675?#?4/?2/?8?900?");
        assertEquals(9, mycustomstring.countDigits());
	}

	// This test checks whether the testCountDigits can count digits in a string made up of all digits 0-9.
	@Test
	public void testCountDigits4() {
        mycustomstring.setString("1223334444555556666667777777888888889999999990000000000");
        assertEquals(55, mycustomstring.countDigits());
	}

	// This test checks whether the testCountDigits can give a count of 0 in a string that has no digits.
	@Test
	public void testCountDigits5() {
        mycustomstring.setString("What    ?");
        assertEquals(0, mycustomstring.countDigits());
	}

	// This test checks whether the testCountDigits can count digits in a string with special characters.
	@Test
	public void testCountDigits6() {
        mycustomstring.setString("11<>#@*0%^&^9");
        assertEquals(4, mycustomstring.countDigits());
	}

	// This test checks whether the testCountDigits can count digits in a string with a "-" sign.
	@Test
	public void testCountDigits7() {
        mycustomstring.setString("-1235");
        assertEquals(4, mycustomstring.countDigits());
	}

	// This test checks whether the testCountDigits can count digits in a string with a "-" and "+" signs.
	@Test
	public void testCountDigits8() {
        mycustomstring.setString("+2-2");
        assertEquals(2, mycustomstring.countDigits());
	}

	// This test checks whether the testGetEveryNthCharacter can return every 3rd character in a long string.
    @Test
    public void testGetEveryNthCharacter1()	{
        mycustomstring.setString("I'd better put s10me d1gits in this 5tr1n9, right?");
        assertEquals("deep 0 gsnh r9rh", mycustomstring.getEveryNthCharacter(3));
    }

	// This test checks whether the testGetEveryNthCharacter can return every 2nd character in a short string.
	@Test
	public void testGetEveryNthCharacter2() { 
        mycustomstring.setString("What is to be done here?");
        assertEquals("hti ob oehr?", mycustomstring.getEveryNthCharacter(2));
	}

	// This test checks whether the testGetEveryNthCharacter can return every 4th character in a short string.
	@Test
	public void testGetEveryNthCharacter3() { 
        mycustomstring.setString("What is to be done here?");
        assertEquals("t boh?", mycustomstring.getEveryNthCharacter(4));
	}

	// This test checks whether the testGetEveryNthCharacter can return every character in a long string.
	@Test
	public void testGetEveryNthCharacter4() {
        mycustomstring.setString("I'd better put s10me d1gits in this 5tr1n9, right?");
        assertEquals("I'd better put s10me d1gits in this 5tr1n9, right?", mycustomstring.getEveryNthCharacter(1));
	}

	// This test checks whether the testGetEveryNthCharacter can return empty string when n is greater than string length.
    @Test
    public void testGetEveryNthCharacter5() {
        mycustomstring.setString("Th15 mak35 comp13t3 53n53");
        assertEquals("", mycustomstring.getEveryNthCharacter(55));
    }

	// This test checks whether the testGetEveryNthCharacter can return the last character in a long string.
    @Test
    public void testGetEveryNthCharacter6() {
        mycustomstring.setString("Th15 mak35 comp13t3 53n53");
        assertEquals("3", mycustomstring.getEveryNthCharacter(25));
    }

	// This test checks whether the testGetEveryNthCharacter can return empty string when n is negative.
    @Test
    public void testGetEveryNthCharacter7() {
        mycustomstring.setString("Th15 mak35 comp13t3 53n53");
        assertEquals("", mycustomstring.getEveryNthCharacter(-1));
    }

	// This test checks whether the testConvertDigitsToNamesInSubstring can change "10" and "1" in a substring of a long string.
    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd better put s10me d1gits in this 5tr1n9, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd better put sTenme dOnegits in this 5tr1n9, right?", mycustomstring.getString());
    }

	// This test checks whether the testConvertDigitsToNamesInSubstring can change "460" in a string.    
    @Test
    public void testConvertDigitsToNamesInSubstring2() { 
    	mycustomstring.setString("460");
    	mycustomstring.convertDigitsToNamesInSubstring(1, 3);
    	assertEquals("FourSixZero", mycustomstring.getString());
    }

	// This test checks whether the testConvertDigitsToNamesInSubstring can change "410" in a string.      
    @Test
    public void testConvertDigitsToNamesInSubstring3() { 
    	mycustomstring.setString("410");
    	mycustomstring.convertDigitsToNamesInSubstring(1, 3);
    	assertEquals("FourTen", mycustomstring.getString());
    }

	// This test checks whether the testConvertDigitsToNamesInSubstring can change "416" in a string.    
    @Test
    public void testConvertDigitsToNamesInSubstring4() {
    	mycustomstring.setString("416");
    	mycustomstring.convertDigitsToNamesInSubstring(1, 3);
    	assertEquals("FourOneSix", mycustomstring.getString());
    }

	// This test checks whether the testConvertDigitsToNamesInSubstring can change "989" in a string.       
    @Test
    public void testConvertDigitsToNamesInSubstring5() {
    	mycustomstring.setString("This is 989 test");
    	mycustomstring.convertDigitsToNamesInSubstring(9, 11);
    	assertEquals("This is NineEightNine test", mycustomstring.getString());
    }

	// This test checks whether the testConvertDigitsToNamesInSubstring can change only the "0" in a string that contains "10".     
    @Test
    public void testConvertDigitsToNamesInSubstring6() {
    	mycustomstring.setString("hi10string");
    	mycustomstring.convertDigitsToNamesInSubstring(4, 7);
    	assertEquals("hi1Zerostring", mycustomstring.getString());
    }

	// This test checks whether the testConvertDigitsToNamesInSubstring can change only the "1" in a string that contains "10".    
    @Test
    public void testConvertDigitsToNamesInSubstring7() {
	    mycustomstring.setString("hi10");
	    mycustomstring.convertDigitsToNamesInSubstring(1,3);
    	assertEquals("hiOne0", mycustomstring.getString());
    }

	// This test checks whether the testConvertDigitsToNamesInSubstring can change only the "1" in a string that contains "10".    
    @Test
    public void testConvertDigitsToNamesInSubstring8() {
	    mycustomstring.setString("012345678910");
	    mycustomstring.convertDigitsToNamesInSubstring(1,12);
    	assertEquals("ZeroOneTwoThreeFourFiveSixSevenEightNineTen", mycustomstring.getString());
    }

	// This test checks whether the testConvertDigitsToNamesInSubstring can raise IllegalArgumentException if the start position is greater than the end position.    
    @Test(expected = IllegalArgumentException.class)
    public void testConvertDigitsToNamesInSubstring9() 
    {
        mycustomstring.setString("I'd better put s10me d1gits in this 5tr1n9, right?");      
        mycustomstring.convertDigitsToNamesInSubstring(21,12);
    }
    
	// This test checks whether the testConvertDigitsToNamesInSubstring can raise IndexOutOfBoundsException if the start position is less than 1.      
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring0() 
    {
        mycustomstring.setString("I'd better put s10me d1gits in this 5tr1n9, right?");      
       	mycustomstring.convertDigitsToNamesInSubstring(0,23);
    }
    
	// This test checks whether the testConvertDigitsToNamesInSubstring can raise IndexOutOfBoundsException if the end position is greater than string.      
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring10() 
    {
        mycustomstring.setString("right?");      
       	mycustomstring.convertDigitsToNamesInSubstring(1,7);
    }
}
