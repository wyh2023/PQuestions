import dbEngine.EngineOptionsHandler;
import dbEngine.SSQLEngine;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        EngineOptionsHandler handler = new EngineOptionsHandler();
        handler.resolve("src/main/resources/ssql.yml");
        SSQLEngine engine = SSQLEngine.getInstance();
        File file = new File("src/main/resources/ssql/Simple.ssql");
        engine.input(file);
    }

}
