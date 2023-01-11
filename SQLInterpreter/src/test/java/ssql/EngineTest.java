package ssql;

import dbEngine.EngineOptionsHandler;
import dbEngine.SSQLEngine;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ssql.gen.SQLLexer;
import ssql.gen.SQLParser;
import ssql.info.QueryInfo;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class EngineTest {

    private final EngineOptionsHandler handler = new EngineOptionsHandler();

    private final SSQLEngine engine = SSQLEngine.getInstance();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    public static SSQLVisitor visitor = new SSQLVisitor();
    public static SSQLErrorListener errorListener = new SSQLErrorListener();

    public static String dir = "src/main/resources/ssql/";

    public static String yamlDir = "src/main/resources/ssql.yml";

    public static String expectedDir = "src/test/resources/Engine-Expected/";

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
    public void simpleTest() {
        handler.resolve(yamlDir);
        File file = new File(dir + "Simple.ssql");
        engine.input(file);
        engine.outputAll("Simple");
        String expected = readExpected("Simple");
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void checkTableTest() {
        EngineTest("select Namie from Simple where City = Beijing",
                "checkTableTest");
    }

    @Test
    public void testFakeInfo() {
        EngineTest("select Name,Company,Birthday from FakeInfo where Name = Braun or Company = RathSimonis",
                "FakeInfo");
    }

    @Test
    public void testNotOr() {
        EngineTest("select Name,Company,Birthday from FakeInfo where not Name = Haag or Name = Hane",
                "NotOr");
    }

    @Test
    public void testWholeColumn() {
        EngineTest("select Name,Company,Birthday from FakeInfo where not Name = Name",
                "WholeColumn");
    }

    private void EngineTest(String input, String testName) {
        SQLLexer lexer = new SQLLexer(CharStreams.fromString(input));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SQLParser parser = new SQLParser(tokenStream);
        parser.addErrorListener(errorListener);

        EngineOptionsHandler handler = new EngineOptionsHandler();
        handler.resolve(yamlDir);
        SSQLEngine engine = SSQLEngine.getInstance();
        File file = new File("src/main/resources/ssql");
        for (File child : Objects.requireNonNull(file.listFiles()))
            engine.input(child);

        QueryInfo info = (QueryInfo) parser.query().accept(visitor);
        QueryChecker checker = new QueryChecker();
        if (checker.check(info)) {
            engine.execute(info);
            assertEquals(readExpected(testName), outContent.toString());
        } else {
            assertEquals(readExpected(testName), errContent.toString());
        }
    }

    private String readExpected(String testName) {
        String fileName = expectedDir + testName + "-Expected.txt";
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
