# Evan Pollak - Team Bitcoooonnect Accomplishment Tracking

## Week 1

**Goals:**
* Create class diagram
* Work on design document
* Work on endpoint documentation

**Activity:**
* Created class diagram
* Created database models
* Worked on design document
* Worked on team charter
* CoinGecko API research

**Important Docs, Commits, or Code Reviews**:
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/blob/main/project_documents/design_document_copy.md
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/blob/main/project_documents/team_charter.md
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/blob/main/project_documents/diagrams/BitcooooonectCD.puml
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/commit/f6f18884e2302475b832a66a63c766da21be4180
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/commit/c264203955294ac181b13100f814a5c92c82d67d
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/commit/7016320cadf5ff61e928a3ce00775837d4194c68


**Things learned:**
* How CoinGecko API works
* RapidAPI
* Plant UML stuff

## Week 2

**Goals:**
* Build out backend to handle our 3 activities (CreateUser, UpdateUser, GetUser)
* Have Lambda functions for our endpoints functional (happy case)
* Implement dagger for DI

**Activity:**
* Setup Trello board
* Setup repo for development
* Created **user** and **userDao** classes
* Built **CreateUserActivity**
  * **CreateUserRequest**
  * **CreateUserResponse**
* Built **UpdateUserActivity**
  * **UpdateUserRequest**
  * **UpdateUserResponse**
* Built **GetUserActivity**
  * **GetUserRequest**
  * **GetUserResponse**
* Dagger dependency stuff
  * **DaoModule**
  * **ServiceComponent**
  * **CreateUserActivityProvider**
  * **UpdateUserActivityProvider**
  * **GetUserActivityProvider**
* Built model converter for responses
  * **Model Converter**

**Important Docs, Commits, or Code Reviews**:
* https://trello.com/b/irYzaHbw/bitcoooonnect
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/commit/a8cbc539dfbd5c1bee44201fed0538e0bc5eb389
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/commit/ddfe14ccbcfd1032e99dbba52e4e6d6bc7314a04
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/commit/eabe0695d84fbdf358fb57dbef256106914df9d8
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/commit/2b5cf2c9f83803d85968de793d8f57f8f2037627

**Things learned:**
* How to import/find necessary dependencies for our build.gradle using maven
* Importing a library .jar to get a dependency
* API clients using java, OKHTTP library, auth tokens, etc.

## Week 3

**Goals:**
* Integration test plan
* Add exception handling for our endpoints
* Figure out user authentication
* Help team build out front end
* Configure API Gateway
* MVP by end of friday

**Activity:**
* Changed code to user user authentication token instead of email
* Changed code back to users email from Cognito
* Exception for if coin doesn't exist in our database
  * **CoinNotFoundException**
* Exception for if user doesn't exist in our database, invalid login info
  * **InvalidAttributeExeption**
* Updated **users** to use email passed in from Cognito as partition key
* Updated json maps for endpoints in API Gateway
* Wrote integration test plans
* Helped Ron with getting external API connected to our database with cloudformation
* AWS Cognito configuration

**Important Docs, Commits, or Code Reviews**:
* https://trello.com/b/irYzaHbw/bitcoooonnect
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/blob/main/project_documents/integration_test_plan.md
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/commit/c5cd087aa6c8a02a2832377afdc5173d6179c89a
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/commit/d9c45e39315978eaec4b64f2bba40c11fe6d1267
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/commit/c5cd087aa6c8a02a2832377afdc5173d6179c89a
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/commit/45c25aa1c7033cd85e0463f0dc7f7eda37d9cbac
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/commit/f77002b1d98ff18fe07ef83af43457718fd57ac0

**Things learned:**
* How AWS Cognito works
* JSON web tokens
* Vue.js
* local storage stuff with java script
* Cloudwatch / event bridge to automatically run lambda functions

## Week 4

**Goals:**
* Finalize documentation
* Build presentation with team for Wens.
* Present presentation
**Activity:**
* Updated rubric to reflect latest accomplishments
* Wrote Team reflection
* Built our presentation slides with team
* Created diagram to show the high level view of our whole project

**Important Docs, Commits, or Code Reviews**:
* https://docs.google.com/presentation/d/1NRiZEdGX8bDpcwL6sjqzFS_jAgB8Xtr-Q6oPrKk8pL0/edit?usp=sharing
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/blob/main/project_documents/Bitcoooonnect/reflection.md
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/blob/main/project_documents/rubric.md
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/commit/0a487275efeab0c19a1c14f2cf9fffedd658d6d9

**Things learned:**