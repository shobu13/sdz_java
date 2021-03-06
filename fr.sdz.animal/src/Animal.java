abstract class Animal {
    protected String couleur;
    protected int poids;

    protected void manger() {
        System.out.println("Je mange de la viande");
    }

    protected void boire() {
        System.out.println("Je boie de l'eau");
    }

    abstract void deplacement();

    abstract void crier();

    public String toString(){
        return "Je suis un objet de la " + this.getClass() + ", je suis " + this.couleur + ", je pèse " + this.poids;
    }
}
