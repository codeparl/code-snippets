// This program finds the highset
//common factor of two numbers
#include <iostream>
#include <string>
using namespace std;


bool isPrime(int n);
bool isPrimeRecursive(int n, int d);
int main(){


    //display message
    cout << "This program allows you to check if a given number is prime.\n";
    int num;
    string flag;
  do{

    cout << "Enter  an integer number: ";
    cin >> num;

    bool prime = isPrimeRecursive(num,2); // isPrime(num);
    //use to_string to convert int to string 
    string status  =  prime ? "is" : "is not";
    string message =  "The number "+ to_string(num) + ", you entered, "+ status +" a prime number!";
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


bool isPrime(int n){
int divisor = 2;

//so long as the divisor still < n 
   while (divisor < n){

  //check if the current divisor is divisible by n
   if(n % divisor == 0)
        return false; // n is not prime, return early 
    
    // keep incrementing divisor till is == n 
    divisor  =  divisor + 1;    
  
    }
    //we have exhausted the range between 2 and n with a remainder
    //n must be prime. 
    return true;
  
}

bool isPrimeRecursive(int n, int d){

    //this is the base-case for this function 
    //to stop calling itself
    if(d >= n) 
      return true;

    //logic for prime number 
    if(n % d == 0) 
     return false;

     //increment d each call of isPrimeRecursive(...) 
    return isPrimeRecursive(n, d + 1);
}