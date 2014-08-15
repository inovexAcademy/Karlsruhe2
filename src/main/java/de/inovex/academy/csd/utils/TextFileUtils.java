package de.inovex.academy.csd.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TextFileUtils {
	/**
	 * @param The filename of the file to be read
	 * @return The content of the file, joined by \n
	 * @throws IOException
	 */
	public static String slurp(String filename) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(filename), Charset.defaultCharset());
		
		StringBuilder builder = new StringBuilder();
		for (String line: lines) {
			builder.append(line);
			builder.append("\n");
		}
		//remove the last \n
		builder.deleteCharAt(builder.length() - 1);
		
		return builder.toString();
	}
}
