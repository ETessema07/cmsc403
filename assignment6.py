from Tkinter import *


class CustomCanvas:
    __height=0
    __width=0
    def __init__(self, height, width):
        self.__height=height
        self.__width=width
        master = Tk()
        w = Canvas(master, width= int(height), height= int(width), bg="black")
        w.pack()
        master.mainloop()
    def getHeight(self):
        return self.__height
    def getWidth(self):
        return self.__width
    def toString(self):
        return ("the canvas has a height of: {} and a width of: {}".format(self.__height,self.__width) )


class Rectangle:
    __height=0
    __width=0
    __x=0
    __y=0
    
    def __init__(height,width,x,y):
        self.__height=height
        self.__width=width
        self.__x=x
        self.__y=y


