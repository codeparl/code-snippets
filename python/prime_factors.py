"""
 WRITE A PYTHON SCRIPT THAT DEFINES A FUNCTION TO CALCULATE THE
 PRIME FACTORIZATION OF A NUMBER.
"""


def prime_factorization(n):
    # Start with the smallest prime number
    i = 2
    factors = []
    # Loop until i squared is greater than n
    while i * i <= n:
        if n % i:
            # If i is not a factor, increment i
            i += 1
        else:
            # If i is a factor, divide n by i and add i to the list
            n //= i
            factors.append(i)
    # If n is greater than 1, it is a prime factor
    if n > 1:
        factors.append(n)
    return factors


print(prime_factorization(1005))  # Example