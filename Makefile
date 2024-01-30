CLASS = ./WEB-INF/classes/
SERVELETS = $(CLASS)servelets/
all: $(SERVELETS)Accueil.class $(SERVELETS)Doctors.class \
		$(SERVELETS)Test.class $(SERVELETS)Nurses.class\
		$(SERVELETS)Newsletters.class shutdown start

JAVAC = javac

BEANS = $(CLASS)beans/

FORMS = $(CLASS)forms/

DAO = $(CLASS)dao/

LIB = ../../lib/

# servelet
$(SERVELETS)Accueil.class: $(SERVELETS)Accueil.java
	$(JAVAC) -cp '$(LIB)*;$(CLASS)' '$<'

$(SERVELETS)Doctors.class: $(SERVELETS)Doctors.java $(BEANS)Doctor.class \
		$(DAO)DaoFactory.class $(DAO)DoctorDao.class $(DAO)SpecialtyDao.class \
		$(DAO)SpecialtyDaoMariaDB.class
	$(JAVAC) -cp '$(LIB)*;$(CLASS)' '$<'

$(SERVELETS)Test.class: $(SERVELETS)Test.java $(BEANS)Auteur.class \
		$(BEANS)utilisateur.class $(FORMS)ConnectionForm.class \
		$(DAO)DaoFactory.class $(DAO)UtilisateurDao.class \
		$(DAO)DaoException.class
	$(JAVAC) -cp '$(LIB)*;$(CLASS)' '$<'

$(SERVELETS)Nurses.class: $(SERVELETS)Nurses.java $(DAO)DaoFactory.class \
		$(BEANS)Service.class $(BEANS)Nurse.class $(DAO)NurseDao.class
	$(JAVAC) -cp '$(LIB)*;$(CLASS)' '$<'
$(SERVELETS)Newsletters.class: $(SERVELETS)Newsletters.java\
		$(BEANS)Email.class $(DAO)DaoFactory.class\
		$(DAO)EmailDao.class $(BEANS)person.class
	$(JAVAC) -cp '$(LIB)*;$(CLASS)' '$<'

# bean
$(BEANS)Auteur.class: $(BEANS)Auteur.java
	$(JAVAC) '$<'
$(BEANS)BeanException.class: $(BEANS)BeanException.java
	$(JAVAC) '$<'
$(BEANS)Doctor.class: $(BEANS)Doctor.java $(BEANS)Person.class
	$(JAVAC) -cp '$(CLASS)' '$<'
$(BEANS)Utilisateur.class: $(BEANS)Utilisateur.java
	$(JAVAC) '$<'
$(BEANS)Specialty.class: $(BEANS)Specialty.java
	$(JAVAC) '$<'
$(BEANS)Service.class: $(BEANS)Service.java
	$(JAVAC) '$<'
$(BEANS)Person.class: $(BEANS)Person.java $(BEANS)BeanException.class
	$(JAVAC) -cp '$(CLASS)' '$<'
$(BEANS)Nurse.class: $(BEANS)Nurse.java $(BEANS)Person.class
	$(JAVAC) -cp '$(LIB)*;$(CLASS)' '$<'
$(BEANS)Email.class: $(BEANS)Email.java
	$(JAVAC) -cp '$(LIB)*;$(CLASS)' '$<'

$(FORMS)ConnectionForm.class: $(FORMS)ConnectionForm.java
	$(JAVAC) -cp '$(LIB)*;$(FORMS)' $< 

# dao
$(DAO)UtilisateurDao.class: $(DAO)UtilisateurDao.java
	$(JAVAC) -cp '$(CLASS)' '$<' 
$(DAO)UtilisateurDaoImpl.class: $(DAO)UtilisateurDaoImpl.java
	$(JAVAC) -cp '$(LIB)*;$(CLASS)' '$<' 
$(DAO)DaoException.class: $(DAO)DaoException.java
	$(JAVAC) -cp '$(CLASS)' '$<' 
$(DAO)DaoFactory.class: $(DAO)DaoFactory.java $(DAO)UtilisateurDaoImpl.class\
		$(DAO)DoctorDaoMariaDB.class $(DAO)ServiceDaoMariaDB.class\
		$(DAO)NurseDao.class $(DAO)NurseDaoMariaDB.class\
		$(DAO)EmailDao.class $(DAO)EmailDaoMariaDB.class
	$(JAVAC) -cp '$(CLASS)' '$<' 
$(DAO)DoctorDao.class: $(DAO)DoctorDao.java
	$(JAVAC) -cp '$(CLASS)' '$<'
$(DAO)DoctorDaoMariaDB.class: $(DAO)DoctorDaoMariaDB.java
	$(JAVAC) -cp '$(CLASS)' '$<' 
$(DAO)SpecialtyDao.class: $(DAO)SpecialtyDao.java $(BEANS)Specialty.class
	$(JAVAC) -cp '$(CLASS)' '$<' 
$(DAO)SpecialtyDaoMariaDB.class: $(DAO)SpecialtyDaoMariaDB.java\
		$(BEANS)Specialty.class $(BEANS)BeanException.class
	$(JAVAC) -cp '$(CLASS)' '$<' 
$(DAO)ServiceDao.class: $(DAO)ServiceDao.java $(BEANS)Service.class
	$(JAVAC) -cp '$(CLASS)' '$<' 
$(DAO)ServiceDaoMariaDB.class: $(DAO)ServiceDaoMariaDB.java\
		$(BEANS)Service.class $(BEANS)BeanException.class
	$(JAVAC) -cp '$(CLASS)' '$<' 
$(DAO)NurseDao.class: $(DAO)NurseDao.java $(BEANS)Nurse.class\
		$(BEANS)BeanException.class
	$(JAVAC) -cp '$(CLASS)' '$<' 
$(DAO)NurseDaoMariaDB.class: $(DAO)NurseDaoMariaDB.java $(BEANS)Nurse.class\
		$(BEANS)BeanException.class
	$(JAVAC) -cp '$(CLASS)' '$<' 
$(DAO)EmailDao.class: $(DAO)EmailDao.java $(BEANS)Email.class\
	$(BEANS)Person.class
	$(JAVAC) -cp '$(CLASS)' '$<' 
$(DAO)EmailDaoMariaDB.class: $(DAO)EmailDaoMariaDB.java\
		$(DAO)EmailDao.class $(BEANS)Email.class\
		$(DAO)DaoFactory.class $(BEANS)Person.class
	$(JAVAC) -cp '$(CLASS)' '$<' 

# bdd: $(CLASS)bdd/*.class
# $(CLASS)bdd/*.class: beans $(CLASS)bdd/*.java
# 	javac -cp '$(CLASS)' '$(CLASS)bdd/*.java' 

stop shutdown:
	powershell ../../bin/shutdown.bat
runserve serve run start:
	powershell ../../bin/startup.bat
	# CATALINA_HOME='/c/apache-tomcat-10.1.17' \
	# JAVA_HOME='/c/Program Files/ojdkbuild/java-11-openjdk-11.0.15-1' \
	# ../../bin/startup.sh

clear:
	clear
clean:
	rm $(CLASS)**/*.class
.PHONY: start shutdown clear
