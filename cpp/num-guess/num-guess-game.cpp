//use iostream, cstdlib, ctime, string
#include <iostream> 
#include  <cstdlib>
#include <ctime>
#include <string>

using namespace std;

void guessNumber(int start, int range);
int main(){

    //run guess game 
    guessNumber(1,5);


    return 0;
}


void guessNumber(int start, int range){

//init random seed 
  srand(time(0));
   
//obtain random number between
int randomNum   =  rand() % range + start;

//declare variables 
int guess = 0;
int count = 0;

//display game info 
string message = "Welcome to number guess game!\n";
message += " This game allows to guess the next number to be printed\n";

cout << message;

do {
//prompt the user
cout << "Enter your guess: " << endl;
//use cin  to obtain the guess from user
cin >> guess;
count++;
/*
    ensure that the user enters a number between 
    start and range
*/

if(guess > randomNum )
cout << "Your guess is too high, try again  " << start << " and " << range << endl;
else if(guess < randomNum)
cout << "Your guess is too low, try again  " << start << " and " << range << endl;
else 
cout << "congrats, you have guessed the number!" << " in " << count << " attempts" <<  endl;

}while(guess  !=  randomNum );
}