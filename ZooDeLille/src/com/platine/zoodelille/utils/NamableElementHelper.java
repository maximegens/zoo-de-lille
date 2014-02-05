package com.platine.zoodelille.utils;

import java.util.HashMap;
import java.util.List;

import com.platine.zoodelille.beans.Enclosure;
import com.platine.zoodelille.beans.NamableElement;

public class NamableElementHelper {
	public static <T extends NamableElement> HashMap<String, T> transformToHashMap(List<T> namableElement_list)
	{
		HashMap<String, T> dico = new HashMap<String, T>();
		
		for(T e : namableElement_list)
			dico.put(e.getName(), e);
		
		return dico;
	}
}
