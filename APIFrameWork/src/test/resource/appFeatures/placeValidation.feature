Feature: Validating Place API's

@AddPlace
Scenario Outline: Verify if Place is being Successfully added using AddPlaceAPI
	Given Add place Payload with "<name>" "<language>" "<address>"
	When User calls "addPlaceAPI" with "POST" http request
	Then The API call got success with status code 200
	And "status" in the respose body is "OK"
	And "scope" in the respose body is "APP"
	And verify place_id created maps to "<name>" using "getPlaceAPI"
	
	Examples: 
	|name						|language |address|
	|ShreeramGreens |Bihari 	|Dhanori|
#	|Raj Karan			|Hindi	 	|Assam|

@DeletePlace
	Scenario: Verify if the Delete funcitonality is working
	Given DeletePlace Payload
	When User calls "deletePlaceAPI" with "POST" http request
	Then The API call got success with status code 200
	And "status" in the respose body is "OK"