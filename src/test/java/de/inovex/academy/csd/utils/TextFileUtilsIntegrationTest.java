package de.inovex.academy.csd.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TextFileUtilsIntegrationTest {
	private static final List<String> lines = Arrays.asList(new String[] {
			"line1",
			"line2",
			"line3"
	});
	private Path file;

	@Before
	public void createTempFile() throws IOException {
		file = Files.createTempFile(null,null);
		Files.write(file, lines, Charset.defaultCharset(), StandardOpenOption.CREATE);
	}
	
	@Test
	public void testSlurp() throws IOException {
		String content = TextFileUtils.slurp(file.toString());
		assertThat(content, equalTo("line1\nline2\nline3"));
	}
}
