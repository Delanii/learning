from oop import Calculator
# Silly Python cannot (easily) import files with numbers in their name ...

class ChildImpl(Calculator):
    num2 = 200

    def __init__(self, mynum, other):
        Calculator.__init__(self, mynum, other)

    def get_num_sum(self):
        return self.num + self.num2 + self.mysum()

calc2 = ChildImpl(6, 9)
print(calc2.get_num_sum())