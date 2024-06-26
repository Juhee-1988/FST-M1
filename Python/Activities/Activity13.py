def calculateSum(numbers):
    sum = 0
    for num in numbers:
        sum += int(num)
    return sum   

numList=list(input("Enter a sequence of comma separated list values: ").split(", "))
result=calculateSum(numList)
print("The sum of all the list elements is ",result)
