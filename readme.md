### Spring Boot + Docker Compose Example with MySQL and NGINX
http://localhost:8080/

https://hellokoding.com/docker-compose-with-spring-boot-mysql-nginx/


##
https://serverfault.com/questions/230012/mysql-access-denied-for-user-rootx-x-x-x

https://www.thegeekstuff.com/2016/04/docker-compose-up-stop-rm

https://devilbox.readthedocs.io/en/latest/custom-container/enable-varnish.html

'''bash
GRANT ALL privileges on test.* to 'azuser'@'192.168.0.143' identified by 'password321';
FLUSH PRIVILEGES;
GRANT ALL PRIVILEGES ON * . * TO 'azuser'@'%';

mysql -uroot --protocol=TCP --port=3306 --host=192.168.0.143 -p
mysql test -uroot  --port=3306 --host=192.168.0.143 -p
mysql test -uazuser  --port=3306 --host=192.168.0.143 -p

'''
https://blog.dgraph.io/post/building-todo-list-react-dgraph/

https://spring.io/blog/2018/11/08/spring-boot-in-a-container