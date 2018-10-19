public interface Mitose extends Reproduction {
    public static void description() {
        Reproduction.description();
        System.out.println("Redéfinie dans Mitose.java");
    }

    /**
     * avec java 8 il est possible de définir un coomprotement par défaut pour les méthodes
     * d'interface, cela permet d'éviter d'avoir à les implémenter dans les classe filles.
     */
    default void reproduire() {
        System.out.println("Je me divise !");
    }
}