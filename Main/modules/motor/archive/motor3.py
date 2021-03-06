import os
import glob
import time

import pigpio as gpio

PULSE_PIN     = 17
DIRECTION_PIN = 12
ENABLE_PIN    = 13

square = [] 

square.append(gpio.pulse(1<<PULSE_PIN, 0, 110))
square.append(gpio.pulse(0, 1<<PULSE_PIN, 110))

pi = gpio.pi()

pi.set_mode(PULSE_PIN, gpio.OUTPUT)

pi.wave_add_generic (square)

wid = pi.wave_create()

if wid >= 0:
    pi.wave_send_repeat(wid)
    time.sleep(6)
    pi.wave_tx_stop()
    pi.wave_clear()
pi.stop()

