package org.shinomin.menjin.exception;

@SuppressWarnings("serial")
public class ValidationException extends Exception
{
	public ValidationException()
	{
		super();
	}

	public ValidationException(String message)
	{
		super(message);
	}
}
