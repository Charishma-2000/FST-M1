Firstlist=[1,2,4,3]
Secondlist=[6,9,7,2]

print("First list: ", Firstlist)
print("Second list: ", Secondlist)

ThirdList= []

for num in Firstlist:
    if (num % 2 != 0):
        ThirdList.append(num)

for num in Secondlist:
    if (num % 2 == 0):
        ThirdList.append(num)

print("Third list: ",ThirdList)