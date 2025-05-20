class Calculator:

    num = 100

    def __init__(self, first, second):
        print("Calculator instance created.")
        self.first = first
        self.second = second

    def get_data(self):
        print("Running now.")

    def mysum(self):
        return self.first + self.second

calc = Calculator(2, 3)
calc.get_data()
print(calc.mysum())
