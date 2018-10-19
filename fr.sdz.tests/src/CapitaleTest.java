import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CapitaleTest {

    @Test
    public void Testconstructor() {
        Capitale capitale = new Capitale();
        Assertions.assertEquals(0, capitale.getNbreHabitants());
        Assertions.assertEquals("Inconnu", capitale.getNomPays());
        Assertions.assertEquals("Inconnu", capitale.getNomVille());
//        Assertions.assertEquals(1, Ville.nbreInstance);
    }

    @Test
    public void TestConstructorWithParameter() {
        Capitale capitale = null;
        try {
            capitale = new Capitale("Rennes", "Bretagne", 10, "Parlement");
        } catch (NombreHabitantException e) {
            e.printStackTrace();
        } catch (NomVilleException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals("Rennes", capitale.getNomVille());
        Assertions.assertEquals("Bretagne", capitale.getNomPays());
        Assertions.assertEquals(10, capitale._nbreHabitants);
//        Assertions.assertEquals(1, Ville.nbreInstance);

        Assertions.assertEquals("Parlement", capitale.getMonument());
    }

}