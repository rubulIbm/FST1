firstList=[2,4,3,5,6]
secondList=[5,6,7,8,9]

print("First list : ",firstList)
print("Second list: ",secondList)

thirdlist=[]

for num in firstList:
    if(num%2!=0):
        thirdlist.append(num)

for num in secondList:
    if(num%2==0):
        thirdlist.append(num)       
print("Third list is : ",thirdlist)