package dml.bw.core;

import java.util.List;


public class MainAlg {

    void process(List<ItemQuality> itemQuality) {
        Sorter sorter = new Sorter();
        sorter.sort(itemQuality);
        Deleter deleter = new Deleter();
        Marker marker = new Marker();
        for (int i = 0; i < itemQuality.size(); i++) {
            ItemQuality tnLhs = itemQuality.get(i);
            for (int j = i + 1; j < itemQuality.size(); j++) {
                ItemQuality tnRhs = itemQuality.get(j);
                marker.process(tnLhs, tnRhs);
            }
            deleter.deleteMarkedItems(itemQuality);
        }

        // i jak wyjdzie z tej petli to powininien wszytskie znalesc i
        // usunac, trzeba tylko dodac miejsce gdzie ma przepisywac cos do
        // nowej kolekcji
    }
}