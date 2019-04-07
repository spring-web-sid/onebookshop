package com.onebookshop.util;

import java.util.ArrayList;
import java.util.List;

public class GroovyHelperClass extends Exception{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private final List<String> errorMessages;

	/**
	 * @param message
	 * @param errorMessages
	 */
	public GroovyHelperClass(final String message, final List<String> errorMessages)
	{
		super(message);
		this.errorMessages = errorMessages;
	}

	/**
	 * @param errorMessages
	 */
	public GroovyHelperClass(final List<String> errorMessages)
	{
		this.errorMessages = errorMessages;
	}

	/**
	 * @return
	 */
	public List<String> getErrorMessages()
	{
		return errorMessages;
	}

	public static void main(String args[]) {
		List error = new ArrayList<>();
		error.add("error.........");
		error.add("more error............");
		try {
			throw new GroovyHelperClass("error occurred", error);
		} catch (GroovyHelperClass e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() +"::"+e.getErrorMessages());
		}
	}
}

