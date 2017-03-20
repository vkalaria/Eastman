import os
import glob
import time

import RPi.GPIO as gpio

PULSE_PIN     = 11
DIRECTION_PIN = 12
ENABLE_PIN    = 13

# Use board pin numbers
gpio.setmode(gpio.BOARD)

# Pin for pulse signal
gpio.setup(PULSE_PIN, gpio.OUT)

# Pin for direction signal
gpio.setup(DIRECTION_PIN, gpio.OUT)
gpio.output(DIRECTION_PIN, gpio.LOW)

# Pin for enable signal
gpio.setup(ENABLE_PIN, gpio.OUT)
gpio.output(ENABLE_PIN, gpio.HIGH)

def motor_clockwise():
    gpio.output(DIRECTION_PIN, gpio.LOW)

def motor_stop():
    gpio.output(PULSE_PIN, gpio.LOW)
    gpio.output(DIRECTION_PIN, gpio.LOW)
    
def motor_counter_clockwise():
    gpio.output(DIRECTION_PIN, gpio.HIGH)
    
def motor_control(freq, duty, direction, enable=1):
    
    if (enable):
        if (direction):          
            motor_clockwise()
            p = gpio.PWM(PULSE_PIN, freq)
            p.start(duty)
        else:
            motor_counter_clockwise()
            p = gpio.PWM(PULSE_PIN, freq)
            p.start(duty)
        
    p.stop()
    GPIO.cleanup()
  
