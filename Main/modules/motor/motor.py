import time

import pigpio as gpio

PULSE_PIN     = 17
DIRECTION_PIN = 18
ENABLE_PIN    = 27

# Connect to pigpiod daemon
pi = gpio.pi()

square = []

# Pin for pulse signal
pi.set_mode(PULSE_PIN, gpio.OUTPUT)
# Pin for directional signal
pi.set_mode(DIRECTION_PIN, gpio.OUTPUT)
# Pin for enable signal
pi.set_mode(ENABLE_PIN, gpio.OUTPUT)

# Set motor direction - clockwise
def set_clockwise():
    pi.write(DIRECTION_PIN, 1)

# Set motor direction - counterclockwise
def set_c_clockwise():
    pi.write(DIRECTION_PIN, 0)

# Create square wave of period 2*clk, clk is in microsecond
def run(clk):
    square.append(gpio.pulse(1<<PULSE_PIN, 0, int(clk)))
    square.append(gpio.pulse(0, 1<<PULSE_PIN, int(clk)))

    pi.wave_add_generic(square)

    wid = pi.wave_create()
    if wid >= 0:
        pi.wave_send_repeat(wid)

# Start motor control with given fequency and direction
def start(freq, direction=1):
    period = 1/float(freq)
    clk = (1000000*period)/2

    if(direction):
        set_clockwise()
    else:
        set_c_clockwise()
        
    run(clk)

# Stop motor control
def stop():
    time.sleep(0.1)
    pi.write(ENABLE_PIN, 0)
    time.sleep(0.1)
    pi.write(PULSE_PIN, 0)
    time.sleep(0.1)
    pi.wave_tx_stop()
    pi.wave_clear()

# Disconnect pigpiod daemon
def disconnect()
    pi.stop()
    
