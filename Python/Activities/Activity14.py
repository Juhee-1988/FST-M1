def fibonacci(number):
    if number <= 1:
        return number
    else:
        return(fibonacci(number-1) + fibonacci(number-2))
    
number=int(input("Enter the number of fibonacci numbers to be generated: ")) 
if number <= 0:
    print("Enter a positive number")
else:
    print("Fibonacci Series: ")
    for i in range(number):
        print(fibonacci(i))