package dml.bw.core;

import java.util.List;

public class ItemQuality implements Comparable<ItemQuality>{
    private final int prefix;
    private final int base;
    private final int suffix;
    private final String name;
    private boolean markedToDelete;

    public ItemQuality(int prefix, int base, int suffix, String name,
                       boolean markedToDelete) {
        this.prefix = prefix;
        this.base = base;
        this.suffix = suffix;
        this.name = name;
        this.markedToDelete = markedToDelete;
    }

    public int getPrefix() {
        return this.prefix;
    }

    public int getBase() {
        return this.base;
    }

    public int getSuffix() {
        return this.suffix;
    }

    public String getName() {
        return this.name;
    }

    public boolean isMarkedToDelete() {
        return this.markedToDelete;
    }

    public void setMarkedToDelete(boolean markedToDelete) {
        this.markedToDelete = markedToDelete;
    }

    @Override
    public String toString() {
        return "ItemQuality [prefix=" + prefix + ", base=" + base + ", suffix="
                + suffix + ", name=" + name + ", markedToDelete="
                + markedToDelete + "]";
    }

    @Override
    public int compareTo(ItemQuality itemQuality) {
        int  thisAffixValue = this.getPrefix()+ this.getSuffix();
        int affixValue = itemQuality.getPrefix()+ itemQuality.getSuffix();
        if (thisAffixValue > affixValue){
            return 1;
        } else    if (thisAffixValue < affixValue){
            return -1;
        }

        return 0;
    }

}
