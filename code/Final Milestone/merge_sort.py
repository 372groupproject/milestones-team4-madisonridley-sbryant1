

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


def merge(numbers):

    if len(numbers) == 1:
        return numbers
    else:

        firstList = []
        secondList = []

        i = 0
        j = len(numbers)//2

        while i < len(numbers)//2:
            firstList.append(numbers[i])
            i+=1

        while j < len(numbers):
            secondList.append(numbers[j])
            j+=1

        firstList = merge(firstList)
        secondList = merge(secondList)

        return mergeHelper(firstList,secondList)

def mergeHelper(firstList,secondList):

    finalList = []

    while len(firstList) > 0 and len(secondList) > 0:
        if firstList[0] <= secondList[0]:
            finalList.append(firstList.pop(0))
        else:
            finalList.append(secondList.pop(0))

    while len(firstList) > 0:
        finalList.append(firstList.pop(0))

    while len(secondList) > 0:
        finalList.append(secondList.pop(0))

    return finalList



def main():

    begin = int(round(time.time() * 1000))

    numbers = getNumbers()
    sortedNumbers = []

    start = int(round(time.time() * 1000))

    sortedNumbers += merge(numbers)

    end = int(round(time.time() * 1000))

    print('Merge Sorting Time')
    print(end-start, 'milliseconds')
    print('Run time')
    print(end-begin, 'milliseconds')

main()