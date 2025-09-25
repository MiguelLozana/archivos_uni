num1=2**15
num2=3**12
num3=5**10

print(num1,num2,num3)
numeroMayor=num1

if num1<num2:
    numeroMayor=num2

if numeroMayor<num3:
    numeroMayor=num3


if numeroMayor==num3:
    print("5^10 =" ,numeroMayor)

if numeroMayor==num2:
    print("3^12 =" ,numeroMayor)

if numeroMayor==num1:
    print("2^15=" ,numeroMayor)


