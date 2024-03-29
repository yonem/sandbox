package jp.ne.yonem.sandbox.service;

import jp.ne.yonem.sandbox.dto.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

class JsonServiceTest {

    @Test
    @DisplayName("動作確認 - output")
    void test1() {
        var items = new ArrayList<Item>();
        items.add(new Item(1L, 1L, "Item-1", "test-data"));
        items.add(new Item(2L, 1L, "Item-2", "test-data"));
        items.add(new Item(3L, 1L, "Item-3", "test-data"));
        items.add(new Item(4L, 1L, "Item-4", "test-data"));
        items.add(new Item(7L, 2L, "Item-7", "test-data"));
        items.add(new Item(5L, 2L, "Item-5", "test-data"));
        items.add(new Item(6L, 2L, "Item-6", "test-data"));
        items.add(new Item(8L, 3L, "Item-8", "test-data"));
        items.add(new Item(9L, 3L, "Item-9", "test-data"));
        var sut = new JsonService();
        sut.output(items);
    }

    @Test
    @DisplayName("動作確認 - input")
    void test2() throws Exception {
        var sut = new JsonService();
        var items = sut.input(new File(JsonService.OUTPUT_FILE_PATH));
        System.out.println(items);
    }

    @Test
    @DisplayName("異常系 - input")
    void test3() {
        var sut = new JsonService();
        assertThrows(Exception.class, () -> sut.input(new File("not_exists")));
    }
}