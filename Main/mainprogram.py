import os
import time
import temp
import valve
import motor

#Still looking for better way, maybe using Newton's Law of Cooling
#Not tested yet

#Temp variables
Manual = 0;
start = 200; #Not set, around what we might get, just for testing
end = 100; #Not set, around what we want for final temp, just for testing

#Start while loop for automatic mode
while (Manual = 0):
        #Setup temp variables
        #Screw temp1,2 in the system, Input is at start, Output is at end, Serial is mixture of cold/city
        screwtemp1 = temp.read_serial_screw_1()
        initial = temp.read_serial_input()
        screwtemp2 = temp.read_serial_screw_2()
        final = temp.read_serial_output()
        mixture = temp.read_serial_water()

        #Motor Control, (frequency, direction, enabled)
        motor.motor_control(800,0,1)

        #Work with temperature and opening valve
        if(final > 100 && final <= 105):
                #Do nothing
        if(final > 105):
                #open cold valve
                valve.open_cold()
                time.sleep(2)
                valve.stop()
        if(final < 100 && final >= 90):
                #Do nothing
        if(final < 90):
                #open city valve
                valve.open_hot()
                time.sleep(2)
                valve.stop()

        #Propagation for water to hit end of system
        time.sleep(4)


#Start while loop for manual mode, need variables and such, WIP.
while (Manual = 0):
        #Setup temp variables
        #Screw temp1,2 in the system, Input is at start, Output is at end, Serial is mixture of cold/city
        screwtemp1 = temp.read_serial_screw_1()
        initial = temp.read_serial_input()
        screwtemp2 = temp.read_serial_screw_2()
        final = temp.read_serial_output()
        mixture = temp.read_serial_water()

        #Motor Control, (frequency, direction, enabled)
        motor.motor_control(800,0,1)

        #Work with temperature and opening valve
        if(final > 100 && final <= 105):
                #Do nothing
        if(final > 105):
                #open cold valve
                valve.open_cold()
                time.sleep(2)
                valve.stop()
        if(final < 100 && final >= 90):
                #Do nothing
        if(final < 90):
                #open city valve
                valve.open_hot()
                time.sleep(2)
                valve.stop()

        #Propagation for water to hit end of system
        time.sleep(4)