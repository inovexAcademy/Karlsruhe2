package de.inovex.academy.csd.frame;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FrameTest {

	private FrameMaker frameMaker;
	
	@Before
	public void init(){
		frameMaker = new FrameMaker();
	}
	
	@Test
	public void testComputeFrameWidth() {
		assertThat(frameMaker.computeFrameWidth(Arrays.asList("test")), equalTo(6));
	}
	
	@Test
	public void testFrameLine() {
		assertThat(frameMaker.frameLine(8), equalTo("********"));
	}
	
	@Test
	public void testFrame() {
		List<String> stringList = new ArrayList<>();
		stringList.add("test");
		assertThat(frameMaker.makeFrame(stringList), equalTo(Arrays.asList("******", "*test*", "******")));
		List<String> stringList2 = new ArrayList<>();
		stringList2.add("test2");
		assertThat(frameMaker.makeFrame(stringList2), equalTo(Arrays.asList("*******", "*test2*", "*******")));
		assertThat(frameMaker.makeFrame(null), equalTo(null));
		
		stringList2.add("test1");
		assertThat(frameMaker.makeFrame(stringList2), equalTo(Arrays.asList("*******", "*test2*", "*test1*", "*******")));
	}

}
