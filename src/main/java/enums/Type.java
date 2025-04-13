package enums;

public enum Type {
    // Enum constants
    INTEGER("Entier"),
    DOUBLE("Decimale"),
    TEXT("Texte"),
    COLOR("Couleur");

    // Instance variable
    private final String typeName;
    // Constructor
    Type(String typeName) {
        this.typeName = typeName;
    }

    // Getter method
    public String getTypeName() {
        return typeName;
    }

    @Override
    public String toString() {
        return typeName;
    }
}
