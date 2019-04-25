from tkinter import *
from sys import argv
import random
import rpack


class CustomCanvas:
    
    def __init__(self, height, width):
        self.__height = height
        self.__width = width
        self.master = Tk()
        self.w = Canvas(self.master, height= int(height), width= int(width))
        self.w.pack()

    def draw_rect(self, rect_list):
        for i in rect_list:
            self.w.create_rectangle(i.getx(), i.gety(), i.getx()+i.get_width(), i.gety()+i.get_height(), outline="black", fill="#00ffff")

        self.master.mainloop()




class Rectangle(object):

    def __init__(self, height, width, x, y):
        self.height = int(height)
        self.width = int(width)
        self.x = int(x)
        self.y = int(y)

    def get_height(self):
        return self.height

    def get_width(self):
        return self.width

    def getx(self):
        return self.x

    def gety(self):
        return self.y



def pack(rec_list):
    positions = rpack.pack(rec_list)

    return positions

def main():
# https://docs.python.org/3/tutorial/inputoutput.html#reading-and-writing-files

    script, file_name = argv
    canvas_size = []
    rest_file = []
    rec_list = []
    tup_list = []

    with open(file_name) as f:
        lines = f.readlines()
        canvas_size.append(lines[0].replace("\n", "").replace(",", " ").split(" "))
        lines.remove(lines[0])
        for i in lines:
            rest_file.append(i.replace("\n", "").replace(",", " ",).split(" "))
    for l in rest_file:
        tup_list.append(list(map(int, l)))

    if len(tup_list) <=16:
        tup_list.sort(key=lambda tuple: tuple[0], reverse=True) 
    else:
        tup_list.sort(key=lambda tuple: tuple[0])
    coord_list=pack(tup_list)

    for k in range(len(tup_list)):
        rec_list.append(Rectangle(tup_list[k][0], tup_list[k][1], coord_list[k][0], coord_list[k][1]))

    obj = CustomCanvas(canvas_size[0][0], canvas_size[0][1])
    obj.draw_rect(rec_list)


if __name__ == "__main__":
    main()
