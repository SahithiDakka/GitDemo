Feature: Search Product
Scenario: Search Experience for product search in both home and offers page
Given User is on GreenCart landing page
When User searched with Shortname "tom" and extract actual name of product
Then User search for "tom" Shortname in offers page 
And Validate product name in offers page matches with Landing page