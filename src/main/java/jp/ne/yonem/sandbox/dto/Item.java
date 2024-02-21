package jp.ne.yonem.sandbox.dto;

import lombok.Data;

@Data
public class Item {

    public Item() {
    }

    public Item(Long id, Long parent, String name, String description) {
        this.id = id;
        this.parent = parent;
        this.name = name;
        this.description = description;
    }

    Long id;
    Long parent;
    String name;
    String description;
}
