package com.company;

public
interface Array
{
	void setNumber( );
	void print( );
	long additionOfBitRepresent( );
	
	Byte getBit( );
	Array addition();
	
	// for locale using (protrcted)
	void zeroing( );
	byte chekDigitNumber( long pi_num, byte pi_bit );
	long chekSign( long pi_num );
	void spreadByBits( long pi_initValue, byte pi_radix );
}



