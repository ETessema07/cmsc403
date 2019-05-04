#
#
#   Ali Tayeh                           Assignment6                         CMSC-403
#
#
#

from tkinter import *
from sys import argv
import random
import rpack


class CustomCanvas:
    # A constructor that takes in height and width as parameters for later use with our canvas
    # it also sets up our canvas based on the passed in width and height
    def __init__(self, height, width):
        self.height = height
        self.width = width
        self.master = Tk()
        self.custom_canvas = Canvas(self.master, height= int(height), width= int(width))
        self.custom_canvas.pack()
    # a draw rectangle method that takes in a list of rectangles object to draw them on our canvas
    # it does so by looping through each rectangle object and use create_rectangle method to draw them
    def draw_rectangles(self, rectangle_list):
        for i in rectangle_list:
            self.custom_canvas.create_rectangle(i.getx(), i.gety(), i.getx()+i.get_width(), i.gety()+i.get_height(), outline="black", fill="#00ffff")

        self.master.mainloop()
        # keeps looping our tkinter object to constantly keep showing the canvas and its art!


# A rectangle class
class Rectangle(object):
    # Constructor that takes in height, width, x and y as arguments
    def __init__(self, height, width, x, y):
        #ensures that the passed in data are treated as integers
        self.height = int(height)
        self.width = int(width)
        self.x = int(x)
        self.y = int(y)
    # getters for getting height, width, x and y of the rectangle
    def get_height(self):
        return self.height

    def get_width(self):
        return self.width

    def getx(self):
        return self.x

    def gety(self):
        return self.y


# our pack method that takes in a list of rectangle objects
def pack(rectangle_list):
    # creates a new list that gets assigned the new x and y coordinates based on passed in rectangle list
    new_coordinates = rpack.pack(rectangle_list)
    return new_coordinates

def main():
    # python's first argument is the script name(something.py) follow by other arguments(file name)
    script_name, file_name = argv
    # if we're not given an file name then stop the program
    if len(file_name) < 1:
        exit(1)
    # canvas size has the data about our canvas size
    # rest of the file has data about our rectangle measurements from file
    # rectangle list has a list of rectangle objects
    # tuple_list has our rectangles height and width as set of tuple for the pack function to process
    canvas_size = []
    rest_of_file = []
    rectangle_list = []
    tuple_list = []

    # opens our file and parses its data
    with open(file_name) as foo:
        lines = foo.readlines()
        # splits canvas size from first line in txt based on commas, replaces them with spaces in order to split them
        # then adds it to canvas size list
        # also removes the first canvas size from our data so we can only work with rectangle measurements later on
        canvas_size.append(lines[0].replace("\n", "").replace(",", " ").split(" "))
        lines.remove(lines[0])
        # adds our measurements to rest of file list
        for i in lines:
            rest_of_file.append(i.replace("\n", "").replace(",", " ",).split(" "))
    # transforms our measurements list into a list of tuples
    for l in rest_of_file:
        tuple_list.append(list(map(int, l)))
    # a conditional that determines the need of sorting data based on height before passing it to the pack function
    # based on the file size
    if len(tuple_list) <=16:
        tuple_list.sort(key=lambda tuple: tuple[0], reverse=True)
    else:
        tuple_list.sort(key=lambda tuple: tuple[0])
    # assigns our returned non-overlapping x and y coordinates to a new list
    coordinates_list=pack(tuple_list)
    # combines our non-overlapping x and y coordinates and rectangles measurments to create rectangle objects then
    # append those object into a rectangle list
    for k in range(len(tuple_list)):
        rectangle_list.append(Rectangle(tuple_list[k][0], tuple_list[k][1], coordinates_list[k][0], coordinates_list[k][1]))
    # creates a canvas
    custom_canvas = CustomCanvas(canvas_size[0][0], canvas_size[0][1])
    # calls our draw method to draw the rectangles
    custom_canvas.draw_rectangles(rectangle_list)

# ensures main gets called when the program is run
if __name__ == "__main__":
    main()
