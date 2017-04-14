import os
import glob
import time
import sys

import motor

#import pigpio as gpio

#pi = gpio.pi()

frequency = sys.argv[1]
#direction = sys.argv[2]
#enable    = sys.argv[3]

#while (True):
    
motor.start(frequency)
