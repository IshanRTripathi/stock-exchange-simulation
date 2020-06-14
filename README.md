# stock-exchange-simulation

Paste the following in the application.properties file 

spring.jpa.hibernate.ddl-auto=update<br>
server.port=9090<br>
spring.datasource.url=jdbc:mysql://localhost:3306/db1<br>
spring.datasource.username=root<br>
spring.datasource.password=#your_password<br>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver



Paste the following in your pom.xml file inside the <dependencies> tag if not present

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
