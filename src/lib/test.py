
class Test:

    def sum(self, x, y) -> int:
        return int(x) + int(y)

    def getInputs(self) -> dict:
        value   = input()
        another = input()
        
        return { "value": value, "another": another }

if __name__ == "__main__":

    test   = Test()
    inputs = test.getInputs()
    sum    = test.sum(
        inputs["value"],
        inputs["another"]
    )

    print(f"A soma dos valores é {sum}.")