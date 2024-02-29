package jp.ne.yonem.sandbox.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import jp.ne.yonem.sandbox.dto.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
@Slf4j
public class JsonService {

    public static final String OUTPUT_FILE_PATH = "test.json";

    public void output(List<Item> items) {
        var gson = new GsonBuilder().setPrettyPrinting().create();
        var jsonFile = new File(OUTPUT_FILE_PATH);

        try (var fos = new FileOutputStream(jsonFile);
             var osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
             var out = new BufferedWriter(osw)) {

            // JSONデータをファイルに出力する
            gson.toJson(items, out);

        } catch (Exception e) {
            log.error("error", e);
        }
    }

    public List<Item> input(File path) throws Exception {

        try (var reader = new BufferedReader(new FileReader(path))) {
            var gson = new Gson();
            var dataJsonLayoutType = new TypeToken<List<Item>>() {
            }.getType();

            return gson.fromJson(reader, dataJsonLayoutType);
        }
    }
}
