@echo off
set PATH=%PATH%;C:\Program Files\Java\jdk1.8.0_31\bin\
idlj -fall HelloWorldName.idl
idlj -fallTie HelloWorldName.idl
pause