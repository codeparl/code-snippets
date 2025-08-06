import java.util.Scanner;

public class Prime {

    public static void main(String[] args) {

         //display message
    System.out.println( "This program allows you to check if a given number is prime.");
    int num;
    String flag;
    Scanner  input = new Scanner(System.in);
          do{

    System.out.print( "Enter  an integer number: ");
     num = input.nextInt();

    boolean prime = isPrimeRecursive(num,2); // isPrime(num);
    //use to_String to convert int to String 
    String status  =  prime ? "is" : "is not";
    String message =  "The number "+ num + ", you entered, "+ status +" a prime number!";
    System.out.println(message);
    System.out.print( "\nWould you like to continue (y/n): ");
     flag =  input.next().trim();
    //ensure that the user enters correct option to continue
    if(flag.equals("n") == false  && flag.equals("y") == false ){
         System.out.println( "\nYou have entered a wrong option, system exiting...\n");
         break; //stop the loop 
    }
    
  }while(!"n".equals(flag));

  input.close();
    }


public static boolean isPrime(int n){
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

public static boolean isPrimeRecursive(int n, int d){

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
    
}
