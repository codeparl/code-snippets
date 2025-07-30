// This program finds the highset
//common factor of two numbers
#include <iostream>
#include <string>
using namespace std;


int hcf(int a,int b);
int main(){


    //display message
    cout << "This program allows you to find hcf of two number you enter.\n";
    int num1, num2;
    string flag;
  do{

    cout << "Enter first number: ";
    cin >> num1;

    cout << "Enter second number: ";
    cin >> num2;

    int factor =  hcf(num1,num2);
    //use to_string to convert int to string 
    string message =  "The hcf of "+ to_string(num1) + " and " + to_string(num2) +  " is " + to_string(factor);
    cout << message << endl;
    cout << "\nWould you like to continue (y/n): ";
    cin >> flag;
    //ensure that the user enters correct option to continue
    if(flag != "n" && flag != "y"  ){
         cout << "\nYou have entered a wrong option, system exiting...\n";
         break; //stop the loop 
    }
    
  }while(flag != "n");


    return 0;

}


int hcf(int a,int b){

    //determine the biggest 
    
    if(b > a){
    //and swap if necessary
        int temp = a;
        a =  b;
        b =  temp;
    }

    //so long as b != 0, keep finding the
    //remainder of a and b 
    while(b != 0){
        //cache the value of b
        int remainder =  b;
        //store the remainder into b
            b =  a % b; 
        // assign previous value of b to a
        a  =  remainder;
    }

    //now a has the highest common factor
    return a;
}