public enum Langage {
    // ici, on instancie directement certains objets, en passant les paramètres du constructeur entre parenthèses.
    JAVA ("Langage JAVA"),
    C ("Langage C"),
    CPlus ("Langage C++"),
    PHP ("Langage PHP");

    private String name;

    // Constructeur

    Langage(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
