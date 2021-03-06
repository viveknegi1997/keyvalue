package com.bakukas.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.bakukas.model.KeyValue;
@Service
public class KeyValueService {
	HashMap<String, String> keyValueHashMap = new HashMap<>();
	
	public String set(KeyValue keyvalue) {
		if(keyvalue.getKey()==null||keyvalue.getKey()=="")
			return "key cannot be null";
		keyValueHashMap.put(keyvalue.getKey(), keyvalue.getValue());
		return "key is inserted";
	}
	
	public String getKey(String key) {
		if (keyValueHashMap.containsKey(key)) {
			return keyValueHashMap.get(key);
		}
		return "key not found";
	}
	
	public ArrayList<String> search(String prefix,String suffix) {
		ArrayList<String> result=new ArrayList<String>();
		if(prefix!=null)
		{
			for (String key: keyValueHashMap.keySet()) {
			    if(key.startsWith(prefix))
			    	result.add(key);
			}
		}
		if(suffix!=null)
		{
			for (String key: keyValueHashMap.keySet()) {
			    if(key.endsWith(suffix))
			    	result.add(key);
			}
		}
		return result;
	}
}
