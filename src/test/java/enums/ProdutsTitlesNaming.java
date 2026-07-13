package enums;

public enum ProdutsTitlesNaming {
    private final String displayName;

    ProdutsTitlesNaming(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
