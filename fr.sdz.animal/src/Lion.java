public class Lion extends Felin {
    public Lion() {
    }

    public Lion(String couleur, int poids) {
        this.couleur = couleur;
        this.poids = poids;
    }

    @Override
    void crier() {
        System.out.println("Je rugie dans la savane");
    }
}
