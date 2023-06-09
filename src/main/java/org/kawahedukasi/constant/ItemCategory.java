package org.kawahedukasi.constant;

public enum ItemCategory {
    A_LA_CARTE("a la carte"),
    APPERTIZERS("appertizers"),
    SIDES("sides"),
    EXTRAS("extras"),
    BEVERAGES("beverages");

    private String name;

    ItemCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
