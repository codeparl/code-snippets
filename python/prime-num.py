""" Write a python program function that determines if a given number 
is prime and return true|false
"""

# Function to check if a number is prime
def is_prime(number: int) -> bool:
    divisor: int  =  2
    while divisor < number:
        if (number % divisor == 0):
            return False
        divisor += 1

    return True


def checkPrime():
    number: int =  int(input('Enter a non-negative number or -1 to quit:'))

    while True:
         
         if number == -1:
            print('Quitting the program...')
            break
         
         if is_prime(number):
            print(f"{number} is a prime number.")
         else: 
          print(f"{number} is not a prime number.")
         number= int(input('Enter a non-negative number or -1 to quit:  '))



# using the function
if __name__ == "__main__":
  print('This program allows you to check prime numbers','\n')
  checkPrime()