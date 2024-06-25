numList=list(input("Enter a sequence of comma separated values to check if first and last element are same: ").split(", "))
print("Given list is: ",numList)
firstElement=numList[0]
lastElement=numList[-1]
if firstElement==lastElement:
    print(True)
else:
    print(False)