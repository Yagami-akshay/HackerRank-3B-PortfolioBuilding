#!/bin/python3

import math
import os
import random
import re
import sys
from collections import Counter

def matchingStrings(strings, queries):
    counts = Counter(strings)
    return [counts[q] for q in queries]

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    # Read all lines from standard input, stripping whitespace
    lines = [line.strip() for line in sys.stdin if line.strip()]
    
    if lines:
        n = int(lines[0])
        strings = lines[1:n+1]
        q = int(lines[n+1])
        queries = lines[n+2:n+2+q]

        res = matchingStrings(strings, queries)

        fptr.write('\n'.join(map(str, res)) + '\n')

    fptr.close()
