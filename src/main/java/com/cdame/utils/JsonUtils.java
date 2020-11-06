package com.cdame.utils;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	private static final ObjectMapper mapper = new ObjectMapper();
	
	private JsonUtils() {
		
	}
	
	public static <T> T toObject(byte[] body, Class<T> clazz) {
		try {
			return mapper.readValue(body, clazz);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String toJSON(Object o) {
		try {
			return mapper.writeValueAsString(o);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
