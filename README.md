Stone Paper Scissors Game Microservice

This is a Spring Boot microservice that implements the game of Stone Paper Scissors. The microservice allows Player 1 to choose their move (stone, paper, or scissors)
either as a path variable in a GET request or as a JSON object in a POST request. The microservice generates a random move for Player 2 and determines the winner 
based on the game's rules.

* Usage
The microservice has a Swagger UI that provides a graphical interface for testing the API. 
-localhost:8080/v2/api-docs
-localhost:8080/swagger-ui.html

* GET Request
To make a GET request, use the following endpoint:
"/game/play/{choice}"
Replace {Choice} with your move choice: stone, paper, or scissors.

Example request:
GET http://localhost:8080/game/play/stone
Example response:
"""You choose: stone
CPU choose: scissors
Result: You win"""

* POST Request
To make a POST request, use the following endpoint:
"/game/play/"
{
    "p1Choice": "stone"
}
Example response:
"""You choose: stone
CPU choose: scissors
Result: You win"""

*Logging and Exception Handling:
The microservice uses the SLF4J logging framework to log messages to the console. 
When an invalid input is detected, the microservice throws an InvalidInputException with a message indicating the invalid input. 
The exception is caught by the microservice's exception handler, which returns an error response with a message indicating the error. 
The error message is also logged to the console.
