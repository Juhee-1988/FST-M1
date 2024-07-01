import pandas

dataframe=pandas.read_excel("sample.xlsx")

print(dataframe)

print("No. of rows and columns: ",dataframe.shape)

print("Emails: ")
print(dataframe['Email'])

print("Sorted data in ascending order based on first name: ")
print(dataframe.sort_values('FirstName'))