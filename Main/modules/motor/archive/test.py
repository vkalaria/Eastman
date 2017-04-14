import os
import time
import sys

import motor

freq = sys.argv[1]
dirc = sys.argv[2]
enbl = sys.argv[3]

while (True):
    motor.begin(freq, dirc, enbl)
