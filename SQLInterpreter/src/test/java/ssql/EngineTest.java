package ssql;

import dbEngine.EngineOptionsHandler;
import dbEngine.SSQLEngine;
import org.junit.Test;

import java.io.File;

public class EngineTest {

    private final EngineOptionsHandler handler = new EngineOptionsHandler();

    private final SSQLEngine engine = SSQLEngine.getInstance();

    @Test
    public void simpleTest() {
        handler.resolve("src/main/resources/ssql.yml");
        File file = new File("src/main/resources/ssql/Simple.ssql");
        engine.input(file);
    }

}
