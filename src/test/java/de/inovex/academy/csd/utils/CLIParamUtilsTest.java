package de.inovex.academy.csd.utils;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class CLIParamUtilsTest {
	private String[] oddArgs = new String[]{"arg1", "arg2", "arg3"};
	private String[] eventArgs = new String[]{"arg1", "arg2", "arg3", "arg4"};

	@Test
	public void testReadMap() {
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("arg1","arg2");
		resultMap.put("arg3", "arg4");
		assertThat(CLIParamUtils.readMap(eventArgs).entrySet(), equalTo(resultMap.entrySet()));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testReadMapWithOddParameters() {
		CLIParamUtils.readMap(oddArgs);
	}
	
	@Test
	public void testReadMapWithPrefix() {
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("arg2","arg3");
		assertThat(CLIParamUtils.readMap(1, oddArgs).entrySet(), equalTo(resultMap.entrySet())); 
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testReadMapWithPrefixAndOddParameters() {
		CLIParamUtils.readMap(1, eventArgs);
	}
	
	
}
