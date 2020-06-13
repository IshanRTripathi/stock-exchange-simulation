# stock-exchange-simulation

Paste the following in the application.properties file 

spring.jpa.hibernate.ddl-auto=update
server.port=9090
spring.datasource.url=jdbc:mysql://localhost:3306/db1
spring.datasource.username=root
spring.datasource.password=#your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver



Paste the following in your pom.xml file inside the <dependencies> tag

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
