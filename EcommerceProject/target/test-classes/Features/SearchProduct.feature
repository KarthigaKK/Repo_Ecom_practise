Feature: Search and place the order for Products

Scenario: Search Experience for product search in both home and offer page

Given User is on Greencart landing page
When User searched with short name "Tom" and extracted actual name of product 
Then User searched for "Tom" short name in offer page 
And Validate product name in offer page matches with landing page


