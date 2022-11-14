import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

class TestFile {
    public Test[] tests;
}

class Test {
    public Integer id;
    public String title;
    public String value;
    public Test[] values;

    public void FillTests(Map<Integer, String> valuesMap) {
        value = valuesMap.get(id);
        if (values != null) {
            for (Test t : values) {
                t.FillTests(valuesMap);
            }
        }
    }
}

class Value {
    public Integer id;
    public String value;
}

class ValuesFile {
    public Value[] values;
}

public class Task3 {
    public static void main(String[] args) throws JsonParseException {

        TestFile mainTest = new TestFile();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            mainTest = new Gson().fromJson(reader, TestFile.class);


        } catch (JsonParseException | IOException e) {
            e.printStackTrace();
        }
        ValuesFile mainValues = new ValuesFile();
        try (Reader reader = new FileReader(args[1])) {
            mainValues = new Gson().fromJson(reader, ValuesFile.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<Integer, String> valuesMap = new HashMap<>();
        for (Value v : mainValues.values) {
            valuesMap.put(v.id, v.value);
        }
        for (Test t : mainTest.tests) {
            t.FillTests(valuesMap);
        }

        try (FileWriter writer = new FileWriter(args[2])) {
            writer.write(new GsonBuilder().setPrettyPrinting().create().toJson(mainTest));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

