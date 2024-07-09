@activity1
Feature: Google Search

@smoketest
Scenario: User searches on Google website
	Given User is on Google website
	When User searches for Cheese
	Then User should see the results