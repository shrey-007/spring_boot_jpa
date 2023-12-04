A simple spring boot application to connect with database mysql
all crud operations has been performed
Explaination-:

1)UserRepositry interacts with database directly, extending CrudRepository.You dont need to create methods for basic CRUD operations, they are provide by  CrudRepository itself. For medium level queries, just create abstract methods having naming convention according to springboot and it will automatically convert into query.For complex queries you just create abstract methods having query specified in @Query annotation.

2)You just need to write few line in src->main->resources->application.properties file for database configurations.


