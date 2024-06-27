def calculateSum(numbers):
    sum=0
    for number in numbers:
        sum+=number
    return sum
numList=[10,56,34,23]  
result=calculateSum(numList)
print("The sum of all elements is: "+str(result))  

