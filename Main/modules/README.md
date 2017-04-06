# System Modules

### Author: Erik Rutledge, Vasu Kalaria

#### Description
System components for controlling the motor and water valves as well as collecting input from water sensors.

### API

##### Usage

Import all modules.
```
from modules import motor, sensor, valve
```

##### Motor

###### Methods
  * motorControl(_freq_, _direction_, _enable_)

    No return value but should be provided the frequency for the desired speed as an integer. The direction can be 1 (clockwise) or 0 (counterclockwise) but defaults to 1 if no value provided. Enable can be 1 (true) or 0 (false) but defaults to 1 if no value provided.

##### Sensor

###### Methods
  * getWaterInTemp()
  * getWaterOneTemp()
  * getWaterTwoTemp()
  * getWaterOutTemp()
  * getProductInTemp()
  * getProductOutTemp()

    Return an integer of the temperature value in F.


##### Valve

###### Methods
  * openHot()
  * openCold()
  * stop()

  No return value and does not require parameters passed in. Does what the function name suggests.
