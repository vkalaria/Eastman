import time

import sensor

while (True):
     #print("Water input    = " + str(sensor.getWaterInTemp()))
     print("Water output   = " + str(sensor.getWaterOneTemp()))
     #print("Product input  = " + str(sensor.getProductInTemp()))
     #print("Product output = " + str(sensor.getProductOutTemp()))
     print(" ")
     time.sleep(2)
