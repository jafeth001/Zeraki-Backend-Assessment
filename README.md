# Zeraki Backend Assesment
#### This project has restful APIs created to manage institutions, courses and students.
## Rest APIs End-Points
## Institution APIs
#### add (POST) : localhost:8080/institution/add
#### list all (GET) : localhost:8080/institution/all
#### delete (DELETE) : localhost:8080/institution/delete?id=
#### edit name (PUT) : localhost:8080/institution/edit?id=
#### search by name (GET) : localhost:8080/institution/search?name=
#### sort ascending by name (GET) : localhost:8080/institution/sort/asc/name

## Course APIs
#### add (POST) : localhost:8080/course/add
#### list all (GET) : localhost:8080/course/all
#### delete (DELETE) : localhost:8080/course/delete?id=
#### edit by name (PUT) : localhost:8080/course/edit?id=
#### search name (GET) : localhost:8080/course/search?name=
#### sort ascending by name (GET) : localhost:8080/course/sort/asc/name

## Student APIs
#### list all (GET) : localhost:8080/student/all
#### delete (DELETE) : localhost:8080/student/delete?id=
#### search by name (GET) : localhost:8080/student/search?name=
#### edit name and phone (PUT) : localhost:8080/student/edit?id=
#### add : localhost (POST) :8080/student/add?courseId=&instId=
#### transfer (PUT) : localhost:8080/student/transfer?stdId=&instId=
#### sort ascending by course (GET) : localhost:8080/student/sort/asc/course
#### change course : localhost (PUT) :8080/student/change-course?stdId=&courseId=
#### list 10 per page: localhost (GET) :8080/student/pagination?offset=&pageSize=10



