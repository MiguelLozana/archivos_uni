cadena1=(input("Inserta la primera cadena  "))
cadena2=(input("Inserta la segunda cadena "))
cadena3=(input("Inserta la tercera cadena "))

cadena_mas_larga=cadena1
if len(cadena_mas_larga)<len(cadena2):
    cadena_mas_larga=cadena2

if len(cadena_mas_larga)<len(cadena3):
    cadena_mas_larga=cadena3

print(f"la cadena mas larga es: {cadena_mas_larga}")