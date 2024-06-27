numbers=list(input("Enter the sequence of numbers seperated by commas: ").split(","))
sum=0
for number in numbers:
    sum+=int(number)
print(sum)