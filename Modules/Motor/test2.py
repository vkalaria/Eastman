import os
import glob
import time
import sys

import motor2

import pigpio as gpio

pi = gpio.pi()

frequency = sys.argv[1]
direction = sys.argv[2]
enable    = sys.argv[3]

#while (True):
    
motor2.motor_control(frequency, direction, enable)
