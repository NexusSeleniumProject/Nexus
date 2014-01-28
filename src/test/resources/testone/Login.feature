@login @all
Feature: Test Login

Scenario Outline: Login Success and Failure
	Given Start An Application
	When  Login In Application with login '<login>' and password= '<password>'
Examples:
	| login		| password			|
	| test.user1@test.com		| qwerty		|
	| test.user1@test2.com	| qwertyq	|