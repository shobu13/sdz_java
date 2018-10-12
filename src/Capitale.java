public class Capitale extends Ville {

    private String _monument;

    public String getMonument() {
        return _monument;
    }

    public void setMonument(String _monument) {
        this._monument = _monument;
    }

    public Capitale() {
        super();
        this._monument = "aucun";
    }

    public Capitale(String nomVille, String nomPays, int nbreHabitants, String _monument) {
        super(nomVille, nomPays, nbreHabitants);
        this._monument = _monument;
    }

    public String toString(){
        return super.toString() + "\n \t ==>>" + this._monument + " en est un monument";
    }
}
