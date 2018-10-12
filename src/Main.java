import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //<editor-fold desc="test scanner">
//        testScannerString();
//        testScannerInt();
        //</editor-fold>
//        fahrenheit();
        //<editor-fold desc="test Tableaux">
//        tableauMonoDim();
//        tableauMultiDim();
        //</editor-fold>
//        testMethodesChaines();
//        println("Hello World !");
        testPolymorphisme();


    }

    private static void testScannerString() {
        // on créer un nouvel objet scanner en lui passant en paramètre l'entrée standard de java.
        Scanner sc = new Scanner(System.in);
        System.out.print("Saisissez un mot. \n: ");
        String str = sc.nextLine();
        System.out.println("Vous avez saisis : " + str);
    }

    private static void testScannerInt() {
        // on créer un nouvel objet scanner en lui passant en paramètre l'entrée standard de java.
        Scanner sc = new Scanner(System.in);
        System.out.print("Saisissez un nombre. \n: ");
        int nb = sc.nextInt();
        sc.nextLine();
        // on replace la tête de lecture sur une nouvelle ligne, en effet, les instructions autre que
        // .nextLine() n'effectuent pas cette opération.
        System.out.println("Vous avez saisis : " + nb);
    }

    private static void fahrenheit() {
        Scanner sc = new Scanner(System.in);
        int response = 0;

        float temp = 0;
        float result = 0;

        boolean reset = true;

        while (reset) {
            do {
                System.out.println("Quelle convertion voulez vous effectuer ?");
                System.out.println("\t1)Celsius - Fahrenheit");
                System.out.println("\t2)Fahrenheit - Celsius");
                System.out.print("\t: ");

                response = sc.nextInt();
                sc.nextLine();

                System.out.println();
            } while (response != 1 && response != 2);

            switch (response) {
                case 1:
                    System.out.println("Celsius - Fahrenheit");
                    System.out.println("\tentrez le nombre à convertir");
                    System.out.print(": ");
                    temp = sc.nextFloat();
                    sc.nextLine();
                    result = 9.0f / 5.0f * temp + 32.0f;
                    break;
                case 2:
                    System.out.println("Fahrenheit - Celsius");
                    System.out.println("\tentrez le nombre à convertir");
                    System.out.print(": ");
                    temp = sc.nextFloat();
                    sc.nextLine();
                    result = (temp - 32.0f) * 5.0f / 9.0f;
                    break;
            }
            System.out.println("Resultat :");
            System.out.print("\t" + result);

            System.out.println("Voulez vous refaire ue convertion ?");
            System.out.println("\t1)oui");
            System.out.println("\t2)non");
            System.out.print(": ");
            response = sc.nextInt();
            sc.nextLine();

            reset = response == 1;
        }
    }

    private static void tableauMonoDim() {
        System.out.println("Tableau Monodimentionnel\n");
        int tableauEntier[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,};
        parcourirTableau(tableauEntier);

        String tableauChaine[] = {"un", "deux", "trois", "quatre",};
        parcourirTableau(tableauChaine);

        int tableauEntierVide[] = new int[6];
        parcourirTableau(tableauEntierVide);
    }

    private static void tableauMultiDim() {
        System.out.println("Tableau Multidimentionnel\n");
        int premiersNombres[][] = {{0, 2, 4, 6, 8}, {1, 3, 5, 7, 9}};
        parcourirTableau(premiersNombres);

    }

    private static void testMethodesChaines() {
        String str = "Hello World !";
        System.out.println(str);
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());
        System.out.println(str.length());
        // comparaison entre 2 chaines, on ne peut pas utiliser l'opérateur ==
        // en effet, les instance de String étant dse objets, on comparerais les adresses mémoires.
        System.out.println(str.equals("bleh !"));
        System.out.println(str.equals("Hello World !"));
        System.out.println(str.charAt(4));
        System.out.println(str.substring(4, 9));
        System.out.println(str.indexOf("World"));
    }

    private static String println(String str) {
        System.out.println(str);
        return str;
    }

    //<editor-fold desc="ParcourirTableau">
    private static void parcourirTableau(int[] tab) {
        System.out.print("{ ");
        for (int nb : tab) {
            System.out.print(nb);
            System.out.print(", ");
        }
        System.out.println("}");
    }

    private static void parcourirTableau(String[] tab) {
        System.out.print("{ ");
        for (String str : tab) {
            System.out.print(str);
            System.out.print(", ");
        }
        System.out.println("}");
    }

    private static void parcourirTableau(int[][] tab) {
        System.out.println("{ ");
        for (int[] nbTab : tab) {
            System.out.print("\t{ ");
            for (int nb : nbTab) {
                System.out.print(nb);
                System.out.print(", ");
            }
            System.out.println("}");
        }
        System.out.println("}");
    }
    //</editor-fold>

    private static void testPolymorphisme() {
        //Définition d'un tableau de villes null
        Ville[] tableau = new Ville[6];

        //Définition d'un tableau de noms de Villes et un autre de nombres d'habitants
        String[] tab = {"Marseille", "lille", "caen", "lyon", "paris", "nantes"};
        int[] tab2 = {123456, 78456, 654987, 75832165, 1594, 213};

        //Les trois premiers éléments du tableau seront des Villes
        //et le reste des capitales
        for (int i = 0; i < 6; i++) {
            if (i < 3) {
                Ville V = new Ville("france", tab[i], tab2[i]);
                tableau[i] = V;
            } else {
                Capitale C = new Capitale("france", tab[i], tab2[i], "la tour Eiffel");
                tableau[i] = C;
            }
        }

        //Il ne nous reste plus qu'à décrire tout notre tableau !
        for (Object obj : tableau) {
            System.out.println(obj.toString() + "\n");
        }
    }
}
