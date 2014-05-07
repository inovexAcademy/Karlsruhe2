package de.inovex.academy.csd.frame;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class FrameTest {

	@Test
	public void testFrame() {
		List<String> stringList = new ArrayList<>();
		stringList.add("test");
		FrameMaker frameMaker = new FrameMaker();
		assertThat(frameMaker.makeFrame(stringList), equalTo(Arrays.asList("******", "*test*", "******")));
		List<String> stringList2 = new ArrayList<>();
		stringList2.add("test2");
		assertThat(frameMaker.makeFrame(stringList2), equalTo(Arrays.asList("*******", "*test2*", "*******")));
		assertThat(frameMaker.makeFrame(null), equalTo(null));
		
		stringList2.add("test1");
		assertThat(frameMaker.makeFrame(stringList2), equalTo(Arrays.asList("*******", "*test2*", "*test1*", "*******")));
	}

}
