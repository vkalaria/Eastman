import os
import glob
import time
import sys

os.system("sudo pigpiod")
import pigpio as gpio

PULSE_PIN     = 17
DIRECTION_PIN = 18
ENABLE_PIN    = 27

square = []
pi = gpio.pi()

# Pin for pulse signal
pi.set_mode(PULSE_PIN, gpio.OUTPUT)
# Pin for directional signal
pi.set_mode(DIRECTION_PIN, gpio.OUTPUT)
# Pin for enable signal
pi.set_mode(ENABLE_PIN, gpio.OUTPUT)
#pi.write(ENABLE_PIN, 1)

# Creates Square wave of period 2*clk, clk is in microsecond
def motor_run(clk):
    square.append(gpio.pulse(1<<PULSE_PIN, 0, clk))
    square.append(gpio.pulse(0, 1<<PULSE_PIN, clk))

    pi.wave_add_generic (square)

    wid = pi.wave_create()
    if wid >= 0:
        pi.wave_send_repeat(wid)
        time.sleep(10)
        pi.wave_tx_stop()
        pi.wave_clear()
    pi.stop()

def motor_stop():
    time.sleep(0.1)
    pi.write(ENABLE_PIN, 0)
    time.sleep(0.1)
    pi.write(PULSE_PIN, 0)
    time.sleep(0.1)
    pi.wave_tx_stop()
    pi.wave_clear()
    pi.stop()

def motor_clockwise():
    pi.write(DIRECTION_PIN, 1)

def motor_c_clockwise():
    pi.write(DIRECTION_PIN, 0)

def motorControl(freq, direction=1, enable=1):
    period = 1/float(freq)
    clk = (1000000*period)/2

    if(enable):
        if(direction):
            motor_clockwise()
            motor_run(clk)
            pi.stop()
        else:
            motor_c_clockwise()
            motor_run(clk)
            pi.stop()
    else:
        motor_stop()
