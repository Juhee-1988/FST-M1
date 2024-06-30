class Car:
    def __init__(self,manufacturer,model,make,transmission,color):
        self.manufacturer=manufacturer
        self.model=model
        self.make=make
        self.transmission=transmission
        self.color=color
    def accelerate(self):
        print(self.manufacturer +" "+self.model+" "+"has started moving")
    def stop(self):
        print(self.manufacturer +" "+self.model+" "+"has stopped moving")

car1=Car("Toyota","Etios","2016","Automatic","Grey")
car2=Car("Maruti","800","2013","Manual","red")
car3=Car("Suzuki","Swift","2018","Automatic","White")

car3.accelerate()
car3.stop()