# ETIQA SCHOOL REST TEST

This applications is built using Spring Boot 2.2, Java 8, Vue.js(Vuetify) and MySQL

## NOTE
- This application is based on one to many relationship course(1) to student(m)
- Using vuetify that already integrated with material design
- Vue is not properly structured but will keep on watch for future update
- Rest API:  following start with: http://hostname/v1/api
- GET /students
- GET /students/{id}
- POST /students
- PUT /students
- DELETE /students
- GET /courses  
additional API requested which can obtain students' ID. But in vue app, the id field is not used because using other methods of filtering students using course id
- GET /courses/{id}
- POST /courses
- PUT /courses
- DELETE /courses
