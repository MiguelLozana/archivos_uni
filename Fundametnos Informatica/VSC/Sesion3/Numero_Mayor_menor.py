num1=int(input("Inserta el primer numero "))
num2=int(input("Inserta el segundo numero "))
num3=int(input("Inserta el tercer numero "))

numero_mayor=num1
if numero_mayor < num2:
    numero_mayor=num2
if numero_mayor < num3:
    numero_mayor=num3
print(f"El numero mayor es: {numero_mayor}")

numero_menor=num1
if numero_menor > num2:
    numero_menor=num2
if numero_menor > num3:
    numero_menor=num3
print(f"El numero menor es: {numero_menor}")