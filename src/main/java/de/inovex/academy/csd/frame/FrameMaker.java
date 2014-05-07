package de.inovex.academy.csd.frame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FrameMaker {

	public List<String> makeFrame(List<String> stringList) {
		if (null != stringList) {
			
			String ersterEintrag = stringList.get(0);
			int length = ersterEintrag.length() + 2;
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < length; i++) {
				sb.append("*");
			}
			return Arrays.asList(sb.toString(), "*" + ersterEintrag + "*",
					sb.toString());
		} else {
			return null;
		}
	}

}
