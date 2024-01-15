all: servelets shutdown start

servelets: WEB-INF/classes/servelets/*.class
WEB-INF/classes/servelets/*.class: dao beans forms \
	WEB-INF/classes/servelets/*.java 
	javac -classpath '../../lib/*;WEB-INF/classes/' \
		'WEB-INF/classes/servelets/*.java' 

beans: WEB-INF/classes/beans/*.class
WEB-INF/classes/beans/*.class: WEB-INF/classes/beans/*.java
	javac 'WEB-INF/classes/beans/*.java' 

forms: WEB-INF/classes/forms/*.class
WEB-INF/classes/forms/*.class: WEB-INF/classes/forms/*.java
	javac -classpath '../../lib/*;WEB-INF/classes/forms/' \
		'WEB-INF/classes/forms/*.java' 

# bdd: WEB-INF/classes/bdd/*.class
# WEB-INF/classes/bdd/*.class: beans WEB-INF/classes/bdd/*.java
# 	javac -classpath 'WEB-INF/classes/' 'WEB-INF/classes/bdd/*.java' 

dao: WEB-INF/classes/dao/*.class
WEB-INF/classes/dao/*.class: beans WEB-INF/classes/dao/*.java
	javac -classpath 'WEB-INF/classes/' 'WEB-INF/classes/dao/*.java' 

shutdown:
	powershell ../../bin/shutdown.bat
start:
	powershell ../../bin/startup.bat
	# CATALINA_HOME='/c/apache-tomcat-10.1.17' \
	# JAVA_HOME='/c/Program Files/ojdkbuild/java-11-openjdk-11.0.15-1' \
	# ../../bin/startup.sh

clear:
	clear
.PHONY: start shutdown clear
