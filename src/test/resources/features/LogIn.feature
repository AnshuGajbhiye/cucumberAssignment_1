@ui 
Feature: E-commerce Project Web Application Health Check
  
Scenario: User is able to Open the browser, navigate to Application base URL by - http://automationpractice.com
Given User opened browser
When  User navigated to the home application url
#When User validated Application url
Then validate Application url redirected with given url
    
Scenario: Application logo visibility
Given User opened browser
And  User navigated to the home application url
# Validate after launching http://automationpractice.com
Then the application logo is displayed
#And the application logo width is 350 & height is 99

Scenario: Application product main category list validation
Given User opened browser
When  User navigated to the home application url
#After launching http://automationpractice.com
Then Validate main product categories count should be 3
And text the displayed 3 categories is as shown below

Scenario: Application Search functionality
Given User opened browser
When  User navigated to the home application url
And user enters value as "T-shirt" in search box
And click on search box
Then the search result contains "T-shirt" as text

Scenario: Application social media handles validation
Given User opened browser
When  User navigated to the home application url
When user clicks on the twitter link form footer section form landing page of the application
Then Validate the url opened on a new tab contains “seleniumfrmwrk”
And the twiiter accont name is “Selenium Framework”