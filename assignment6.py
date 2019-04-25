from Tkinter import *
from sys import argv
import random


class CustomCanvas:
    
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


# obj = CustomCanvas(400, 400)
# rec_obj = Rectangle(100, 50, 24, 154)
# rec_obj2 = Rectangle(150, 70, 50, 120)
# recList = {rec_obj, rec_obj2}
# obj.draw_rect(recList)
def pack(rec_list):


def main():
# https://docs.python.org/3/tutorial/inputoutput.html#reading-and-writing-files

    script, file_name = argv
    file = open(file_name)
    canvas_size = []
    rest_file = []
    rec_list = []
    with open(file_name) as f:
        lines = f.readlines()
        canvas_size.append(lines[0].replace("\n", "").replace(",", " ").split(" "))
        lines.remove(lines[0])
        for i in lines:
            rest_file.append(i.replace("\n", "").replace(",", " ",).split(" "))
    obj = CustomCanvas(canvas_size[0][0], canvas_size[0][1])
    randn=random.randrange(100)
    for l in rest_file:
        rec_obj = Rectangle(l[0][:], l[0][:], 0, 0)
        rec_list.append(rec_obj)

    # rec_obj2 = Rectangle(150, 70, 50, 120)

    obj.draw_rect(rec_list)
    # print(rest_file)


if __name__ == "__main__":
    main()
