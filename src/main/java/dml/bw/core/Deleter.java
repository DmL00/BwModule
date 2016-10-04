package dml.bw.core;

import java.util.List;

class Deleter {
    void deleteMa​rkedItems(List<ItemQuality> itemQuality) {
        for (int i = 0; i < itemQuality.size(); i++) {
            if (itemQuality.get(i).isMarkedToDelete() == true) {
                itemQuality.remove(i);
            }
        }
    }
}
