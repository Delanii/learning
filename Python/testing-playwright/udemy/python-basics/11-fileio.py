with open("test.txt", "w") as myfile:
    myfile.write("A short text.\nMore lines.")

with open("test.txt", "r") as again:
    print(again.read(5))

with open("test.txt", "r") as aline:
    print(aline.readline())

with open("test.txt", "r") as challenge:

    for line in challenge:
        print(challenge.readline())

with open("test.txt", "r") as tested:

    print(tested.readlines())

    for line in tested.readlines():
        print(line)

with open("test.txt", "r") as og:

    contents = og.readlines()
    reversed = contents[::-1]

    with open("test2.txt", "w") as rev:
        for item in reversed:
            rev.write(item)