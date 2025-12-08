import pandas

df= pandas.read_csv('./Credentials.csv')
print("completed date: ")
print(df)

print("------------------------------------")
print("Only username column: ")
print(df["Usernames"])

print("------------------------------------")
print("Username and password of 2nd row: ")
print(df["Usernames"][1], df["Passwords"][1])

print("------------------------------------")
print("Username in ascending order: ")
print(df.sort_values("Usernames"))

print("------------------------------------")
print("Password in descending order: ")
res=df.sort_values("Passwords", ascending=False)
print(res)
