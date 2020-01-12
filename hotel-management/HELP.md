# hotel-management
Case of study with Spring Boot, MariaDB and JOOQ.

## important:
In this case, if you want the code to work you must explicitly exclude a dependency integrated in spring-boot-starter-data-rest as explained below:
```
<dependency>
	<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-data-rest</artifactId>
		<exclusions>
			<exclusion>
				<groupId>org.hibernate.validator</groupId>
				<artifactId>hibernate-validator</artifactId>
			</exclusion>
		</exclusions>
</dependency>
```
