package de.inovex.academy.csd.frame;

import java.util.ArrayList;
import java.util.List;

public class FrameMaker {
	
	private static final String FRAMECHAR = "*";

	public List<String> makeFrame(List<String> stringList) {
		if (null != stringList) {
			List<String> result = new ArrayList<>();
			int length = computeFrameWidth(stringList);
			String frameLine = frameLine(length);
			result.add(frameLine);
			for (String stringElement : stringList) {
				result.add(buildLineString(length, stringElement));
			}
			result.add(frameLine);
			return result;
		}
		return null;
	}

	public String buildLineString(int length, String stringElement) {
		int laengeLeerzeichen = length - stringElement.length() -2;
		StringBuffer sb = new StringBuffer();
		for (int ii = 0; ii<laengeLeerzeichen;ii++) {
			sb.append(" ");
		}
		return FRAMECHAR + stringElement +  sb.toString() + FRAMECHAR;
	}

	public int computeFrameWidth(List<String> stringList) {
		int maxLaenge = 0;
		for (String stringElement : stringList) {
			int laenge = stringElement.length();
			if (laenge > maxLaenge) maxLaenge = laenge;
		}
		return maxLaenge+2;
	}

	public String frameLine(int length) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append(FRAMECHAR);
		}
		return sb.toString();
	}
	
	

}
