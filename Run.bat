set myProjectpath=C:\Automation\WorkSpace\SauceDemoMavenFramework
cd %myProjectpath%
set classpath=%myProjectpath%\bin;%myProjectpath%\C:\Users\ADMIN\.m2\*
java org.testng.TestNG %myProjectpath%\testng.xml
pause