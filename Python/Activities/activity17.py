import pandas

data ={ 
    "Usernames": ["admin","charles","Deku"],
    "Passwords": ["password","Charl13","AllMight"]
}

df=pandas.DataFrame(data)
print(df)

df.to_csv("Credentials.csv", index=False)