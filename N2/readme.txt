N2 : Run exercise 3 from the previous level, parameterizing all methods in a configuration file.
I used a Java Properties file, named config.properties and located in src/main/resources directory


TO COMPILE : from N2/src/main/java
javac -d bin org/TreeInTxtFile.java
TO EXECUTE
java -cp bin org.TreeInTxtFile

If it doesn't work, please verify that a copy of the file config.properties has been created in S1.05-JavaUtils\N2\src\main\java\bin

Otherwise, try again following this process :

-----------STEP ONE--------
***IF YOU'RE USING POWERSHELL
copy ../resources/config.properties bin
***IF YOU'RE USING WINDOWS CMD
copy ..\resources\config.properties bin
***IF YOU'RE USING WINDOWS CMD
cp ../resources/config.properties bin/

-----------STEP TWO--------
javac -d bin org/TreeInTxtFile.java
then
java -cp bin org.TreeInTxtFile

A FILE NAMED DIRECTORY.TXT HAS BEEN CREATED IN N2/SRC/MAIN/RESOURCES/ASSETS