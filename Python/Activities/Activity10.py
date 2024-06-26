num_tuple=tuple(input("Enter a sequence of comma separated tuple values: ").split(", "))
print("Given tuple is: ",num_tuple)
print("Values divisible by 5: ")
for num in num_tuple:
    if int(num) % 5 == 0:
        print(num)