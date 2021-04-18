package com.bakukas.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bakukas.model.KeyValue;
import com.bakukas.service.KeyValueService;

@RestController
public class MainController {
	@Autowired
	KeyValueService keyValueService;
	
	@RequestMapping(value = "/set", method = RequestMethod.POST)
	@ResponseBody
	public void set(@RequestBody KeyValue keyvalue) {
		keyValueService.set(keyvalue);
	}

	@RequestMapping(value = "/get/{key}", method = RequestMethod.GET)
	@ResponseBody
	public String getKey(@PathVariable("key") String key) {
		return keyValueService.getKey(key);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<String> search(@RequestParam(value="prefix", required=false) String prefix,@RequestParam(value="suffix", required=false) String suffix) {
		return keyValueService.search(prefix, suffix);
	}
}