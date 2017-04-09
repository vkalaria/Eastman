import os
import time
import temp
import valve
import motor
import socket

#Globals
Start = 1
Auto = 1
frequency = 800
Direction = 1

def GetInfo():
	s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
	s.connect('localhost', 32415)
	Socketinfo = s.recv(1024).decode()
	s.close()
	return Socketinfo

def HeatTransfer(ScrewStart, ScrewEnd, MaterialIn, MaterialOut, WMixture, frequency):
	Xspecific = 0.2388 #Specific Heat of Xanthan Gum
	Cspecific = 1.003 #Specific Heat of Water
	MassFlow = 1368 #Flow Rate, lb/hr
	
	#Heat Equation calculations
	Qdot = (MassFlow)*(Xspecific)*(MaterialIn - MaterialOut)
	#Add initial water + new water, this is the transfer of hot water from material to water.
	FinalWaterTemp = Qdot/(MassFlow*Cspecific)

	if(ScrewEnd > ScrewEnd + FinalWaterTemp + 5):
		valve.openCold()
		time.wait(2)
		valve.stop()
	if(ScrewEnd < ScrewEnd + FinalWaterTemp - 5):
		valve.openHot()
		time.wait(2)
		valve.stop()
	
	#Read From Temp Sensors
	ScrewStart = temp.read_serial_screw_1()
	ScrewEnd = temp.read_serial_screw_2()
	MaterialIn = temp.read_serial_input()
	MaterialOut = temp.read_serial_output()
	WMixture = temp.read_serial_water()

		

	SendData = "tempStart:"
        SendData += "{:.9f}".format(MaterialIn)
        SendData += ','
        SendData += "tempEnd:"
        SendData += "{:.9f)".format(MaterialOut)
        SendData += ','
        SendData += "WaterTemp:"
        SendData += "{:.9f)".format(FinalWater)
        SendData += ','
        SendData += "speed:"
        SendData += str(frequency)
        SendData += '\n'
        SendInfo(SendData)
	return 

def SendInfo(SendData):
	#Send info to netcode
	s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
	s.connect('localhost', 32415)
	s.send(SendData.encode())
	s.close()
	return
def Main():
	#Start the program
	while(1):
		#Grab info from GUI
		GUI = GetInfo()

		if(GUI == "Start"):
			Start = 1
		if(GUI == "Stop"):
			Start = 0
		if(GUI == "Auto"):
			Auto = 1
			frequency = 800
			Direction = 1
		if(GUI == "Manual"):
			Auto = 0

		#if Start is enabled
		if(Start == 1):
			#Manual Mode Variable Setting
			if(Auto == 0):
				if(GUI == "cold+"):
					valve.openCold()
					time.sleep(2)
					valve.stop()
				if(GUI == "tap+"):
					valve.openHot()
					time.sleep(2)
					valve.stop()
				if(GUI == "motor+"):
					frequency = frequency + 5;
					motor.motorControl(frequency, Direction, Start);
				if(GUI == "motor-"):
					frequency = frequency - 5;
					motor.motorControl(frequency, Direction, Start);


			#Read From Temp Sensors
			ScrewStart = temp.read_serial_screw_1()
			ScrewEnd = temp.read_serial_screw_2()
			MaterialIn = temp.read_serial_input()
			MaterialOut = temp.read_serial_output()
			WMixture = temp.read_serial_water()

			if(Auto == 1):
				#Heat Transfer
				HeatTransfer(ScrewStart, ScrewEnd, MaterialIn, MaterialOut, WMixture, frequency)

			if(Auto == 0):
				SendData = "tempStart:"
				SendData += "{:.9f}".format(MaterialIn)
				SendData += ','
				SendData += "tempEnd:"
				SendData += "{:.9f)".format(MaterialOut)
				SendData += ','
				SendData += "WaterTemp:"
				SendData += "{:.9f)".format(WMixture)
				SendData += ','
				SendData += "speed:"
				SendData += str(frequency)
				SendData += '\n'
				SendInfo(SendData)

