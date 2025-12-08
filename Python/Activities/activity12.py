# Calculate the sum of numbers
# using recursion
def sum(n):
  if n <= 1:
    return n
  else:
    return n + sum(n-1)
  
num = 10
print("The sum of numbers from 0 to 10 is: ", sum(num))
