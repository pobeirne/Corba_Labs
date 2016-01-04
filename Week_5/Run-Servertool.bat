@echo off
set PATH=%PATH%;C:\Program Files\Java\jdk1.8.0_31\bin\
servertool -ORBInitialPort 1050
 register -server HelloNamingServer -applicationName HelloNamingServer -classpath /
pause

