# Zeraki Backend Assesment
#### This project has restful APIs created to manage institutions, courses and students.
## Rest APIs End-Points
## Institution APIs
#### add : localhost:8080/institution/add
#### list all : localhost:8080/institution/all
#### delete : localhost:8080/institution/delete?id=
#### edit name : localhost:8080/institution/edit?id=
#### search by name : localhost:8080/institution/search?name=
#### sort ascending by name : localhost:8080/institution/sort/asc/name

## Course APIs
#### add : localhost:8080/course/add
#### list all : localhost:8080/course/all
#### delete : localhost:8080/course/delete?id=
#### edit by name : localhost:8080/course/edit?id=
#### search name : localhost:8080/course/search?name=
#### sort ascending by name: localhost:8080/course/sort/asc/name

## Student APIs
#### list all : localhost:8080/student/all
#### delete : localhost:8080/student/delete?id=
#### search by name : localhost:8080/student/search?name=
#### edit name and phone : localhost:8080/student/edit?id=
#### add : localhost:8080/student/add?courseId=&instId=
#### transfer : localhost:8080/student/transfer?stdId=&instId=
#### sort ascending by course: localhost:8080/student/sort/asc/course
#### change course : localhost:8080/student/change-course?stdId=&courseId=
#### list 10 per page: localhost:8080/student/pagination?offset=&pageSize=10



