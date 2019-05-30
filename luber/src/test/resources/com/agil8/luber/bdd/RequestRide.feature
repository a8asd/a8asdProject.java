Feature: Request a ride 
	So that I can get to distant places without driving
  As Tony
  I want to be able to request a taxi
  
  Tony: doesn't often use a taxi and is able-bodied

Scenario: Tony books a ride 
	Given ayrton@test.com is a driver 
	And david@test.com is an unavailable driver 
	And tony@test.com is a customer 
	When Tony requests a taxi 
	Then Tony sees these drivers available 
		| email    |
		| ayrton@test.com |
		
Scenario: exclude drivers more than 5 miles away 
	Given ayrton@test.com is a driver at 51.397928, -1.240943 
	And david@test.com is a driver at 51.404116, -1.292150
	And tony@test.com is a customer at 51.397576, -1.227461 
	When Tony requests a taxi 
	Then Tony sees these drivers available 
		| email    |
		| ayrton@test.com |
	