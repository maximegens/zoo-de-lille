package com.platine.zoodelille.utils;

/** 
 * Cette classe contient une liste de toutes les constantes de l'application.
 * 
 **/
public class Constantes {

	public static String DATABASE_NAME = "db_zoodelille";
	public static final String[] fragments ={
            "com.platine.zoodelille.fragments.AccueilFragment",
            "com.platine.zoodelille.fragments.AnimauxFragment",
            "com.platine.zoodelille.fragments.PlanDuZooFragment",
//            "com.platine.zoodelille.fragments.ActivitesPedagogiqueFragment",
//            "com.platine.zoodelille.fragments.JeuxInteractifFragment",
            "com.platine.zoodelille.fragments.PlanAccesFragment",
            "com.platine.zoodelille.fragments.InformationsPratiqueFragment",
//            "com.platine.zoodelille.fragments.AuxAlentoursFragment",
//            "com.platine.zoodelille.fragments.ReglagesFragment",
            "com.platine.zoodelille.fragments.ContactFragment",
            "com.platine.zoodelille.fragments.AProposFragment"
	};
	public static String URL_METEO_LILLE_XML = "http://weather.yahooapis.com/forecastrss?w=608105&u=c";
	public static String URL_METEO_ICONE_DEBUT = "http://l.yimg.com/a/i/us/we/52/";
	public static String URL_METEO_ICONE_FIN = ".gif";
	public static String TEMPERATURE_C = " °C";
	public static String CONNEXION_INTERNET_FAILED = "Aucune connexion";
	public static String PROCHAIN_HORAIRE = "Jusque ";
	public static String HEURE = "H ";
	public static String COORDONNEES_GPS_ZOO_LATITUDE = "50.63828789999999";
	public static String COORDONNEES_GPS_ZOO_LONGITUDE = "3.0455561999999645";
	public static String ADRESSE_MAIL = "developpement.zoo.lille@gmail.com";
	public static String NUMERO_TEL_ZOO = "0328520700";

	
	
}
