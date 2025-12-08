fruits = {
    "apple" : 100,
    "banana" : 40,
    "grapes" : 200,
    "orange" : 65
}
print(fruits)
x = input("enter your choice: ")

##for fruit in fruits:
if (x in fruits):
    print(x,"is available")
else:
     print(x,"is not available")