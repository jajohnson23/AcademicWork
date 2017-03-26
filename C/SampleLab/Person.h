//////////////////////////////////////////////////////////////////////////////////////////////
//	Program: LAB11
//	Author: Joellyn A Johnson, jajohnson23
//  Date: Spring 2015
//
//	Description: Class for Person Lab project, includes constructors, getters and setters for a person object
//               This project will implement a class Person with the following data members:
//                  •	name (string) - name of this person
//                  •	age (integer) – age of this person
//
///////////////////////////////////////////////////////////////////////////////////////////////
#include <iostream>
#include <string>
#include "doublyLinkedList.cpp"

using namespace std;

class Person
{

  friend ostream& operator<< (ostream&,  Person&); //friend function to overload operator <<

public:
  Person(); //null constructor for person class
  Person (string name, int age); //constructor with params passed
	string getName();  //gets name of person
	int getAge();  //gets person's age
  bool operator>=(const Person&) const; //Overload the operator >=
private:
	string name;
	int age;

};
//////////////////////////////////////////////////////////////////
// Function: Person
// Description: default constructor, sets values to zero or empty
//
// param:
//	none
//		
// return:
//	an Person object with default values
//////////////////////////////////////////////////////////////////
Person::Person() 
{
name =  " ";
age = 0;
}

//////////////////////////////////////////////////////////////////
// Function: Person
// Description: constructor, sets values name and age passed
//
// param:
//	n, the name of the person
//  a, the age of the person
//		
// return:
//	an Person object with passed values
//////////////////////////////////////////////////////////////////
Person::Person(string n, int a) 
{
  name =  n;
  age = a;
}
//////////////////////////////////////////////////////////////////
// Function: getName
// Description: getter for the person's name
//
// param:
//	none
//		
// return:
//	an string of the person's name
//////////////////////////////////////////////////////////////////
string Person::getName()
{
  return name;
}
//////////////////////////////////////////////////////////////////
// Function: getMAge
// Description: getter for the person's age
//
// param:
//	none
//		
// return:
//	an integer of the person's age
//////////////////////////////////////////////////////////////////
int Person::getAge()
{
  return age;
}

/////////////////////////////////////////////////////////////////////////////////////////
// Function: operator>=
// Description:
//		poverloads operator >=
//    a Person is considered greater if the age is greater
//
// Parameters:  
//	p, a Person object
// 
// Returns:
//	 true if it is greater or equal, otherwise false
//
//////////////////////////////////////////////////////////////////////////////////////// 
bool Person::operator>= 
                       (const Person& p) const
{
    return (age >= p.age);
}

