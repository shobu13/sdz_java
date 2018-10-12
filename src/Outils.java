/**
 * Classe offrant diff�rents services courants sous forme de m�thodes statiques
 * @version 2018
 * @author JM CARTRON
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.DecimalFormat; 
import javax.swing.JOptionPane;

public class Outils {

	// --------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------outils de saisie et d'affichage-----------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------

	/**
	 * affiche une boite de dialogue pour saisir une donn�e
	 * @param msg   : le message indiquant ce qu'il faut saisir
	 * @param titre : le titre de la boite de dialogue
	 * @return      : la chaine saisie (type String)
	 */
	public static String saisir(String msg, String titre) {
		return JOptionPane.showInputDialog(null, msg, titre, JOptionPane.QUESTION_MESSAGE);
	}
	
	/**
	 * affiche une boite de dialogue pour saisir une donn�e (avec un titre par d�faut : "Saisie")
	 * @param msg   : le message indiquant ce qu'il faut saisir
	 * @return      : la chaine saisie (type String)
	 */
	public static String saisir(String msg) {
		return JOptionPane.showInputDialog(null, msg, "Saisie", JOptionPane.QUESTION_MESSAGE);
	}
	
	/**
	 * affiche un message dans une boite de dialogue
	 * @param msg   : le message � afficher
	 * @param titre : le titre de la boite de dialogue
	 */
	public static void afficher(String msg, String titre) {
		JOptionPane.showMessageDialog(null, msg, titre, JOptionPane.INFORMATION_MESSAGE);
	}	
	
	/**
	 * affiche un message dans une boite de dialogue (avec un titre par d�faut : "Message")
	 * @param msg   : le message � afficher
	 */
	public static void afficher(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
	}
	

	// --------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------outils concernant le traitement des nombres-----------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * teste si une chaine est bien num�rique
	 * @param laChaine : la chaine � tester
	 * @return         : bool�en - true si la chaine repr�sente un nombre correct
	 *                             false dans les autres cas
	 */
	public static boolean isNumeric (String laChaine) {
		if (laChaine == null) return false;
		try {
			laChaine = laChaine.replace(",", ".");
			double nombre = Double.parseDouble(laChaine);
			// new java.math.BigDecimal(laChaine);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * convertit un nombre en chaine format�e
	 * @param unNombre : le nombre � formater
	 * @param unFormat : le format de conversion (exemples : "00", "0.00", "###,###,##0.00", ...)
	 * @return une chaine num�rique format�e
	 */
	public static String formaterNombre(double unNombre, String unFormat) {
	    DecimalFormat df = new DecimalFormat(unFormat);	
		return df.format(unNombre);
	}	
	
	
	// --------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------outils concernant le traitement des dates-------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------	

	/**
	 * teste si une chaine est bien une date
	 * @param laChaine : la chaine � tester
	 * @return         : bool�en - true si la chaine repr�sente une date correcte
	 *                             false dans les autres cas
	 */
	public static boolean isDate (String laChaine) {
		if (laChaine == null) return false;
		
// 		version 1 (ne marche pas correctement)
//		try {
//			@SuppressWarnings("unused")
//			Date uneDate;
//			uneDate = Outils.convertirEnDate(laChaine);
//			return true;
//		}
//		catch (Exception e) {
//			return false;
//		}

		// version 2 du 10/10/2012
		// remplacement des autres s�parateurs par des /
		laChaine = laChaine.replace(" ", "/");
		laChaine = laChaine.replace("-", "/");
		// �clatement de la chaine pour obtenir un tableau de 3 sous-chaines
		String[] tableau = laChaine.split("/");
		if (tableau.length != 3) return false;

		// conversion des 3 sous-chaines en type int
        int j = Integer.parseInt(tableau[0]);		// le jour
        int m = Integer.parseInt(tableau[1]);		// le mois		
        int a = Integer.parseInt(tableau[2]);		// l'ann�e
        
        // test g�n�ral
        if ( m < 0 || m > 12 || j < 0 || j > 31 )  return false;
        // test des mois de 30 jours
        if ( ( m == 4 || m == 6 || m == 9 || m == 11 ) && ( j > 30 ) ) return false;
        // les ann�es bissextiles sont multiples de 4 mais pas de 100, ou bien elles sont multiples de 400 :
        boolean bissextile = ((a % 4) == 0 && (a % 100) != 0) || (a % 400) == 0;
        // f�vrier des ann�es normales (28 jours)
        if ( m == 2 && bissextile == false && j > 28 ) return false;
        // f�vrier des ann�es bissextiles (29 jours)
        if ( m == 2 && bissextile == true && j > 29 ) return false;
        // si on est encore l�, cela signifie que la date est correcte
        return true;
	}  
	
	/**
	 * convertit une chaine date en un objet Date
	 * @param uneChaineDate   : la chaine � convertir
	 * @return                : l'objet Date obtenu par la conversion de la chaine (ou null si la chaine est incorrecte)
	 * @throws ParseException la chaine ne peut pas �tre convertie en date
	 */
	public static Date convertirEnDate(String uneChaineDate) throws ParseException {
		SimpleDateFormat leFormat = new SimpleDateFormat("dd/MM/yyyy");
		try
		{	return leFormat.parse(uneChaineDate);
		}
		catch (Exception ex) {
			return null;
		}
	}

	/**
	 * convertit une chaine dateHeure en un objet Date
	 * @param uneChaineDate   : la chaine � convertir
	 * @return                : l'objet Date obtenu par la conversion de la chaine (ou null si la chaine est incorrecte)
	 * @throws ParseException la chaine ne peut pas �tre convertie en date
	 */
	public static Date convertirEnDateHeure(String uneChaineDateHeure) throws ParseException {
		SimpleDateFormat leFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try
		{	return leFormat.parse(uneChaineDateHeure);
		}
		catch (Exception ex) {
			return null;
		}
	}
	
	/**
	 * convertit une date en une chaine format�e
	 * @param uneDate : la date � formater
	 * @return        : la chaine format�e
	 */
	public static String formaterDate(Date uneDate) {
		SimpleDateFormat leFormat = new SimpleDateFormat("dd/MM/yyyy");
		return leFormat.format(uneDate);
	}

	/**
	 * convertit une date en une chaine format�e comprenant �galement l'heure
	 * @param uneDate : la date et l'heure � formater
	 * @return        : la chaine format�e
	 */
	public static String formaterDateHeure(Date uneDate) {
		SimpleDateFormat leFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return leFormat.format(uneDate);
	}
	
	/**
	 * fournit le libell� du jour de la semaine � partir d'une date
	 * @param uneDate : la date �tudi�e
	 * @return        : le jour de la semaine (exemples : "dimanche", "lundi", ...)
	 */
	public static String getLibelleJour(Date uneDate)	{
		SimpleDateFormat leFormat = new SimpleDateFormat("EEEE");	// "EEEE" : jour de la semaine
		return leFormat.format(uneDate);
	}

	/**
	 * fournit le num�ro de jour de la semaine � partir d'une date
	 * @param uneDate : la date �tudi�e
	 * @return        : le num�ro de jour (1 � 31)
	 */
	public static int getNumeroJour(Date uneDate)	{
		SimpleDateFormat leFormat = new SimpleDateFormat("dd");	// "dd" : num�ro de jour
		return Integer.parseInt(leFormat.format(uneDate));
	}
	
	/**
	 * fournit le libell� de mois � partir d'une date
	 * @param uneDate : la date �tudi�e
	 * @return        : le libell� du mois
	 */
	public static String getLibelleMois(Date uneDate) {
		SimpleDateFormat leFormat = new SimpleDateFormat("MMMM");	// "MMMM" : libell� du mois
		return leFormat.format(uneDate);
	}
	
	/**
	 * fournit le num�ro de mois � partir d'une date
	 * @param uneDate : la date �tudi�e
	 * @return        : le mois ( 1 � 12)
	 */
	public static int getNumeroMois(Date uneDate) {
		SimpleDateFormat leFormat = new SimpleDateFormat("MM");	// "MM" : mois sur 2 chiffres
		return Integer.parseInt(leFormat.format(uneDate));
	}
	
	/**
	 * fournit l'ann�e � partir d'une date
	 * @param uneDate : la date �tudi�e
	 * @return        : l'ann�e sur 4 chiffres
	 */
	public static int getAnnee(Date uneDate) {
		SimpleDateFormat leFormat = new SimpleDateFormat("yyyy");	// "yyyy" : ann�e sur 4 chiffres
		return Integer.parseInt(leFormat.format(uneDate));
	}
	
	/**
	 * fournit une date en ajoutant des jours � une autre date
	 * @param uneDate   : la date de d�part
	 * @param nbDeJours : le nombre de jours � ajouter (ce nombre peut �tre n�gatif)
	 * @return          : la nouvelle date obtenue
	 */
	public static Date ajouterDesJours(Date uneDate, int nbDeJours) {
		Calendar calendrier = Calendar.getInstance();
		calendrier.setTime(uneDate);
		calendrier.add(Calendar.DATE, nbDeJours);
		return calendrier.getTime();
	}
	
	/**
	 * fournit la dur�e (en secondes) entre 2 dates
	 * @param dateDebut : la date de d�but
	 * @param dateFin   : la date de fin
	 * @return
	 */
	public static double getDureeEnSecondes(Date dateDebut, Date dateFin) {
		// getTime fournit le nombre de millisecondes �coul�es depuis le 1/1/1970 � 00:00:00
		return (double)(dateFin.getTime() - dateDebut.getTime()) / 1000;
	}
	
	/**
	 * La fonction DateUS convertit une date fran�aise (j/m/a) au format US (a-m-j)
	 * par exemple, le param�tre '16/05/2007' donnera '2007-05-16'
	 * @param laDate : la date � transformer
	 * @return       : la date transform�e
	 */
	public static String getDateUS (String laDate)
	{	String[] tableau = laDate.split ("/");		// on extrait les segments de la chaine laDate s�par�s par des "/"
		String J = tableau[0];
		String M = tableau[1];
		String A = tableau[2];
		return (A + "-" + M + "-" + J);				// on les reconcat�ne dans un ordre diff�rent
	}

	/**
	 * La fonction DateFR convertit une date US (a-m-j) au format Fran�ais (j/m/a)
	 * par exemple, le param�tre '2007-05-16' donnera '16/05/2007'
	 * @param laDate : la date � transformer
	 * @return       : la date transform�e
	 */
	public static String getDateFR (String laDate)
	{	String[] tableau = laDate.split ("-");		// on extrait les segments de la chaine laDate s�par�s par des "-"
		String A = tableau[0];
		String M = tableau[1];
		String J = tableau[2];
		return (J + "/" + M + "/" + A);				// on les reconcat�ne dans un ordre diff�rent
	}

	
	// --------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------outils concernant le traitement des chaines ----------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------	

	/**
	 * compl�te la chaine fournie par des espaces jusqu'� la longueur d�sir�e
	 * @param laChaine : la chaine � compl�ter
	 * @param longueur : la longueur � obtenir
	 * @return         : la chaine compl�t�e
	 */
	public static String completerChaine(String laChaine, int longueur) {
		while ( laChaine.length() < longueur ) {
			laChaine = laChaine + " ";
		}
		return laChaine;
	}
	
	/**
	 * compl�te la chaine fournie par un caract�re choisi jusqu'� la longueur d�sir�e
	 * @param laChaine    : la chaine � compl�ter
	 * @param longueur    : la longueur � obtenir
	 * @param leCaractere : le caract�re utilis� pour compl�ter la chaine
	 * @return            : la chaine compl�t�e
	 */
	public static String completerChaine(String laChaine, int longueur, char leCaractere) {
		while ( laChaine.length() < longueur ) {
			laChaine = laChaine + leCaractere;
		}
		return laChaine;
	}	
	
	
	
}
