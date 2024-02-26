package jp.ne.yonem.sandbox.service;

import com.google.gson.GsonBuilder;
import jp.ne.yonem.sandbox.dto.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
@Slf4j
public class JsonService {

    public void output(List<Item> items) {
        var gson = new GsonBuilder().setPrettyPrinting().create();
        var jsonFile = new File("test.json");

        try (var fos = new FileOutputStream(jsonFile);
             var osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
             var out = new BufferedWriter(osw)) {

            // JSONデータをファイルに出力する
            gson.toJson(items, out);

        } catch (Exception e) {
            log.error("error", e);
        }
    }
}
