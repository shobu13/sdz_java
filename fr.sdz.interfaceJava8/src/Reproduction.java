/**
 * Grace à java 8, on peut maintenant déclarer des méthodes static dans les interfaces.
 */
public interface Reproduction {

    public static void description() {
        System.out.println("Méthode statique dans une interface");
    }

}
