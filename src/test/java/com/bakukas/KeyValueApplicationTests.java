package com.bakukas;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import com.bakukas.model.KeyValue;
import com.bakukas.service.KeyValueService;

@AutoConfigureMockMvc
@SpringBootTest
class KeyValueApplicationTests {
	
	@Test
	public void setTest() throws Exception {
		KeyValueService keyValueService=new KeyValueService();
		String result=keyValueService.getKey("abc-1");
		assertEquals(result,"key not found");
		
		KeyValue keyvalue=new KeyValue("abc-1","a");
		keyValueService.set(keyvalue);
		result=keyValueService.getKey("abc-1");
		assertEquals(result,"abc-1");
	}
	
	@Test
	public void getTest() throws Exception {
		KeyValueService keyValueService=new KeyValueService();
		String result=keyValueService.getKey("abc-2");
		assertEquals(result,"key not found");
	}
	
	@Test
	public void prefixTest() throws Exception {
		KeyValueService keyValueService=new KeyValueService();
		KeyValue keyvalue=new KeyValue("abc-1","a");
		keyValueService.set(keyvalue);
		keyvalue=new KeyValue("abc-2","a");
		keyValueService.set(keyvalue);
		keyvalue=new KeyValue("xyz-1","a");
		keyValueService.set(keyvalue);
		keyvalue=new KeyValue("xyz-2","a");
		keyValueService.set(keyvalue);
		
		ArrayList<String> result=keyValueService.search("abc", null);
		
		ArrayList<String> out=new ArrayList<String>();
		out.add("abc-1");
		out.add("abc-2");
		
		assertEquals(out,result);
		
	}
	
	@Test
	public void suffixTest() throws Exception {
		KeyValueService keyValueService=new KeyValueService();
		KeyValue keyvalue=new KeyValue("abc-1","a");
		keyValueService.set(keyvalue);
		keyvalue=new KeyValue("abc-2","a");
		keyValueService.set(keyvalue);
		keyvalue=new KeyValue("xyz-1","a");
		keyValueService.set(keyvalue);
		keyvalue=new KeyValue("xyz-2","a");
		keyValueService.set(keyvalue);
		
		ArrayList<String> result=keyValueService.search(null, "-1");
		
		ArrayList<String> out=new ArrayList<String>();
		out.add("abc-1");
		out.add("xyz-1");
		
		assertEquals(out,result);
		
	}
}
