#!/usr/bin/env python

# Create a TCP server to listen for character inputs
# Then pipe the input to the Motor control Arduinos via serial
import socket, serial

arduino1 = serial.Serial('/dev/ttyUSB0')
arduino2 = serial.Serial('/dev/ttyACM0')

TCP_IP = '192.168.0.2'
TCP_PORT = 5005
BUFFER_SIZE = 20 # Normally 1024, but we want a fast response

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind((TCP_IP, TCP_PORT))
s.listen(1)

conn, addr = s.accept()
print 'Connection address:', addr
while 1:
    data = conn.recv(BUFFER_SIZE)
    if not data: break
    print "Received data:", data
    arduino1.write(data)
    arduino2.write(data)
    conn.send(data) # echo back to TCP client
conn.close()
