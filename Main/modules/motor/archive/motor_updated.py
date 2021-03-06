import os
import glob
import time

import RPi.GPIO as gpio

PULSE_PIN     = 11  #GPIO17
DIRECTION_PIN = 12  #GPIO18
ENABLE_PIN    = 13  #GPIO27

# Use board pin numbers
gpio.setmode(gpio.BOARD)

# Pin for pulse signal
gpio.setup(PULSE_PIN, gpio.OUT)
gpio.output(PULSE_PIN, gpio.LOW)

# Pin for direction signal
gpio.setup(DIRECTION_PIN, gpio.OUT)
gpio.output(DIRECTION_PIN, gpio.LOW)

# Pin for enable signal
gpio.setup(ENABLE_PIN, gpio.OUT)
gpio.output(ENABLE_PIN, gpio.HIGH)

def motor_clockwise():
    gpio.output(PULSE_PIN, gpio.HIGH)

def motor_stop():
    gpio.output(PULSE_PIN, gpio.LOW)
#    gpio.output(DIRECTION_PIN, gpio.LOW)
    
def motor_counter_clockwise():
    gpio.output(DIRECTION_PIN, gpio.HIGH)
    time.sleep(0.001)
    gpio.output(PULSE_PIN, gpio.HIGH)

# freq:       pulse frequency
# direction:  0 for clockwise
#             1 for counterclockwise
# enable:     set 0 to turn motor off
def motor_control(freq, direction, enable=1):
    period = 1/float(freq)
    clock  = period / float(2)

    if (enable):
        if (direction):
            motor_clockwise()
            time.sleep(clock)
            motor_stop()
        else:
            motor_counter_clockwise()
            time.sleep(clock)
            motor_stop()

        time.sleep(clock)
