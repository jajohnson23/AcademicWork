//////////////////////////////////////////////////////////////////////////////////////////////////
//
// Filename:   TimeMain.cpp
// Date:       March 2015
// Programmer: Joellyn A Johnson, jajohnson23
// 
// Description: CSC 234 LAB 10 
//	
//	A main driver for testing the Person class
//               Theis Driver will reads in a list of names and ages and stores them in a 
//                one-dimensional array of Person objects.
//               The maximum number of names that will be entered is 100 names. 
//               After reading in the list of names and ages, sort the list of people from the 
//                youngest (lowest age) to oldest (highest age) using the Bubble Sort.  
//               Then print out the name and age for each person in the sorted list. 
//
//	Sample Output (user input is bold) :
//
//    Enter name (-1 to stop): Bart
//    Enter age of Bart: 10
//    Enter name (-1 to stop): Lisa
//    Enter age of Lisa: 8
//    Enter name (-1 to stop): Maggie
//    Enter age of Maggie: 1
//    Enter name (-1 to stop): Homer
//    Enter age of Homer: 36
//    Enter age of Marge: 34
//    Enter name (-1 to stop): -1
//
//    Name: Maggie, age: 1
//    Name: Lisa, age: 8
//    Name: Bart, age: 10
//    Name: Marge, age: 34
//    Name: Homer, age: 3
//
///////////////////////////////////////////////////////////////////////////////////////////////////

#include <iostream>
#include <string>
#include "Person.h"
#include "invalidAge.h"

using namespace std; 

//declare a double linked list of Person type
doublyLinkedList<Person> list; 
int size = 0; //with initial size 0
//Function prototype for sorting an array of Person objects
void sort(); 
//Function Prototype for printing the person.
void printPerson(string name, int age);

////////////////////////////////////////////////////////////////////////////////////////////////////
//  Function: main
//  Description: a driver to test the program function
//               It will obtain user input to fill list of names, 
//                 then sort and print the information
//               Error checking prevents invaild ages to be entered
//               Any string of characters is accepted as a valid name.
//
//  param
//    none
//
//  return
//   zero to exit program
//////////////////////////////////////////////////////////////////////////////////////////////////

int main ()
{

    int age;

    string name;

    while (true) //continue getting user input
    {
      cout << "Enter name (-1 to stop) : ";
      cin >> name;
      cout << endl;
      if (name == "-1") //break while loop and stop getting user input if -1 entered
        break;
      //code to obtainm a valid age
      bool tester = false;
      while (tester == false)
      {
        while ((cout << "Enter age of "  << name << ": ") && !(cin >> age))
        {
          cout << "Please enter a valid integer for age." << endl;
          cin.clear();
          // ignore non-numeric input:
		      cin.ignore(std::numeric_limits<streamsize>::max(), '\n') ;
        }
        try { //be sure age is reasonable positive integer
            if (age < 0 || age > 130)  //determined limit by oldest person record 124 years
              throw invalidAge();
            tester = true; //indicate valid age obtained to exit while loop
        } catch (invalidAge invalidAgeObj) {
          cout << endl << invalidAgeObj.what() << endl;
        }
      }
      cout << endl;
      //adds a person to the list with the name and age entered by user
      list.insert( Person (name, age));
      size++;
    }
    cout << endl;

    //print the user's list
    cout << "Here is your list: \n";
    list.doublyLinkedList::print();

    //create a new list and copy list to new list2
    doublyLinkedList<Person> list2;
    list2.doublyLinkedList::copyList(list);
    //print result
    cout << "I have made a copy of your list, here it is:\n";
    list2.doublyLinkedList::print();

    system("pause");
    return 0;                                         
}

////////////////////////////////////////////////////////////////////
//// Function: sort
//// Description: sortd the list of person objects by age
////
//// param:
////	none
////		
//// return:
////	none
////////////////////////////////////////////////////////////////////
//void sort()
//{
//  Person temp;
//
//  for (int k = 1; k < size; k++)
//  {
//    for (int j = 0; j < size - k; j++)
//    {
//      if (list[j].getAge() > list[j + 1].getAge())
//      {
//        temp = list[j];
//        list[j] = list[j + 1];
//        list[j + 1] = temp;
//      }
//    }
//  }
//}
//////////////////////////////////////////////////////////////////
// Function: printPerson
// Description: prints the persons name and age
//				with formatted text
//
// param:
//  n, name of person
//	a name and age of a person
//		
// return:
//	none
//////////////////////////////////////////////////////////////////
void printPerson(string n, int a)
{
		cout << "Name: " << n << ", age: " << a << endl;
}
/////////////////////////////////////////////////////////////////////////////////////////
// Function: operator<<
// Description:
//		overloads operator <<
//    outout for person = name and age
//
// Parameters:  
//  osObject an ostream object
//	rectangle, a Person object
// 
// Returns:
//	 osOnject of name and age information
//
//////////////////////////////////////////////////////////////////////////////////////// 
ostream& operator<<(ostream& osObject,  Person& p)
{
    osObject << "Name: " << p.Person::getName() << ", age: " << p.Person::getAge() << endl;      
    return osObject;
}