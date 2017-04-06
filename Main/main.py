import os
import time

# from modules import motor, sensor, valve

WATER_INPUT_TEMP    = 40
WATER_OUTPUT_TEMP   = 55

PRODUCT_INPUT_TEMP  = 175
PRODUCT_OUTPUT_TEMP = 170

SCREW_SPEED         = 200

PERCENTAGE_COLD     = 87

def getWaterInTemp():
    return str(WATER_INPUT_TEMP)

def getWaterOutTemp():
    return str(WATER_OUTPUT_TEMP)

def getWaterTempDiff():
    return str(WATER_OUTPUT_TEMP - WATER_INPUT_TEMP)

def getProductInTemp():
    return str(PRODUCT_INPUT_TEMP)

def getProductOutTemp():
    return str(PRODUCT_OUTPUT_TEMP)

def getProductTempDiff():
    return str(PRODUCT_INPUT_TEMP - PRODUCT_OUTPUT_TEMP)

def getScrewSpeed():
    return str(SCREW_SPEED)

def getPercentageCold():
    return str(PERCENTAGE_COLD)

def getPercentageHot():
    return str(100 - PERCENTAGE_COLD)
