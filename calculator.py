num1=int(input("enter first number:"))
opr=input("enter operator:")
num2=int(input("enter second number:"))
if opr=='+':
    print("sum=",num1+num2)
elif opr=='-':
    print("sub=",num1-num2)
elif opr=='*':
    print("mul=",num1*num2)
elif opr=='/':
    print("div=",num1/num2)
elif opr=='%':
    print("modulo=",num1%num2)
else:
    print("enter valid inputs:")
