package com.avizva.util;

import com.google.gson.Gson;

public class JsonUtil {
	private static Gson gson = new Gson();

	public static String convertToJson(Object object) {
		return gson.toJson(object);
	}
}
