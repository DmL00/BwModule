package dml.bw.core;

import org.assertj.core.data.Index;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Christopher on 2016-10-05.
 */
public class SorterTest {

    private final Sorter sorter = new Sorter();

    @Test
    public void shouldSortElementsDesc() {
        //given
        ItemQuality itemQuality1 = new ItemQuality(10, 1, 11, "a", true);
        ItemQuality itemQuality2 = new ItemQuality(10, 2, 12, "b", true);
        List<ItemQuality> itemQualities = new ArrayList<>();
        itemQualities.add(itemQuality1);
        itemQualities.add(itemQuality2);

        //when
        sorter.sort(itemQualities);

        //then
//        assertThat(itemQualities).isSortedAccordingTo(new
//                                                              Comparator<ItemQuality>() {
//                                                                  @Override
//                                                                  public int compare(ItemQuality o1, ItemQuality o2) {
//                                                                      return 0;
//                                                                  }
//                                                              });
        assertThat(itemQualities).contains(itemQuality2, Index.atIndex(1));
        assertThat(itemQualities).contains(itemQuality1, Index.atIndex(0));
    }

}