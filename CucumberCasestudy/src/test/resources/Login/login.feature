Feature: Compose and send email to other account in system
Scenario: User is able to login and send email
Given the user is registered user
When Enter valid Name "<user>"
And Enter Valid Password "<password>"
And Click on submit button
And User Clicks on Compose
And user enters send to 
And user enters suubject
And user enters message 
And user click on Send button
Then I should see message sent

Examples:
|user    |password|
|chethu  |chethu123|




