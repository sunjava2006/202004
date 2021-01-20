package com.thzhima.advance.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SysMapTest {

	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<>();
		
		map.put("one", 1);
		map.put(null,3);
		
		Integer i = map.get("one");
		
		Integer i2 = map.get("2");
		
		System.out.println(i);
		System.out.println(i2);
		
		
		Set<Entry<String, Integer>> elements = map.entrySet();
		Iterator<Entry<String, Integer>> iter = elements.iterator();
		
		while(iter.hasNext()) {
			Entry<String, Integer> e = iter.next();
			String key = e.getKey();
			Integer value = e.getValue();
			System.out.println(key + ":" + value);
		}
		
		
		Set<String> keys = map.keySet();
		for(String key : keys) {
			System.out.println(key + ":" + map.get(key) );
		}
		
		Collection<Integer> values =  map.values();
		for(Integer ii: values) {
			System.out.println(ii);
		}
		
	}
	
	
	
	
}
