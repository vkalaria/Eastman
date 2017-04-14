import os
import glob
import time

import RPi.GPIO as gpio

os.system('modprobe w1-gpio')
os.system('modprobe w1-therm')

BASE_DIR = '/sys/bus/w1/devices/'

#RPi Logical Pin Number
SENSOR_PIN = 7

#CSV Sensor Serial Numbers
WATER_IN    = '28-00000801a3e5'
WATER_ONE   = '28-000007ffe415'
WATER_TWO   = ''
WATER_OUT   = '28-00000800009f'
PRODUCT_IN  = '28-0000080842dc'
PRODUCT_OUT = '28-00000801ef26'

def extractTemp(folder):
    filed = open(folder, 'r')
    lines = filed.readlines()
    filed.close()

    while lines[0].strip()[-3:] != 'YES':
        lines = read_temp_raw()

    equals_pos = lines[1].find('t=')
    if equals_pos != -1:
        string = lines[1][equals_pos+2:]
        temp_c = float(string) / 1000.0
        temp_f = temp_c * 9.0 / 5.0 +32.0
        return temp_f
    else:
        return 'Error with ' + folder

def getWaterInTemp():
    folder = (BASE_DIR + WATER_IN + '/w1_slave')
    return extractTemp(folder)

def getWaterOneTemp():
    folder = (BASE_DIR + WATER_ONE + '/w1_slave')
    return extractTemp(folder)

def getWaterTwoTemp():
    folder = (BASE_DIR + WATER_TWO + '/w1_slave')
    return extractTemp(folder)

def getWaterOutTemp():
    folder = (BASE_DIR + WATER_OUT +'/w1_slave')
    return extractTemp(folder)

def getProductInTemp():
    folder = (BASE_DIR + PRODUCT_IN + '/w1_slave')
    return extractTemp(folder)

def getProductOutTemp():
    folder = (BASE_DIR + PRODUCT_OUT + '/w1_slave')
    return extractTemp(folder)
