package utils;

import com.github.javafaker.Faker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestUtil {

    private static final String baseDir = "src/main/resources/ssql/";

    public static void main(String[] args) {
        generateSSQL("FakeInfo","Name,Company,Birthday\n", 30);
    }

    public static void generateSSQL(String testName, String columns, int num) {
        try {
            File file = new File(baseDir + testName + ".ssql");
            if (file.createNewFile()) {
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter writer = new BufferedWriter(fileWriter);
                writer.write(columns);
                for (int i = 0; i < num; i++) {
                    Faker faker = new Faker();
                    String birthday = faker.date().birthday().toString().replace(" ", "_");
                    String company = faker.company().name().replace(" ", "_")
                                    .replace(",", "")
                                    .replace("-", "")
                                    .replace("+", "")
                                    .replace("=", "");
                    writer.write(
                            faker.name().lastName() + "," +
                                company + "," +
                                birthday + "\n");
                }
                writer.close();
                fileWriter.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
