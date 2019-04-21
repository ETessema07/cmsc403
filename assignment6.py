from Tkinter import *
class CustomCanvas:
    __height=0
    __width=0
    def __init__(self, height, width):
        self.__height=height
        self.__width=width
    def getHeight(self):
        return self.__height
    def getWidth(self):
        return self.__width
    def toString(self):
        return ("the canvas has a height of: {} and a width of: {}".format(self.__height,self.__width) )


obj = CustomCanvas(500,500)
master = Tk()

w = Canvas(master, width= int(obj.getWidth()), height= int(obj.getHeight()), bg="blue")
#c = w.create_rectangle(50, 25, 150, 75, fill="red")

w.pack()




master.mainloop()

print(obj.getWidth())
