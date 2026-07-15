package enums;

public enum ProdutsTitlesNaming {
    BACKPACK("Sauce Labs Backpack"),
    TSHIRT("Sauce Labs Bolt T-Shirt"),
    ONISE("Sauce Labs Onesie"),
    LIGHT("Sauce Labs Bike Light"),
    JACKET("Sauce Labs Fleece Jacket"),
    REDTSHIRT("Test.allTheThings() T-Shirt (Red)");

    private final String displayName;

    ProdutsTitlesNaming(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
