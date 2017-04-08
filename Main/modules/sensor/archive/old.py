device_folder_2 = glob.glob(BASE_DIR + '28-000008080ddf')[0]
device_2 = device_folder_2 + '/w1_slave'

def read_temp_1():  
    lines_1 = read_temp_raw_1()
    while lines_1[0].strip()[-3:] != 'YES':
        time.sleep(0.2)
        lines_1 = read_temp_raw()
    equals_pos = lines_1[1].find('t=')
    if equals_pos != -1:
        temp_string = lines_1[1][equals_pos+2:]
        temp_c = float(temp_string) / 1000.0
        temp_f = temp_c * 9.0 / 5.0 +32.0
        return temp_c, temp_f, device_1

def read_temp_2():
    lines_2 = read_temp_raw_2()
    while lines_2[0].strip()[-3:] != 'YES':
        time.sleep(0.2)
        lines_2 = read_temp_raw()
    equals_pos = lines_2[1].find('t=')
    if equals_pos != -1:
        temp_string = lines_2[1][equals_pos+2:]
        temp_c_2 = float(temp_string) / 1000.0
        temp_f_2 = temp_c_2 * 9.0 / 5.0 +32.0
        return temp_c_2, temp_f_2, device_2

while True:
    print(read_serial_1())
    time.sleep(0.02)
