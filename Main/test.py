import os
import time

import main

print("Water input      = " + main.getWaterInTemp())
print("Water output     = " + main.getWaterOutTemp())
print("Difference       = " + main.getWaterTempDiff())
print(" ")
print("Product input    = " + main.getProductInTemp())
print("Product output   = " + main.getProductOutTemp())
print("Difference       = " + main.getProductTempDiff())
print(" ")
print("Screw speed      = " + main.getScrewSpeed())
print("Percentage cold  = " + main.getPercentageCold())
print("Percentage hot   = " + main.getPercentageHot())
