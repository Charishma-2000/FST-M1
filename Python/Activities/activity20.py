import pandas
df = pandas.read_excel("details.xlsx")
print(df)

print("------------------------------------")
print("Number of rows and columns: ")
print(df.shape)

print("------------------------------------")
print("Data in email column: ")
print(df["Email"])

print("------------------------------------")
print("Data sorted in ascending order of fist name: ")
print(df.sort_values("FirstName"))
