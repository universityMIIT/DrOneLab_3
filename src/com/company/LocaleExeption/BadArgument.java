package com.company.LocaleExeption;
import javax.swing.JOptionPane;



public
class BadArgument extends Exception
{
	public BadArgument(String message)
	{
		super("Your argument is bad, man: " + message);
		JOptionPane.showMessageDialog( null,getMessage()  + "\n\nThe program can't continue execution.\n Please, change the input\n\n", "Incorrect input", JOptionPane.ERROR_MESSAGE);
	}

}
