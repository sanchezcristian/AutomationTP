Feature: Curso de automation

Scenario Outline: Search a book

Given I enter search <search>
And I click Search button
And I sort the list results by <order>
When I click on the first element
Then The desctiption screen should be displayed


Examples:
|search 							 | order 					| 
| Sailor moon tomo 7   | price_low_high |	

