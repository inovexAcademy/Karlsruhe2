package de.inovex.academy.csd.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamGobbler extends Thread {
	private InputStream inputStream;
	private StringBuffer stringBuffer = new StringBuffer();

	public StreamGobbler(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			String line = null;
			while ((line = reader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getString() {
		return stringBuffer.toString();
	}
}
