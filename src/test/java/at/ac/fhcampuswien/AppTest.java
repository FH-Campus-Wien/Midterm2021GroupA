package at.ac.fhcampuswien;

import org.junit.jupiter.api.*;
import java.io.*;
import java.lang.reflect.Method;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(2)
public class AppTest {

    private PrintStream originalOut;
    private InputStream originalIn;
    private ByteArrayOutputStream bos;
    private PrintStream ps;

    @BeforeAll
    public static void init() {
        System.out.println("Testing Midterm");
    }

    @AfterAll
    public static void finish() {
        System.out.println("Finished Testing Midterm");
    }

    @BeforeEach
    public void setupStreams() throws IOException {
        originalOut = System.out;
        originalIn = System.in;

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);
        System.setIn(pis);
        ps = new PrintStream(pos, true);
    }

    @AfterEach
    public void tearDownStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void generateRandomMonth() {
        int test;

        try {
            // action
            Method m = App.class.getMethod("generateRandomMonth");
            // assertion
            for (int i = 0; i < 20; i++) {
                test = (int)m.invoke(null);
                assertTrue(1 <= test && test <= 12);
            }
        } catch (NoSuchMethodException name){
            fail("There should be a static method called generateRandomMonth.");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred. Check data types and return types.");
        }
    }

    @Test
    public void monthMapper1(){
        ps.println("r");
        String result;

        try {
            Method m = App.class.getMethod("monthMapper");
            result = (String)m.invoke(null);
            String[] months = new DateFormatSymbols(Locale.US).getMonths();
            assertTrue(Arrays.asList(months).contains(result));
        } catch (NoSuchMethodException name){
            fail("There should be a static method called monthMapper.");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred. Check data types and return types.");
        }
    }

    @Test
    public void monthMapper2(){
        ps.println("4");
        String result;

        try {
            Method m = App.class.getMethod("monthMapper");
            result = (String)m.invoke(null);
            assertEquals("April", result);
        } catch (NoSuchMethodException name){
            fail("There should be a static method called monthMapper.");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred. Check data types and return types.");
        }
    }

    @Test
    public void monthMapper3(){
        ps.println("13");
        String result;

        try {
            Method m = App.class.getMethod("monthMapper");
            result = (String)m.invoke(null);
            assertEquals("Invalid month", result);
        } catch (NoSuchMethodException name){
            fail("There should be a static method called monthMapper.");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred. Check data types and return types.");
        }
    }

    @Test
    public void monthMapper4(){
        ps.println("r");
        String output = "Enter a number between 1-12 or \"r\" to pick a random month:" + System.lineSeparator();

        try {
            Method m = App.class.getMethod("monthMapper");
            m.invoke(null);
            assertEquals(output, bos.toString());
        } catch (NoSuchMethodException name){
            fail("There should be a static method called monthMapper.");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred. Check data types and return types.");
        }
    }

    @Test
    public void extendArray1(){
        int[] result;

        try {
            Method m = App.class.getMethod("extendArray", int[].class, int[].class);
            int[] a = {1, 2, 3, 4};
            int[] b = {-1, -2, -3};
            result = (int[])m.invoke(null, a, b);
            int[] expected = {-1, -2, -3, 1, 2, 3, 4};
            assertArrayEquals(expected, result);
        } catch (NoSuchMethodException name){
            fail("There should be a static method called extendArray.");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred. Check data types and return types.");
        }
    }

    @Test
    public void extendArray2(){
        int[] result;

        try {
            Method m = App.class.getMethod("extendArray", int[].class, int[].class);
            int[] a = {6, 8};
            int[] b = {5, 3, 2, 1};
            result = (int[])m.invoke(null, a, b);
            int[] expected = {6, 8, 5, 3, 2, 1};
            assertArrayEquals(expected, result);
        } catch (NoSuchMethodException name){
            fail("There should be a static method called extendArray.");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred. Check data types and return types.");
        }
    }

    @Test
    public void extendArray3(){
        int[] result;

        try {
            Method m = App.class.getMethod("extendArray", int[].class, int[].class);
            int[] a = {3, 3, 3, 3};
            int[] b = {1, 1, 1, 1};
            result = (int[])m.invoke(null, a, b);
            int[] expected = {1, 3, 1, 3, 1, 3, 1, 3};
            assertArrayEquals(expected, result);
        } catch (NoSuchMethodException name){
            fail("There should be a static method called extendArray.");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred. Check data types and return types.");
        }
    }

    @Test
    public void extendArray4(){
        int[] result;

        try {
            Method m = App.class.getMethod("extendArray", int[].class, int[].class);
            int[] a = {};
            int[] b = {5, 3, 2, 1};
            result = (int[])m.invoke(null, a, b);
            int[] expected = {5, 3, 2, 1};
            assertArrayEquals(expected, result);
        } catch (NoSuchMethodException name){
            fail("There should be a static method called extendArray.");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred. Check data types and return types.");
        }
    }

    @Test
    public void extendArray5(){
        int[] result;

        try {
            Method m = App.class.getMethod("extendArray", int[].class, int[].class);
            int[] a = {0, 0};
            int[] b = {-1, -1};
            result = (int[])m.invoke(null, a, b);
            int[] expected = {-1, 0, -1, 0};
            assertArrayEquals(expected, result);
        } catch (NoSuchMethodException name){
            fail("There should be a static method called extendArray.");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred. Check data types and return types.");
        }
    }

}
