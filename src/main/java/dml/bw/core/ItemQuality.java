package dml.bw.core;

import java.util.List;

public class ItemQuality {
    int prefix;
    int base;
    int suffix;
    String name;
    boolean markedToDelete;

    public ItemQuality(int prefix, int base, int suffix, String name,
                       boolean markedToDelete) {
        this.prefix = prefix;
        this.base = base;
        this.suffix = suffix;
        this.name = name;
        this.markedToDelete = markedToDelete;
    }

    public int getPrefix() {
        return prefix;
    }

    public void setPrefix(int prefix) {
        this.prefix = prefix;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getSuffix() {
        return suffix;
    }

    public void setSuffix(int suffix) {
        this.suffix = suffix;
    }

    public boolean isMarkedToDelete() {
        return markedToDelete;
    }

    public void setMarkedToDelete(boolean markedToDelete) {
        this.markedToDelete = markedToDelete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ItemQuality [prefix=" + prefix + ", base=" + base + ", suffix="
                + suffix + ", name=" + name + ", markedToDelete="
                + markedToDelete + "]";
    }








}
