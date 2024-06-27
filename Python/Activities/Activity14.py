def fibonacci(number):
    if number<= 1:
        return number
    else:
        return(fibonacci(number-1)+fibonacci(number-2))
nterms=int(input("Enter a Numbers: "))
if nterms<=0:
    print("please eneter a positive number")
else:
    print("print fibonacco sequence: ") 
    for i in range(nterms):
        print(fibonacci(i))
       