import pandas
from pandas import ExcelWriter
from pandas import ExcelFile

data={
    'FirstName': ["Satvik","Avinash","Lahri"],
    'LastName': ["Shah","Kati","Rath"],
    'Email': ["satshah@example.com","avinashk@example.com","lahri.rath@example.com"],
    'PhoneNumber': ["45378291578","5892184058","4528727830"]
}

dataframe=pandas.DataFrame(data)

print(dataframe)

writer=ExcelWriter('sample.xlsx')
dataframe.to_excel(writer,'sheet1',index=False)

writer.save()