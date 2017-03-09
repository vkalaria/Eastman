import os
import time

import RPi.GPIO as gpio

OPEN_COLD_PIN = 15
OPEN_HOT_PIN  = 16

OPEN_TIME     = 3

gpio.setmode(gpio.BOARD)

# Open cold/close hot valves
gpio.setup(OPEN_COLD_PIN, gpio.OUT)
# Open hot/close cold valves
gpio.setup(OPEN_HOT_PIN, gpio.OUT)

def calc_time(percentage):
    open_time = (percentage/100) * OPEN_TIME

def open_cold():
    gpio.output(OPEN_HOT_PIN, gpio.LOW)
    gpio.output(OPEN_COLD_PIN, gpio.HIGH)

def open_hot():
    gpio.output(OPEN_COLD_PIN, gpio.LOW)
    gpio.output(OPEN_HOT_PIN, gpio.HIGH)

def stop():
    gpio.output(OPEN_COLD_PIN, gpio.LOW)
    gpio.output(OPEN_HOT_PIN, gpio.LOW)