listOne=list(input("Enter a sequence of comma separated values: ").split(", "))
listTwo=list(input("Enter a sequence of comma separated values: ").split(", "))

print("First List is ",listOne)
print("Second List is ",listTwo)

thirdList=[]
for num in listOne:
    if int(num) % 2 != 0:
        thirdList.append(num)
for num in listTwo:
    if int(num) % 2 == 0:
        thirdList.append(num)
print("Result List is ",thirdList)
