# Spring Betting App


## Built With
* [Intellij Ultimate]
* [Spring-Boot](https://spring.io/projects/spring-boot) - Framework
* [Maven](https://maven.apache.org/) - Dependency Management
* [Hibernate](https://hibernate.org/) - Persistence provider
* [mySql](https://www.mysql.com/) - Database

## What its all about

Sending a "POST" request on /register with username and password as a parameters, saves the user into a database.
"POST" request on /login url, authentices the user so the it can access the rest of the application.

The application has a  basic filter that checks whether the user has logged in and throws an error page otherwise if someone tries to 
access the /bet/** without authenticating first.

"GET" request on /bet/getGames with 2 parameters, startDate and endDate returns Football games which are
being played in that period in JSON format. The games are fetched by GetJson class from the sport-api and mapped to a java POJO "Matches".

Users can play a ticket by sending a GET request to /bet/add with two parameters, Id of a match and a "fix",
for examle /bet/add?Id=2344&fix=x. The game will be added to a ticket.

GET request on /bet/checkTicket as it says, user can check his ticket  out and submit it by sending a get request on /bet/playTicket with
ticketAmout as a parameter. The ticket and played games are saved into a database.

The App is still in progress,
- Currently there are problems with saving the tickets to a database when there are more than 1 games.
- Game fixes will be added, currently game fixes and quotes are hardcoded.









