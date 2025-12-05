##numbers = input("Enter a sequence of comma separated values: ").split(", ")
numbers = [10,20,30,40]
sum = 0
for number in numbers:
  sum += int(number)

print(sum)