import os
import time

import pigpio as gpio

OPEN_HOT_PIN  = 14
OPEN_COLD_PIN = 15

OPEN_TIME     = 3

pi = gpio.pi()

# Open cold/close hot valves
pi.set_mode(OPEN_COLD_PIN, gpio.OUTPUT)
# Open hot/close cold valves
pi.set_mode(OPEN_HOT_PIN, gpio.OUTPUT)

def calcTime(percentage):
    open_time = (percentage/100) * OPEN_TIME

def openHot():
    pi.write(OPEN_HOT_PIN, 1)
    pi.write(OPEN_COLD_PIN, 0)
    
def openCold():
    pi.write(OPEN_HOT_PIN, 0)
    pi.write(OPEN_COLD_PIN, 1)

def stop():
    pi.write(OPEN_HOT_PIN, 0)
    pi.write(OPEN_COLD_PIN, 0)
