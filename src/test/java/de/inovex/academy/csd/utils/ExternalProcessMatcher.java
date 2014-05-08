package de.inovex.academy.csd.utils;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class ExternalProcessMatcher extends TypeSafeMatcher<List<String>>{
	private enum ResultType {
		STDOUT, STDERR, EXITCODE
	}

	private final Map<ResultType, String> results = new ConcurrentHashMap<>();
	private String expectedOutput;
	private ResultType resultType;
	
	public ExternalProcessMatcher(String expectedOutput, ResultType resultType) {
		this.expectedOutput = expectedOutput;
		this.resultType = resultType;
	}
	
	@Override
	protected boolean matchesSafely(List<String> command) {
		StreamGobbler errorGobbler;
		StreamGobbler outputGobbler;
		try {
			Process process = Runtime.getRuntime().exec(command.toArray(new String[]{}));
			errorGobbler = new StreamGobbler(process.getErrorStream());
			outputGobbler = new StreamGobbler(process.getInputStream());
			errorGobbler.start();
			outputGobbler.start();
			int exitValue = process.waitFor();
			errorGobbler.join();
			outputGobbler.join();
			results.put(ResultType.STDOUT, outputGobbler.getString());
			results.put(ResultType.STDERR, errorGobbler.getString());
			results.put(ResultType.EXITCODE, String.valueOf(exitValue));
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return expectedOutput.equals(results.get(resultType));
	}

	public void describeTo(Description description) {
		description.appendText("the executable should write on " + resultType.toString() + " ").appendValue(expectedOutput);
	}

	@Override
	protected void describeMismatchSafely(List<String> item,
			Description mismatchDescription) {
		mismatchDescription.appendText(" was ").appendValue(results.get(resultType));
	}
	
	public static ExternalProcessMatcher printsOnStdout(String expected) {
		return new ExternalProcessMatcher(expected, ResultType.STDOUT);
	}
	
	public static ExternalProcessMatcher printsOnStderr(String expected) {
		return new ExternalProcessMatcher(expected, ResultType.STDERR);
	}

	public static ExternalProcessMatcher hasExitCode(int code) {
		return new ExternalProcessMatcher(String.valueOf(code), ResultType.EXITCODE);
	}
	

}
