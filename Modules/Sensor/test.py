import time

import temp

while (True):
     print("Water temp:        " + str(temp.read_serial_water()))
     print("Inlet powder temp: " + str(temp.read_serial_input()))
     print("Mid 1 temp:        " + str(temp.read_serial_screw_1()))
     print("Mid 2 temp:        " + str(temp.read_serial_screw_2()))
     print(" ")
     time.sleep(2)