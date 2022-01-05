# clockin_backend
This application is a first impression of a login system to track working time. 
### Targets:
1. Login page with registration possibility
2. after the login a simple website should be shown
3. on the website there will be three buttons
   1. Start time
   2. Start break
   3. End break
   4. End time
4. after click on the button the time should be saved in a database

### current status
Endpoint /hello is available to test if the application works. 
Endpoint /authentication is available and delivers a bearer if the username "foo" and password "foo" 
will be send by post. Works with postman.

### helpers
build.sh: shutdown docker-container, start them, build the application with gradle and docker

start.sh: start docker-compose

stop.sh: stop docker-compose