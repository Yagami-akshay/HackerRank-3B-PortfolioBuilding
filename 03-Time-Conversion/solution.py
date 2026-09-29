#!/bin/python3

import math
import os
import random
import re
import sys

def timeConversion(s):
    period = s[-2:]
    hours = int(s[:2])
    rest = s[2:-2]
    
    if period == "AM":
        if hours == 12:
            hours = 0
    else:
        if hours != 12:
            hours += 12
            
    return f"{hours:02d}{rest}"

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = timeConversion(s)

    fptr.write(result + '\n')

    fptr.close()
