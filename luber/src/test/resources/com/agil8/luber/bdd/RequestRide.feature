Feature: Request a ride 
	So that I can get to distant places without driving
  As Tony
  I want to be able to request a taxi

  Tony: doesn't often use a taxi and is able-bodied

Scenario: Tony books a ride 
	Given ayrton@test.com is a driver 
	And david@test.com is an unavailable driver 
	And tony@test.com is a customer 
	Then Tony sees these drivers available 
		| email           |
		| ayrton@test.com |
		
Scenario: exclude drivers more than 5 miles away 
	Given ayrton@test.com is a driver at 51.397,-1.240 
	And david@test.com is a driver at 51.412,-1.422 
	And tony@test.com is a customer at 51.397,-1.227 travelling to 51.403,-1.323 
	When tony@test.com requests a taxi 
	Then Tony sees these drivers available 
		| email        |
		| ayrton@test.com |
		
Scenario: accept the offer 
	Given ayrton@test.com is a driver at 51.397,-1.240 
	And david@test.com is a driver at 51.412,-1.422 
	And tony@test.com is a customer at 51.397,-1.227 travelling to 51.403,-1.323 
	When tony@test.com accepts ayrton@test.com 
	Then these trips are in the system 
		|from latitude|from longitude|driver|customer|
		|51.397|-1.227|ayrton@test.com|tony@test.com|
		
		
		
		
		
		