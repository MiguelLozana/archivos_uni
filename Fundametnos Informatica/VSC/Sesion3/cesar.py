carcter=ord(input("introduce un caracter:" ))
steps=int(input("Cuanto salto del cifrado: "))
respuesta=chr(carcter+steps)

vuelta_respuesta=ord(respuesta)
vuelta_caracter=chr(vuelta_respuesta)

if vuelta_caracter == vuelta_caracter:
    print("FUNCIONA")
else:
    print("NO FUNCIONA :(")

print(respuesta)


