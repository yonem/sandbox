package jp.ne.yonem.sandbox.service;

import jp.ne.yonem.sandbox.dto.Item;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StreamService {

    public Map<Long, List<Item>> list2MapList(List<Item> items) {
        return items.stream()
                .collect(Collectors.groupingBy(Item::getParent,
                        Collectors.mapping(item -> item, Collectors.toList())))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> entry.getValue().stream().limit(3).collect(Collectors.toList())));
    }
}
