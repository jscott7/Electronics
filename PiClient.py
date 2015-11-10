# Read characters from stdin and send to 2 Arduinos via serial
import termios, fcntl, sys, os, serial

arduino1 = serial.Serial('/dev/ttyUSB0')
arduino2 = serial.Serial('/dev/ttyACM0')
fd = sys.stdin.fileno()

oldterm = termios.tcgetattr(fd)
newattr = termios.tcgetattr(fd)
newattr[3] = newattr[3] & ~termios.ICANON & ~termios.ECHO
termios.tcsetattr(fd, termios.TCSANOW, newattr)

oldflags = fcntl.fcntl(fd, fcntl.F_GETFL)
fcntl.fcntl(fd, fcntl.F_SETFL, oldflags | os.O_NONBLOCK)

try:
    while 1: # This is a tight loop with high CPU
        try:
            c = sys.stdin.read(1)
            # repr() : Return a string containing a printable
            #    representation of an object
            arduino1.write(c)
            arduino2.write(c)
            print "Read character from stdin", repr(c)
        except IOError: pass
finally:
    termios.tcsetattr(fd, termios.TCSAFLUSH, oldterm)
    fcntl.fcntl(fd, fcntl.F_SETFL, oldflags)
