Feature: Guess the word

  # The first example has two steps
  Scenario: Maker starts a game
  	Given login
    When  Read from properties file
	Then  Quit the driver
    
    