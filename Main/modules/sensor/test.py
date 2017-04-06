import time

import sensor

while (True):
     print("Water input:    " + sensor.getWaterInTemp())
     print("Water outpus:   " + sensor.getWaterOutTemp())
     print("Product input:  " + sensor.getProductInTemp())
     print("Product output: " + sensor.getProductOutTemp())
     print(" ")
     time.sleep(2)
