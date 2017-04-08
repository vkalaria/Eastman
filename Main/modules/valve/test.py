import os
import time

import valve

valve.openCold()
time.sleep(4)
valve.openHot()
time.sleep(4)
valve.stop()

valve.openCold()
time.sleep(4)
valve.openHot()
time.sleep(2)
valve.stop()

valve.openCold()
time.sleep(4)
valve.openHot()
time.sleep(2)
valve.stop()
