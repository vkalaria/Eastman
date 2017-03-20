import os
import time

import motor

while (True):
    
    motor.motor_control(800, 10, 1)
    time.sleep(8)
    
    motor.motor_control(800, 25, 1)
    time.sleep(8)
    
    motor.motor_control(800, 50, 1)
    time.sleep(8)
    
    motor.motor_control(800, 75, 1)
    time.sleep(8)
    
    motor.motor_control(800, 90, 1)
    time.sleep(8)
    
    motor.motor_control(800, 75, 0)
    time.sleep(8)
    
    motor.motor_control(800, 90, 0)
    time.sleep(8)
    
    motor.stop()
