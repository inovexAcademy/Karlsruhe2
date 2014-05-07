package de.inovex.academy.csd.frame;

import java.util.ArrayList;
import java.util.List;

public class FrameMaker {

	public List<String> makeFrame(List<String> stringList) {
		if (null != stringList) {
			List<String> result = new ArrayList<>();
			String ersterEintrag = stringList.get(0);
			int length = ersterEintrag.length() + 2;
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < length; i++) {
				sb.append("*");
			}
			result.add(sb.toString());
			for (String stringElement : stringList) {
				result.add("*"+stringElement+"*");
			}
			result.add(sb.toString());
			return result;
		} else {
			return null;
		}
	}

}
