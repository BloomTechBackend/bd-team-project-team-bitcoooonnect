# Week 1
### Goals:
* Get to know the team
* Get started on planning the project

### Activity: 
* create team repo
* create team slack account
* organized first meeting
* create flow chart and problem statement with team
* explored different cryptocurrency APIs
* update documents to reflect new team name

### Important Docs, Commits, or Code Reviews:
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/commit/4d5e70f752b811702cd87f62f92a73601cdd2c15
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/commit/25d5edab855bb13565475df33a6834c7b28ca716
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/commit/f9f07c23b88d57e5575019074a9894dc85f1b628

### Things learned:
* I have a great team that I can depend on.
* There are many cryptocurrency APIs.

# Week 2
### Goals:
* Have operational lambda functions for Coin
* Plan how to do a cron job within aws for coin periodic price updates

### Activity:   

* Added lambda functions for Coin

* Created coin and coinDao classes
* Built GetCoinActivity
  * CreateCoinRequest
  * CreateCoinResponse
* Built UpdateCoinActivity
  * UpdateCoinRequest
  * UpdateCoinResponse
* Dagger dependency stuff
  * DaoModule
  * ServiceComponent
  * UpdateCoinActivityProvider
  * GetCoinActivityProvider
* Built model converter for responses
  * Model Converter
* Add batch load to GetCoinActivity
* Add batch save to UpdateCoinActivity
* Seed database with coins / cloudformation
* Create a script to call cloudformation and seed that database in one call 
  for both PC and MAC.
* create coingecko API client
* create coinmarketcap API client

### Important Docs, Commits, or Code Reviews:
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/commit/57eb310b7ff263e060ff75af6d679834c22f5728
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/commit/e3811fa1d134e7ed562180540ed4c2c2e2f063df
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/commit/602123ca9edd8c077354c12a07799b3d6e077549
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/commit/bdd7474fba5d5e23dcc0c09a9dc93200119e3627
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/commit/5ad078ce7feb3fcbffa35a21ef1560dc003f40cc
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/commit/a920604be3a605bb19f93e6423dc31c60321d4fc
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/commit/a9c1b4dd01181cd7eace83cde4f28faeb3e74c94
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/commit/fea038b74924a99a58fb1f1d54555f66f0caf194
### Things learned:
* How to build an API client
* How to build a script
* How to batch load and batch save to dynamodb

# Week 3
### Goals:
* Finish frontend
* set up aws Cognito for better auth flow.
* Set up amplify to host our website.
* Add “price”, and “value” to the response of Get User.
* Implementation of cron job with cloudwatch events.
* Help finish frontend with Vue.js framework.


### Important Docs, Commits, or Code Reviews:
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/commit/f588d0d87f387ab79596ddc7ecbafb40848ab03e
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/commit/2dd33b059c97839732fe5dd70cc15ee1575923f8
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/commit/5d66338b38dee5d29ca6633883a12cd1d0c3476b
### Things learned:
* Cognito
* Amplify
* Cloudwatch events

# Week 4
### Goals:
Put the finishing touches on the project
Get ready for the presentation.
### Activity:
* Frontend finishing touches
  * added a spinning loader for when you load the page for the first time, and 
    when you update a single coin.
* Practice presentation
### Important Docs, Commits, or Code Reviews:
* https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/commit/ee009021502d134aa8bf978a0b7eb2eac8c490d0
###Things learned:

