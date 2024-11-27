message = """
1. bla
2. bla bla
"""

print(message)

hello = "hello"
me = "myself"

print(hello + " " + me + "\n")

user = input("Give me your user name: ")
print("\nHello " + user + "!")

userInput = input("Write your thing here: ")
print(len(userInput))

glass1 = "milk"
glass2 = "juice"

glass3 = glass1
glass1 = glass2
glass2 = glass3

print(f"\n glass1 = {glass1},\n glass2 = {glass2}")

glass1 = "milk"
glass2 = "juice"
glass1, glass2 = glass2, glass1

print(f"\n glass1 = {glass1},\n glass2 = {glass2}")
