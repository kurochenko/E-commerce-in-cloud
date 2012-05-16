Installation and deployment
===========================

1. To build project first get latest source code using GIT

    `git clone https://github.com/kurochenko/E-commerce-in-cloud.git`
2. in `/src/main/resources/spring/persistence-config.xml` change connection to database
3. build project using maven2 command called from project root folder (pom.xml is there)

    `mvn install`

Now you can run project on any servlet container e.g. Tomcat or in CLoudFoundry cloud. For that create an application in the cloud. From `./target` directory of projects root folder run vmc commands
    
    vmc push
Application uses approximately 300 MB of RAM. So assign at least 512 MB and connect PostgreSQL service.
