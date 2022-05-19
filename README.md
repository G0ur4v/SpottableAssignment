# SpottableAssignment
1. create database spottabl in mysql /any db .
2. Import csv file  data  into database for tables (clientuserinvites,Registrations).
3. Clone the repo into any Ide and build it using maven .
4. Run the application using main class: SpottableAssignmentApplication
5. For response in csv file format , hit the url in browser : http://localhost:8080/getData
6. Below are postman details .

1.postman curl for running in local :

curl --location --request GET 'http://localhost:8080/getDataJson' \
--header 'Content-Type: application/json'


Api response in Json format from postman :

{
    "usersInSpottabl": {
        "spottabl": 4,
        "flexmoney": 5
    },
    "userInvitesFromSpttabl": {
        "spottabl": 2,
        "flexmoney": 3
    },
    "userAcceptedInvite": {
        "spottabl": 4,
        "flexmoney": 4
    },
    "userInvitesFromSpottablUser": {
        "spottabl": 3,
        "flexmoney": 5
    }
}
