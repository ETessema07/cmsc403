from Tkinter import *
import random

class CustomCanvas(object):
    
    def __init__(self, height, width):
        self.__height = height
        self.__width = width
        self.master = Tk()
        self.w = Canvas(self.master, width= int(300), height= int(400), bg="white")
        self.w.pack()

    def draw_rect(self, rect_list):
        for i in rect_list:
            self.w.create_rectangle(i.get_height(), i.get_width(), i.getx(), i.gety(), outline="red")

        self.master.mainloop()

                               
    def getHeight(self):
        return self.__height
                               
    def getWidth(self):
        return self.__width
                               
    def toString(self):
        return ("the canvas has a height of: {} and a width of: {}".format(self.__height,self.__width) )


class Rectangle:
    __height = 0
    __width = 0
    __x = 0
    __y = 0

    def __init__(self, height, width, x, y):
        self.__height = height
        self.__width = width
        self.__x = x
        self.__y = y

    def get_height(self):
        return self.__height

    def get_width(self):
        return self.__width

    def getx(self):
        return self.__x

    def gety(self):
        return self.__y


obj = CustomCanvas(400, 400)
rec_obj = Rectangle(100, 50, 24, 154)
rec_obj2 = Rectangle(150, 70, 50, 120)
recList = {rec_obj, rec_obj2}
obj.draw_rect(recList)



