import os
import glob
import time

import csv

os.system('modprobe w1-gpio')
os.system('modprobe w1-therm')

BASE_DIR = '/sys/bus/w1/devices/'

serialNo = []
with open('serialNos.csv', 'r') as serialNos:
    rows = csv.reader(serialNos, delimiter=',')
    for row in rows:
        serialNo.append(row[0])

def read_serial_water():
    folder = (glob.glob(BASE_DIR + serialNo[0])[0]) + '/w1_slave'

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

def read_serial_input():
    folder = (glob.glob(BASE_DIR + serialNo[1])[0]) + '/w1_slave'
        
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

def read_serial_screw_1():
    folder = (glob.glob(BASE_DIR + serialNo[2])[0]) + '/w1_slave'

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

def read_serial_screw_2():
    folder = (glob.glob(BASE_DIR + serialNo[3])[0]) + '/w1_slave'

    filed = open(folder, 'r')
    lines = filed.readlines()
    filed.close()
    
    while lines[0].strip()[-3:] != 'YES':
        #time.sleep(0.2)
        lines = read_temp_raw()
    equals_pos = lines[1].find('t=')
    if equals_pos != -1:
        string = lines[1][equals_pos+2:]
        temp_c = float(string) / 1000.0
        temp_f = temp_c * 9.0 / 5.0 +32.0
        return temp_f

def read_serial_output():
    folder = (glob.glob(BASE_DIR + serialNo[4])[0]) + '/w1_slave'

    filed = open(folder, 'r')
    lines = filed.readlines()
    filed.close()
    
    while lines[0].strip()[-3:] != 'YES':
        #time.sleep(0.2)
        lines = read_temp_raw()
    equals_pos = lines[1].find('t=')
    if equals_pos != -1:
        string = lines[1][equals_pos+2:]
        temp_c = float(string) / 1000.0
        temp_f = temp_c * 9.0 / 5.0 +32.0
        return temp_f
