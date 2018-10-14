package com.company;

import com.company.LocaleExeption.BadArgument;

import javax.print.DocFlavor;
import java.util.ArrayList;

public
class CArray implements Array
{
	private static final int              alphabetPower = 100;
	private static final int              charsOffset   = 65;
	private static       int              bytesLentgh   = 100;
	private              ArrayList <Byte> bits;
	private              long             decimalNumber;
	private              byte             arrayLentgh;
	private              boolean          maxDigit;
	private              byte             radix;
	
	public
	CArray( )
	{
		bits = new ArrayList <Byte>( 100 );
		decimalNumber = 0;
		arrayLentgh = 0;
		maxDigit = false;
		radix = 1;
		zeroing();
	}
	
	public
	CArray( long initValue, byte radix )
	{
		bits = new ArrayList <>( 100 );
		decimalNumber = initValue;
		this.radix = radix;
		try
		{
			if ( radix < 1 )
			{ throw new BadArgument( "radix must be in range [1," + alphabetPower + "]. " + "Radix has set on [1]." ); }
		}
		catch ( BadArgument e )
		{
			this.radix = 1;
		}
		try
		{
			if ( radix > alphabetPower )
			{
				throw new BadArgument( "radix must be in range [1: " + alphabetPower + "]. " + "Radix has set on [" + alphabetPower + "].");
			}
		}catch ( BadArgument e )
		{
			this.radix = alphabetPower;
		}
		spreadByBits( initValue, radix );
	}
	
	@Override
	public
	void setNumber( )
	{
	
	}
	
	@Override
	public
	void print( )
	{
	
	}
	
	@Override
	public
	long additionOfBitRepresent( )
	{
		long t =1;
		this.decimalNumber = decimalNumber;
		return t;
	}
	
	@Override
	public
	Byte getBit( )
	{
		return null;
	}
	
	@Override
	public
	Array addition( )
	{
		return null;
	}
	
	@Override
	public
	void zeroing( )
	{
		for ( Byte i : bits )
		{ i = 0; }
	}
	
	@Override
	public
	byte chekDigitNumber( long pi_num, byte pi_bit )
	{
		byte didgitNumber = (byte ) (( 0 == pi_num) ? 1 : 0);
		while (  0 != pi_num)
		{
			didgitNumber++;
			pi_num /= radix;
		}
		
		arrayLentgh = didgitNumber;
		return didgitNumber;
	}
	
	@Override
	public
	long chekSign( long pi_num )
	{
		long chekDigit = pi_num;
		
		if ( chekDigit < 0 )
			this.maxDigit = true;
		else
			this.maxDigit = false;
		
		if ( maxDigit )
			chekDigit *= -1;
		
		//Возвращение модуля от числа
		return chekDigit;
	}
	
	@Override
	public
	void spreadByBits( long initValue, byte radix )
	{
		decimalNumber = initValue;
		this.radix = radix;
		try
		{
			if ( radix < 1 )
			{ throw new BadArgument( "radix must be in range [1," + alphabetPower + "]. " + "Radix has set on [1]." ); }
		}
		catch ( BadArgument e )
		{
			this.radix = 1;
		}
		try
		{
			if ( radix > alphabetPower )
			{
				throw new BadArgument( "radix must be in range [1: " + alphabetPower + "]. " + "Radix has set on [" + alphabetPower + "].");
			}
		}catch ( BadArgument e )
		{
			this.radix = alphabetPower;
		}
		long verifyingNumber =  chekSign(decimalNumber);
		byte digitNumber = chekDigitNumber(this.decimalNumber, this.radix);
		zeroing();
		
		if ( digitNumber > 0 )
		{
			long remainDivision = 0;
			for ( int i = 0; i < digitNumber && verifyingNumber > 0; i++ )
			{
				remainDivision = verifyingNumber / radix;
				bits.set( i, (byte) (verifyingNumber - remainDivision * radix));
				verifyingNumber = remainDivision;
			}
		}
	}
}
