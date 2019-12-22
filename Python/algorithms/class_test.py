class Fruit:
    __a = 1

    @classmethod
    def hello(cls):
        print("Hello World!")

    def getColor(self):
        print("Fruits are colorful!")

    def __hello(self):
        print("Secret!")


class Apple(Fruit):
    def getColor(self):
        super().getColor()
        print("Apples are red!")

    def __hello(self):
        print("Wow, you got me!")


class Orange(Fruit):
    def getColor(self):
        Fruit.hello()
        super().getColor()
        print("Oranges are orange!")
        print(self._Fruit__a)
        self._Fruit__hello()


if __name__ == '__main__':
    orange = Orange()
    orange.getColor()
    apple = Apple()
    apple._Apple__hello()
