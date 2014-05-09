@echo off
set "JAVA_HOME=D:\Java\jdk1.7.0_05"
call mvn -DskipTests package >NUL
call java -cp target/Day4-0.0.1-SNAPSHOT.jar de.inovex.academy.csd.cut.Cut %*