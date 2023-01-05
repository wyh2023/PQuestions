package utils;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class YamlUtil {

    public static void main(String[] args) {
        YamlUtil handler = new YamlUtil();
        handler.parseYaml("src/main/resources/ssql.yml");
    }

    public Map<String, Object> parseYaml(String fileName) {
        File file = new File(fileName);
        Yaml yaml = new Yaml();
        Map<String, Object> ret = null;
        try {
            ret = yaml.load(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

}
