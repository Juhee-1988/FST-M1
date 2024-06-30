import pandas

dataframe=pandas.read_csv("sample.csv")

print("Full data: ")
print(dataframe)

print("Usernames: ")
print(dataframe["Usernames"])

print("Username and password of second row")
print("Username: ",dataframe["Usernames"][1]," | ","Password: ",dataframe["Passwords"][1])

print("Usernames sorted in descending order")
print(dataframe.sort_values("Usernames",ascending=False))

print("Passwords sorted in ascending order")
print(dataframe.sort_values("Passwords"))