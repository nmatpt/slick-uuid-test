http://stackoverflow.com/questions/40912787/how-to-use-uuid-in-a-varchar-column-with-slick

To test:

- MySQL 5.7 instance, u:root p:root (I am using a [docker](https://hub.docker.com/_/mysql/))
- Create a database slickTest:

    mysql> create database slickTest;
    
    
- Run `sbt test`. There are 2 tests, both should pass


