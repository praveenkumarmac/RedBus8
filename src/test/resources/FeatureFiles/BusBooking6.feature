Feature: BusBooking

Background: Application Launch
Given Launch the browser and appilication "https://www.redbus.in"

Scenario Outline: Book a bus in RedBus application
When User enters the value in from place "<FromPlace>"
And User enters the value in to place "<ToPlace>"
And User selects a data  in the Date DropDown
And User clicks on search button
Then Validate the bus displayed in the UI

Examples:
|FromPlace  |ToPlace     |
|Chennai    |Vijayawada  |