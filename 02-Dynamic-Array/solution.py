#!/bin/python3

import math
import os
import random
import re
import sys

def dynamicArray(n, queries):
    seqList = [[] for _ in range(n)]
    lastAnswer = 0
    result = []
    
    for q in queries:
        query_type, x, y = q
        idx = (x ^ lastAnswer) % n
        if query_type == 1:
            seqList[idx].append(y)
        elif query_type == 2:
            val_idx = y % len(seqList[idx])
            lastAnswer = seqList[idx][val_idx]
            result.append(lastAnswer)
            
    return result

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    first_multiple_input = input().rstrip().split()

    n = int(first_multiple_input[0])
    q = int(first_multiple_input[1])

    queries = []

    for _ in range(q):
        queries.append(list(map(int, input().rstrip().split())))

    result = dynamicArray(n, queries)

    fptr.write('\n'.join(map(str, result)) + '\n')

    fptr.close()
