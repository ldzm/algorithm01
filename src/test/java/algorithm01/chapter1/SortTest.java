package algorithm01.chapter1;

import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SortTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SortTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SortTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testBucketSort()
    {
    	int [] array = {5, 3, 5, 2, 8, 3};
    	int [] sorted = {2, 3, 3, 5, 5, 8};
    	
    	int [] result = Arrays.copyOf(array, array.length);
    	Sort sort = new Sort();
    	sort.bucketSort(result);
    	
    	assertTrue(Arrays.equals(result, sorted));
    }
    
    public void testBubbleSort()
    {
    	int [] array = {5, 3, 5, 2, 8, 3};
    	int [] sorted = {2, 3, 3, 5, 5, 8};

    	Sort sort = new Sort();
    	sort.bubbleSort(array);
    	
    	assertTrue(Arrays.equals(array, sorted));
    }
    
    public void testQuickSort()
    {
    	int [] array = {5, 3, 5, 2, 8, 3};
    	int [] sorted = {2, 3, 3, 5, 5, 8};

    	Sort sort = new Sort();
    	sort.quickSort(array, 0, array.length - 1);
    	
    	assertTrue(Arrays.equals(array, sorted));
    }
    
    public void testMergeSort()
    {
    	int [] array = {5, 3, 5, 2, 8, 3};
    	int [] sorted = {2, 3, 3, 5, 5, 8};

    	Sort sort = new Sort();
    	sort.mergeSort(array, 0, 1);
    	
    	assertTrue(Arrays.equals(array, sorted));
    }
}
