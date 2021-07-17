package behavioral.strategy.before;

import java.util.ArrayList;
import java.util.List;

public class Bucket {
    private List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public int getTotal() {
        return items.stream().mapToInt(item -> item.getPrice()).sum();
    }

}
