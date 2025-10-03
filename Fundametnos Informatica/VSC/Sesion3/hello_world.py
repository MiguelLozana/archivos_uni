def main ():
    name = input("What is your name? ")
    if name == "":
        print("Your name should have some caracters: ")
    else:
        print("Your name is correct")
        print("Hello "+ name )


    age= int(input("What is your age?"))
    if age == "":
        print("Your age should have some caracters: ")
    else:
        if age > 0:
            print("Your age is correct")
            if age>=18:
                print("Eres mayor de edad")
            else:
                print("Eres menor de edad")
        else:
            print("Edad no puede ser negativa")
    


if __name__ == "__main__":
    main()