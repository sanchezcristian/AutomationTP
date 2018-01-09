Feature: Curso de automation

Scenario Outline: Search a book

Given I enter search <search>
And I click Search button
When I sort the list results by <order>
Then The search results must be ordered by <order>

Examples:
|search 							 | order 					|
| Sailor moon tomo 7   | price_low_high |
