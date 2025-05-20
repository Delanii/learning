# For loop

my_list = [2, 5, "word", [2, 5]]

for item in my_list:
    print(item)

total = 0
for number in range(1,6):
    total += number

print(total)

# While loop

boundary = 5
counter = 0

while(counter < boundary ):
    counter += 1
    print(counter, boundary)

# Or, maybe, better:
boundary = 5
counter = 0

while(True):
    counter += 1
    print(counter, boundary)

    if (counter == 5):
        break


boundary = 5
counter = 0

while(True):
    counter += 1

    if (counter == 3):
        continue

    print(counter, boundary)

    if (counter == 5):
        break