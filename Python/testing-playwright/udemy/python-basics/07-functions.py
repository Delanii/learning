def greet(name) -> None:
    print("Hi {}".format(name))

def addfive(mynum) -> int:
    return mynum + 5

def main() -> None:
    name = "Me"

    greet(name)
    print(addfive(6))

if __name__ == "__main__":
    main()