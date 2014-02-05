package com.platine.zoodelille.meteo;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.platine.zoodelille.utils.Constantes;

import android.content.Context;
import android.util.Log;

public class ContainerData {	

	static public Context context;

	public ContainerData() {

	}

	public static ArrayList<Entry> getFeeds(){
		// On passe par une classe factory pour obtenir une instance de sax
		SAXParserFactory fabrique = SAXParserFactory.newInstance();
		SAXParser parseur = null;
		ArrayList<Entry> entries = null;
		try {
			// On "fabrique" une instance de SAXParser
			parseur = fabrique.newSAXParser();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}

		// On défini l'url du fichier XML
		URL url = null;
		try {
			url = new URL(Constantes.URL_METEO_LILLE_XML);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}

		/*
		 * Le handler sera gestionnaire du fichier XML c'est à dire que c'est lui qui sera chargé
		 * des opérations de parsing. On vera cette classe en détails ci après.
		*/
		DefaultHandler handler = new ParserXMLHandler();
		try {
			// On parse le fichier XML
			InputStream input = url.openStream();
			if(input==null)
				Log.e("Erreur Android lors de l'ouverture du l'inputStream pour la lecture du la meteo ","null");
			else{
				parseur.parse(input, handler);
				// On récupère directement la liste des feeds
				entries = ((ParserXMLHandler) handler).getData();
			}
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// On la retourne l'array list
		return entries;
	}
}