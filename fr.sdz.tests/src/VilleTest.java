import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class VilleTest {
    @Test
    public void ConstructorTest() {
        Ville ville = new Ville();
        assertEquals(0, ville.getNbreHabitants());
        assertEquals("Inconnu", ville.getNomPays());
        assertEquals("Inconnu", ville.getNomVille());
        ville.setNbreHabitants(10);
        ville.setNomPays("Bretagne");
        ville.setNomVille("Rennes");
        assertEquals(10, ville.getNbreHabitants());
        assertEquals("Bretagne", ville.getNomPays());
        assertEquals("Rennes", ville.getNomVille());
        Ville ville2 = new Ville();
//        Assertions.assertEquals(2, Ville.nbreInstance);
        try {
            Ville ville3 = new Ville("st", "test", -10);
        } catch (NombreHabitantException e) {
            e.printStackTrace();
        } catch(NomVilleException e2){
            System.out.println(e2.getMessage());
        }
    }
}