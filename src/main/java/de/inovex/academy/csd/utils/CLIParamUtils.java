package de.inovex.academy.csd.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CLIParamUtils {

	private static boolean isEven(int i) {
		return (i % 2) == 0;
	}
	
	public static Map<String, String> readMap(String[] args) {
		if (!isEven(args.length)) {
			throw new IllegalArgumentException("please providen an even number of arguments");
		}
		
		Map<String, String> map = new HashMap<>();
		
		for (int i = 0; i < args.length; i += 2) {
			map.put(args[i], args[i + 1]);
		}
		
		return map;
	}

	public static Map<String, String> readMap(int argumentsToIgnore, String[] args) {
		return readMap(Arrays.copyOfRange(args, argumentsToIgnore, args.length));
	}

}
