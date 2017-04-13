# System Modules

### Author: Erik Rutledge, Vasu Kalaria

#### Description
System components for controlling the motor and water valves as well as collecting input from water sensors.

The motor and valves require pigpiod to be started before operation. This can be done by starting it on boot up.
A crontab needs to be edited (this command will create it if it does not exist already):
```
sudo crontab -e
```
Select an editor if asked to, then insert this line at the end of the file:
```
@reboot		sudo pigpiod
```
_Note: this is assuming PIGPIO is installed and available through the system path._

### API

##### Usage

Import all modules.
```
from modules import motor, sensor, valve
```


##### Motor

###### Methods
```
start(freq, direction)
```  
No return value but should be provided the frequency for the desired speed as an integer. The direction can be 1 (clockwise) or 0 (counterclockwise) but defaults to 1 if no value provided.
```
stop()
```
No return value. Stops motor control.
```
disconnect()
```
No return value. Terminates GPIO connection, only used when exiting program entirely.


##### Sensor

###### Methods
```
getWaterInTemp()
getWaterOneTemp()
getWaterTwoTemp()
getWaterOutTemp()
getProductInTemp()
getProductOutTemp()
```
Return an integer of the temperature value in F.


##### Valve

###### Methods
```
openHot()
openCold()
stop()
```
No return value and does not require parameters passed in. Does what the function name suggests.
