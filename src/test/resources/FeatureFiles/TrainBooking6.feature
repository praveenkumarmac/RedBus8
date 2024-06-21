Feature: TrainBooking

Background: Application Launch
Given Launch the browser and appilication1 "https://www.redbus.in"

Scenario Outline: Book a train in RedBus application
When User clicks on rail
And User enters the value in from place1 "<FromPlace>"
And User enters the value in to place1 "<ToPlace>"
And User selects a data  in the Date DropDown1
And User clicks on search button1
Then Validate the bus displayed in the UI1

Examples:
|FromPlace  |ToPlace        |
|Chennai    |Visakhapatnam  |