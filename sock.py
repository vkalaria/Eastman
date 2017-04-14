#!/usr/bin/python

import socket
import time
from threading import Thread

data = [ "tempStart:200,tempEnd:100,WaterTemp:60,speed:55,coldWater:30,tempReduction:100\n" ]
data.append("tempStart:210,tempEnd:120,WaterTemp:65,speed:80,coldWater:50,tempReduction:90\n")
data.append("tempStart:205,tempEnd:110,WaterTemp:50,speed:90,coldWater:45,tempReduction:95\n")
data.append("tempStart:198,tempEnd:102,WaterTemp:55,speed:87,coldWater:100,tempReduction:96\n")

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
host = socket.gethostname()
port = 32415


s.connect((host, port))

def acceptData():
   string = ""
   try:
      while True:
         returnedData = s.recv(1024)
         string += returnedData

         if len(returnedData) == 0:
            break
         if string[len(string)-1] == '\n':
            print(string.strip())
            string = ""
   except:
      print("thread exiting")

i = 0;

thread = Thread(target = acceptData, args = ())
thread.start()

try:
   while True:
      s.send(data[i%4])
      time.sleep(10)
      i += 1
except:
   thread.join()
   print("Exiting program")
   s.close()
