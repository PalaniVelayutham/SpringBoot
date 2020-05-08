# Getting Started

Dependencies:

spring-boot-starter-web
spring-boot-starter
spring-boot-starter-security
spring-boot-maven-plugin



Run:
   Dev & UAT  :  mvn spring-boot:run
 
   Production :  mvn spring-boot:run -P prod


End Points(Dev & UAT):

	Url: localhost:8080/api/getproductdetails
	User Name : productuser
	Password : productpassword

	Url: localhost:8080/api/getconfigdetails
	User Name : configuser
	Password : configpassword


End Points(Production):

	Url: localhost:8080/api/getproductdetails
	User Name : user@2020
	Password : user@2020

	Url: localhost:8080/api/getconfigdetails
	User Name : admin@2020
	Password : admin@2020