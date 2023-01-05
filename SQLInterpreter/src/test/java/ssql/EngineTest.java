package ssql;

import dbEngine.EngineOptionsHandler;
import dbEngine.SSQLEngine;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class EngineTest {

    private final EngineOptionsHandler handler = new EngineOptionsHandler();

    private final SSQLEngine engine = SSQLEngine.getInstance();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void out() {
        System.out.print("hello");
        assertEquals("hello", outContent.toString());
    }

    @Test
    public void simpleTest() {
        handler.resolve("src/main/resources/ssql.yml");
        File file = new File("src/main/resources/ssql/Simple.ssql");
        engine.input(file);
        engine.output("Simple");
        String expected = readExpected("src/test/resources/Simple-Expected.txt");
        assertEquals(expected, outContent.toString());
    }

    private String readExpected(String fileName) {
        StringBuilder sb = new StringBuilder();
        File file = new File(fileName);
        String line;
        try {
            FileInputStream stream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            while ((line = reader.readLine()) != null) {
                sb.append(line)
                        .append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
