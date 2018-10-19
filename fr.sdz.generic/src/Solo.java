/**
 * Classe de démosntration pour les paramètres génériques, rien n'empêche bien sur
 * d'utiliser un nombre X de paramètres génériques.
 * @param <T> : paramètre générique
 */
public class Solo<T> {

    private T valeur;

    public Solo() {
        this.valeur = null;
    }

    public Solo(T valeur) {
        this.valeur = valeur;
    }

    public T getValeur() {
        return valeur;
    }

    public void setValeur(T valeur) {
        this.valeur = valeur;
    }
}
