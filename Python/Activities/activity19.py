import pandas
from pandas import ExcelFile
from pandas import ExcelWriter

data = {
  "FirstName": ["Satvik", "Avinash", "Lahari"],
  "LastName": ["Shah", "Kati", "Rath"],
  "Email": ["satshah@exmple.com", "avinash@example.com", "lahari.rath@example.com"],
  "PhoneNumber": ["4537829158","5892184058","4528792783"]
}

df = pandas.DataFrame(data)
print(df)

writer = ExcelWriter("Details.xlsx")


df.to_excel(writer, "Sheet1",index=False)


writer.close()