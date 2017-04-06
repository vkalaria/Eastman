import os
import time

import valve

valve.open_cold()
time.sleep(4)
valve.open_hot()
time.sleep(4)
valve.stop()

valve.open_cold()
time.sleep(4)
valve.open_hot()
time.sleep(2)
valve.stop()

valve.open_cold()
time.sleep(4)
valve.open_hot()
time.sleep(2)
valve.stop()
