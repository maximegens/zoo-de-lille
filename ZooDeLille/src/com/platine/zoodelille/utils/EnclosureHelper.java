package com.platine.zoodelille.utils;

import java.util.HashMap;
import java.util.List;

import com.platine.zoodelille.beans.Enclosure;

public class EnclosureHelper {
	public static HashMap<String, Enclosure> transformToHashMap(List<Enclosure> enclosure_list)
	{
		HashMap<String, Enclosure> dico = new HashMap<String, Enclosure>();
		
		for(Enclosure e : enclosure_list)
			dico.put(e.getName(), e);
		
		return dico;
	}
}
