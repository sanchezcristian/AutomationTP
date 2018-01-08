Feature: Curso de automation

Scenario Outline: Search a book

Given I enter search <search>
When I click Search button
Then The search result must be greater than cero

Examples:
|search 							 |
| Sailor moon tomo 7   | 
