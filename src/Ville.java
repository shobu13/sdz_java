import java.util.Objects;

public class Ville {

    public static int nbreInstance = 0;

    protected String _nomVille;
    protected String _nomPays;
    protected int _nbreHabitants;

    public String getNomVille() {
        return _nomVille;
    }

    public void setNomVille(String _nomVille) {
        this._nomVille = _nomVille;
    }

    public void setNomPays(String nomPays) {
        this._nomPays = nomPays;
    }

    public void setNbreHabitants(int nbreHabitants) {
        this._nbreHabitants = nbreHabitants;
    }

    public String getNomPays() {
        return _nomPays;
    }

    public int getNbreHabitants() {
        return _nbreHabitants;
    }

    public Ville() {
        System.out.println("Création d'une ville !");
        this._nomVille = "Inconnu";
        this._nomPays = "Inconnu";
        this._nbreHabitants = 0;

        nbreInstance++;
    }

    public Ville(String nomVille, String nomPays, int nbreHabitants) {
        this._nomVille = nomVille;
        this._nomPays = nomPays;
        this._nbreHabitants = nbreHabitants;

        nbreInstance++;
    }

    public String toString(){
        return "\t"+this._nomVille+" est une ville de "+this._nomPays+", elle comporte : "+this._nbreHabitants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ville ville = (Ville) o;
        return _nbreHabitants == ville._nbreHabitants &&
                Objects.equals(_nomVille, ville._nomVille) &&
                Objects.equals(_nomPays, ville._nomPays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_nomVille, _nomPays, _nbreHabitants);
    }

    public static void setNbreInstance(int nbreInstance) {
        Ville.nbreInstance = nbreInstance;
    }
}
