package jp.ne.yonem.sandbox.dto;

import lombok.Data;

@Data
public class Item {

    Long id;
    Long parent;
    String name;
    String description;
}
