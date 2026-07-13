package enums;

public enum TitleNaming {
    PRODUCTS("Products"),
    CARTS("Your Cart"),
    CHECKOUT("Checkout: Your Information"),
    COMPLETED("Checkout: Complete!");

    private final String displayName;

    TitleNaming(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
