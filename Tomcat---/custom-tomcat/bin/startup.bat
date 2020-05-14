cd ..
set "TOMCAT_HOME=%cd%"
cd bin

java -classpath "%TOMCAT_HOME%\lib\tomcat-core.jar;%TOMCAT_HOME%\lib\servlet-api.jar;%TOMCAT_HOME%\webapp\WEB-INF\classess" tomcat.Server