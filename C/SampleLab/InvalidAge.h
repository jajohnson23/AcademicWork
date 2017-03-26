//////////////////////////////////////////////////////////////////////////
//	Program: LAB07
//	Author: Joellyn A Johnson, jajohnson23
//  Date: Spring 2015
//  Class Name: invalidSec
//  Description: Class to construct and report for error in 
//		user input for seconds
//
///////////////////////////////////////////////////////////////////////////
#ifndef INCLUDED_E3
#define INCLUDED_E3
#include <iostream>

using namespace std;

class  invalidAge
{
public:
//////////////////////////////////////////////////////////////////
// Function: invalidAge
// Description: constructor creates default message for this error
//
// param:
//	none
//		
// return:
//	none
//////////////////////////////////////////////////////////////////
invalidAge()
{
	message = "That is not a valid age.";
}
/////////////////////////////////////////////////////////////////
// Function: invalidSec
// Description: creates default message for this error
//
// param:
//	str  a string containing a message passed
//		
// return:
//	none
///////////////////////////////////////////////////////////////
invalidAge(string str)
{
	message = str;
}
//////////////////////////////////////////////////////////////
// Function: what
// Description: returns error report
//
// param:
//	none
//		
// return:
//	a message string
///////////////////////////////////////////////////////////////
string what()
{
	return message;
}

private:

string message;
}; 
#endif