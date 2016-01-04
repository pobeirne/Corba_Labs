@echo off
set PATH=%PATH%;C:\Java\jdk1.8.0_31\bin\
start orbd -ORBInitialPort 1050 -ORBInitialHost localhost
pause
