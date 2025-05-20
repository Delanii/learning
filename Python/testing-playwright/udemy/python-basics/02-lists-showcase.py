values = [1, 2, "huh?", 4.5] # OK

print(values[1])

# Access value
print(values[-1])

print(values[1:3])

# Add
values.insert(3, "more")
print(values)

values.append(9)
print(values)

# Update
values[-1] = 10
print(values)

# Delete
del values[0]
print(values)