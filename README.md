# TAX PAYMENTS

### About
Establishment of a tax regularization system for taxpayers:
This system will allow users to make their tax payments:
* Declarant (id long, raisonSociale String, address String, email String, telephone String)
* Declaration(id long, dateDeclaration date, amountDeclaration double, idDeclarant long)
* Payment(id long, datePayment Date, amountDouble payment, idDeclaration long)

It is possible for a declarant to make several payments from the same declaration.
Choice: (Rest API or Thymeleaf)
1. Create the rest APIs for adding and listing each class only
2. Interface with thymeleaf for adding and listing each class only

Do not manage security for this mini project

### Initializing
* mvn clean
* mvn install

Bootstrap [application.properties](src/main/resources/application.properties)
* mvn spring-boot:run

### Frames
* **Home Page**
  ![Home](/src/main/resources/templates/public/img/1.png)
* **Declarant Page**
  ![Home](/src/main/resources/templates/public/img/2.png)
* **Declaration Page**
  ![Home](/src/main/resources/templates/public/img/3.png)
* **Payment Page**
  ![Home](/src/main/resources/templates/public/img/4.png)

**This is a basic Spring Boot and Thymeleaf project**