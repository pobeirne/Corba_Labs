@echo off
set PATH=%PATH%;C:\Java\jdk1.8.0_31\bin\
servertool -ORBInitialPort 1050
register -server HelloNamingServer -applicationName HelloNamingServer -classpath "C:\Users\pobeirne\Desktop\Week_5\HelloNamingPoaPolicy"
pause

