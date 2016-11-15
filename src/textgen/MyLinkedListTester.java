/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
        try {
            emptyList.get(0);
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {
            
        }
        
        // test short list, first contents, then out of bounds
        assertEquals("Check first", "A", shortList.get(0));
        assertEquals("Check second", "B", shortList.get(1));
        
        try {
            shortList.get(-1);
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {
        
        }
        try {
            shortList.get(2);
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {
        
        }
        // test longer list contents
        for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
            assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
        }
        
        // test off the end of the longer array
        try {
            longerList.get(-1);
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {
        
        }
        try {
            longerList.get(LONG_LIST_LENGTH);
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {
        }
        
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// test off the end of the longer array
        try {
            longerList.remove(-1);
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {
        
        }
        try {
            longerList.remove(LONG_LIST_LENGTH);
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {
        }
        try {
            emptyList.remove(0);
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {
            
        }
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
       shortList.add("C");
       String c = shortList.get(2);
	   assertEquals("Shortlist: added C", "C" , c);
	   longerList.add(45);
	   int d = longerList.get(10);
	   assertEquals("longerList: added a 45", 45, d);
	   try {
           longerList.add(null);
           fail("Null element exception");
       }
       catch (NullPointerException e) {
       }
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		int a = emptyList.size();
		int b = list1.size();
		assertEquals("Empty should be zero", 0, a);
		assertEquals("list1", 3, b);
		list1.add(3);
		assertEquals("added to list1", 4 ,list1.size());
		list1.remove(1);
		assertEquals("removed from list1", 3, list1.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
		list1.add(0, 4);
		assertEquals("list1: get back 4 at index 0",(Integer) 4, list1.get(0));
		assertEquals("list1: now element 1 is 65.", (Integer)65, list1.get(1));
		// test off the end of the longer array
        try {
            longerList.add(-1, 3);
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {
        
        }
        try {
            longerList.add(0, null);
            fail("Null element exception");
        }
        catch (NullPointerException e) {
        }
        try {
            longerList.add(LONG_LIST_LENGTH + 1, 0);
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {
        }
        try {
            emptyList.add(-1,4);
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {
            
        }
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
		int c = list1.set(0, 4);
		assertEquals("list1: get back 65", 65, c);
		assertEquals("list1: now element 0 is 4.", (Integer)4, list1.get(0));
		// test off the end of the longer array
        try {
            longerList.set(-1, 3);
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {
        
        }
        try {
            longerList.set(0, null);
            fail("Null element exception");
        }
        catch (NullPointerException e) {
        }
        try {
            longerList.set(LONG_LIST_LENGTH, 0);
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {
        }
        try {
            emptyList.set(0,4);
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {
            
        }
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
