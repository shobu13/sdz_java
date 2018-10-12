import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class VilleTest {
    @Test
    public void ConstructorTest() {
        Ville ville = new Ville();
        Assertions.assertEquals(0, ville.getNbreHabitants());
        Assertions.assertEquals("Inconnu", ville.getNomPays());
        Assertions.assertEquals("Inconnu", ville.getNomVille());
        ville.setNbreHabitants(10);
        ville.setNomPays("Bretagne");
        ville.setNomVille("Rennes");
        Assertions.assertEquals(10, ville.getNbreHabitants());
        Assertions.assertEquals("Bretagne", ville.getNomPays());
        Assertions.assertEquals("Rennes", ville.getNomVille());
        Ville ville2 = new Ville();
//        Assertions.assertEquals(2, Ville.nbreInstance);
    }
}