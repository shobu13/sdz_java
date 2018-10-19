import java.io.IOException;
import java.nio.file.*;
import java.util.*;

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
//        testPolymorphisme();
        //<editor-fold desc="testAnimaux">
        //        testAnimal();
//        testAnimalInterface();
        //</editor-fold>
//        testReproduction();
//        testException();
//        testEnum();
        //<editor-fold desc="testcollections">
        //        testLinkedList();
//        testHashTable();
//        testHashSet();
        //</editor-fold>
//        testGeneric();
//        testFileObject();
//        testFileIO();


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

    private static Object println(Object object) {
        System.out.println(object);
        return object;
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
                Ville V = null;
                try {
                    V = new Ville("france", tab[i], tab2[i]);
                } catch (NombreHabitantException e) {
                    e.printStackTrace();
                } catch (NomVilleException e) {
                    e.printStackTrace();
                }
                tableau[i] = V;
            } else {
                Capitale C = null;
                try {
                    C = new Capitale("france", tab[i], tab2[i], "la tour Eiffel");
                } catch (NombreHabitantException e) {
                    e.printStackTrace();
                } catch (NomVilleException e) {
                    e.printStackTrace();
                }
                tableau[i] = C;
            }
        }

        //Il ne nous reste plus qu'à décrire tout notre tableau !
        for (Object obj : tableau) {
            System.out.println(obj.toString() + "\n");
        }
    }

    //<editor-fold desc="testAnimaux">
    private static void testAnimal() {
        Animal unAnimal = new Chien("Gris bleuté", 20);
        unAnimal.boire();
        unAnimal.manger();
        unAnimal.deplacement();
        unAnimal.crier();
        System.out.println(unAnimal.toString());

        unAnimal = new Chat("Gris bleuté", 20);
        unAnimal.boire();
        unAnimal.manger();
        unAnimal.deplacement();
        unAnimal.crier();
        System.out.println(unAnimal.toString());
    }

    private static void testAnimalInterface() {
        //Les méthodes d'un chien
        Chien c = new Chien("Gris bleuté", 20);
        c.boire();
        c.manger();
        c.deplacement();
        c.crier();
        System.out.println(c.toString());

        System.out.println("--------------------------------------------");
        //Les méthodes de l'interface
        c.faireCalin();
        c.faireLeBeau();
        c.faireLechouille();

        System.out.println("--------------------------------------------");
        //Utilisons le polymorphisme de notre interface
        Rintintin r = new Chien();
        r.faireLeBeau();
        r.faireCalin();
        r.faireLechouille();
        ((Chien) r).manger();
    }
    //</editor-fold>

    private static void testReproduction() {
        Reproduction.description();
        System.out.println("--------------");
        Pondre.description();
        System.out.println("--------------");
        Mitose.description();
        System.out.println("--------------");
        Alien alien = new Alien();
        alien.reproduire();
    }

    private static void testException() {
        int j = 20, i = 0;
        try {
            System.out.println(j / i);
        } catch (ArithmeticException e) {
            System.out.println("Division par zéro !" + e.getMessage());
        } finally {
            System.out.println("Exécutée quoi qu'il arrive.");
        }
        System.out.println("coucou toi !");
    }

    //<editor-fold desc="Enum">

    /**
     * Fonction testant si le paramètre passé est égal à Langage.JAVA ou Langage.PHP
     *
     * @param param : on demande un paramètre qui sera nécessairement de type langage.
     */
    private static void fait(Langage param) {
        if (param.equals(Langage.JAVA))
            System.out.println("Fait à la façon N°1");
        if (param.equals(Langage.PHP))
            System.out.println("Fait à la façon N°2");
    }

    private static void testEnum() {
        fait(Langage.JAVA);
        fait(Langage.PHP);
//        cette instruction fera planter la compilation car le paramètre n'est pas de bon type.
//        fait(4);
    }
    //</editor-fold>

    //<editor-fold desc="testCollections">

    /**
     * fonction de test des LinkedList
     * les LinkedList son similaire aux ArrayList si ce n'est qu'elle permette de
     * générer un itérateur.
     */
    private static void testLinkedList() {
        List list = new LinkedList();
        list.add(12);
        list.add("toto ! !");
        list.add(12.20f);
        for (Object x : list) {
            println(x);
        }
        println("----------------");
        ListIterator iterator = list.listIterator();

        while (iterator.hasNext())
            println(iterator.next());
    }

    /**
     * L'objet Hashmap ressemble à l'objet HashTable si ce n'est qu'il acepte null et n'est pas Thread safe.
     */
    private static void testHashTable() {
        Hashtable hashtable = new Hashtable();
        hashtable.put(1, "printemps");
        hashtable.put(10, "été");
        hashtable.put(12, "automne");
        hashtable.put(45, "hiver");

        println(hashtable.get(1));
        println("----------------");
        Enumeration enumeration = hashtable.elements();

        while (enumeration.hasMoreElements())
            System.out.println(enumeration.nextElement());
    }

    private static void testHashSet() {
        HashSet hs = new HashSet();
        hs.add("toto");
        hs.add(12);
        hs.add('d');

        Iterator it = hs.iterator();
        while (it.hasNext())
            System.out.println(it.next());

        System.out.println("\nParcours avec un tableau d'objet");
        System.out.println("-----------------------------------");

        Object[] obj = hs.toArray();
        for (Object o : obj)
            System.out.println(o);
    }
    //</editor-fold>

    private static void testGeneric() {
        Solo<Integer> val = new Solo<Integer>();
        Solo<String> valS = new Solo<String>("TOTOTOTO");
        Solo<Float> valF = new Solo<Float>(12.2f);
        Solo<Double> valD = new Solo<Double>(12.202568);

        println(val.getValeur());
        println(valS.getValeur());
        println(valF.getValeur());
        println(valD.getValeur());
    }

    private static void testFileObject() {
        Path path = Paths.get("test.txt");

        System.out.println("Chemin absolu du fichier : " + path.toAbsolutePath());
        System.out.println("Est-ce qu'il existe ? " + Files.exists(path));
        System.out.println("Nom du fichier : " + path.getFileName());
        System.out.println("Est-ce un répertoire ? " + Files.isDirectory(path));

        //On récupère maintenant la liste des répertoires dans une collection typée
        //Via l'objet FileSystem qui représente le système de fichier de l'OS hébergeant la JVM
        Iterable<Path> roots = FileSystems.getDefault().getRootDirectories();

        //Maintenant, il ne nous reste plus qu'à parcourir
        for(Path chemin : roots){
            System.out.println(chemin);
            //Pour lister un répertoire, il faut utiliser l'objet DirectoryStream
            //L'objet Files permet de créer ce type d'objet afin de pouvoir l'utiliser
            try(DirectoryStream<Path> listing = Files.newDirectoryStream(chemin)){

                int i = 0;
                for(Path nom : listing){
                    System.out.print("\t\t" + ((Files.isDirectory(nom)) ? nom+"/" : nom));
                    i++;
                    if(i%4 == 0)System.out.println("\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void testFileIO() {
    }
}
