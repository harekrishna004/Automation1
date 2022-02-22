Feature: Login to my Application

Scenario Outline: positive test validating login

Given initialize the browser with chrome
And navigate to "http://www.qaclickacademy.com/" site
And click on login link in home page to land onsecure sign in page
When user enters <username> and <password> and logs in
And close browser


Examples:
|username| password|
|hare|2342|
|champ|5366|

