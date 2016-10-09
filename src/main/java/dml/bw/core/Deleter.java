package dml.bw.core;

import java.util.List;

class Deleter {
    void deleteMa​rkedItems(List<ItemQuality> itemQualities) {
        for (int i = 0; i < itemQualities.size(); i++) {
            if (itemQualities.get(i).isMarkedToDelete()) {
                itemQualities.remove(i);
            }
        }
    }
}
