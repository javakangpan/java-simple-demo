package UtilsTest;

import org.junit.Test;

import UB.SimpleMap;
import utils.ArrayUtil;
import utils.IOUtil;
import utils.StringUtil;
import utils.SystemUtil;

public class UtilTest {

    @Test
    public void testChunk() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[][] arr = ArrayUtil.chunk(numbers, 2);
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[x].length; y++) {
                System.out.print(arr[x][y] + " ");
            }
            System.out.println();
        }
    }
    
    @Test
    public void testToCamelCase() {
       System.out.println(StringUtil.toCamelCase("to1camel2case"));
    }
    
    @Test
    public void TestGetCurrentWorkingDirectoryPath() {
        System.out.println(IOUtil.getCurrentWorkingDirectoryPath());
    }
    
    @Test
    public void TestStackTraceAsString() {
        
        try {
            int i = 10;
            System.out.println(i/0);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("================================");
            System.out.println(e);
            System.out.println(System.getProperty("os.name").toLowerCase());
            System.out.println("================================");
            System.out.println( IOUtil.stackTraceAsString(e));
        }
        
    }
    
    @Test
    public void testisDebuggerAttached() {
       System.out.println(SystemUtil.isDebuggerAttached());
    }
    
    @Test
    public void testSimpleMap() {
        SimpleMap<Integer, String> map = new SimpleMap<Integer, String>(3);
        map.put(0, "liting");
        System.out.println(map.size());
    }
    
}
