# Teknolojiler

    1.[Java](www.java.com)
    2.[Spring Boot] (https://spring.io/projects/spring-boot)
    3.[Maven] (https://maven.apache.org/)
    4.[H2](https://www.h2database.com/html/main.html)
    5.[Hibernate](https://hibernate.org/)

# Yapılan araçlar

    1.[Github](www.github.com)
    2.[Git](https://git-scm.com/)
    3.[Postman](https://www.postman.com/)
    4.[IntelliJ IDEA](https://www.jetbrains.com/idea/)

# Neler yapılmıştır?

    1.Spring Boot Projesi oluşturuldu.
    2.Hibernate ve H2 veritabanı kullanılarak bir veritabanı oluşturuldu.
    3.Repository, Service, Controller katmanları oluşturuldu.
    4.Github üzerinde bir repository oluşturuldu.
    5. ReadMe.md dosyası oluşturuldu.

# API Dokümantasyonu

## User

    1.[List](http://localhost:8081/api/users)
    2.[Create](http://localhost:8081/api/user/save)
    3.[RoleCreate](http://localhost:8081/api/role/user/)
    4.[AddToRole](http://localhost:8081/api/role/addtouser)
    5.[Find](http://localhost:8081/api/user/1)
    6.[Update](http://localhost:8081/api/update/user/1)
    7.[Delete](http://localhost:8081/api/delete/user/1)

## Question

    1.[List](http://localhost:8081/api/questions)
    2.[Create](http://localhost:8081/api/question/{teacherId}/save)
    3.[Find](http://localhost:8081/api/question/1)
    4.[Update](http://localhost:8081/api/update/question/1)
    5.[ListByTeacher](http://localhost:8081/api/teacher/{teacherId}/questions)
    6.[ListByStudent](http://localhost:8081/api/question/student/{studentId})

## Answer

    1.[ListByStudent](http://localhost:8081/api/answer/{studentId})
    2.[Create](http://localhost:8081/api/answer/{studentId}/save/{questionId})
