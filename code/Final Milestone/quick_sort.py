#quick sort algorithm for CSC372 final project

import os
os.chdir(os.path.dirname(__file__))
import time


def getNumbers():

    numbers = []

    numbers_file = open('Numbers9.txt','r')
    numbers_file = numbers_file.readlines()

    for i in range(len(numbers_file)):
        number = int(numbers_file[i].strip('\n'))
        numbers.append(number)

    return numbers

def quick(numbers, low, high):

    if low < high:
        index = quickHelper(numbers, low, high)
        quick(numbers, low, index - 1)
        quick(numbers, index + 1, high)

def quickHelper(numbers, low, high):

    pivot = numbers[high]
    index = low - 1

    for i in range(low,high):
        if numbers[i] < pivot:
            index += 1
            temp1 = numbers[index]
            numbers[index] = numbers[i]
            numbers[i] = temp1

    temp2 = numbers[index + 1]
    numbers[index + 1] = numbers[high]
    numbers[high] = temp2

    return index + 1

def main():

    begin = int(round(time.time() * 1000))

    numbers = getNumbers()

    start = int(round(time.time() * 1000))

    quick(numbers, 0, len(numbers) - 1)

    end = int(round(time.time() * 1000))


    print('Quick Sorting Time')
    print(end-start, 'milliseconds')
    print('Run time')
    print(end-begin, 'milliseconds')


main()
