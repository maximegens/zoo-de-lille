package com.platine.zoodelille.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

/**
 * Permet de connaitre l'état status internet du téléphone.
 * 
 */
public class ConnexionInternet
{
	/**
	 * Indique si le device est connecté à Internet. 
	 * @param activity L'activity qui demande le test de connection, si il s'agit d'un fragment il faut utiliser la méthode "getActivity()" en paramétre.
	 * @return Un boolean, true si il existe une connection, false si il n'y a pas de connection internet. 
	 */
    public static boolean isConnectedInternet(Activity activity)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager)activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null)
        {
            State networkState = networkInfo.getState();
            if (networkState.compareTo(State.CONNECTED) == 0)
            {
                return true;
            }
            else return false;
        }
        else return false;
    }
}