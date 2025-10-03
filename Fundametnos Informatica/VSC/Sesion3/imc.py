def main():
    peso=float(input("Introduce tu peso: "))
    altura=float(input("introduce tu altura: "))
    if (peso <=0) and (altura <= 0):
        print("El peso y la altura ha de ser mayor de 0")
    else:
        imc=peso/(altura*altura)
        print(f"Tu imc es: {imc}")

    smoker_test = (input("If you are smoker press: A "))
    if smoker_test =="A":
        print("smoker")
    else:
        print("No smoker")


main()