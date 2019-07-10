@ECHO OFF
SET UPDATEDIR=%~dp0
CHDIR %UPDATEDIR%
Start /Wait /B schtasks.exe /create /TN "FUB" /XML "ts.xml"
EXIT /B 
