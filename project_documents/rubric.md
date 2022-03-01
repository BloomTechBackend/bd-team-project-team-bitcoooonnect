# Team Bitcoooonnect Project Rubric

## Background

*This captures the expectations that we have for your team during the unit.
This is how we will evaluate whether you have demonstrated these expectations.*

## Instructions

*As a team, complete this rubric (everything except for the Appendix) by
answering the questions below. Each question should usually only require one or
two sentences, so please be brief. The remainder of expectations will be
evaluated by instructors, so you don’t need to write anything in the Appendix.
We want you to see the full set of expectations for transparency’s sake.*

## Deliverables

*Provide links to the following project deliverables:*

|Deliverable                                                      |Due Date                  |Date Completed |URL                               |
|---                                                              |---                       |---            |---                               |
|Team name                                                        |Sprint 1 Module 1         | 02/07/22          |name: Bitcoooonnect                            |
|[Design Document - problem statement](design_document.md)        |Sprint 1 Module 2         | 02/08/22        | https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/blob/main/project_documents/design_document.md                                 |
|[Team Charter](team_charter.md)                                  |Sprint 1 Modeul 3         | 02/09/22              | https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/blob/main/project_documents/team_charter.md                                 |
|[Design Document](design_document.md)                            |Sprint 1 Friday by 5pm    | 02/11/22             | https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/blob/main/project_documents/design_document.md                                 |
|Project Completion (Feature Complete)                            |Sprint 3 Friday by 5pm    |               | https://main.d1cm820nfbsmxw.amplifyapp.com/ // https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect                             |
|[Team Reflection](reflection.md)                                 |Sprint 4 Wednesday by 5PM | 03/01/22              |  https://github.com/BloomTechBackend/bd-team-project-team-bitcoooonnect/blob/main/project_documents/Bitcoooonnect/reflection.md                                |
|[Accomplishment Tracking (person 1)](accomplishment_tracking.md) |Sprint 4 Wednesday by 5PM | 03/01/22              |                                  |
|[Accomplishment Tracking (person 2)](accomplishment_tracking.md) |Sprint 4 Wednesday by 5PM | 03/01/22              |                                  |
|[Accomplishment Tracking (person 3)](accomplishment_tracking.md) |Sprint 4 Wednesday by 5PM | 03/01/22              |                                  |
|Self Reflection (Evan)                        |Sprint 4 Wednesday by 5PM |               |n/a (will be submitted via Canvas - "Wrap-up" section) |
|Self Reflection (Ron)                        |Sprint 4 Wednesday by 5PM |               |n/a (will be submitted via Canvas - "Wrap-up" section) |
|Self Reflection (Juan)                        |Sprint 4 Wednesday by 5PM |               |n/a (will be submitted via Canvas - "Wrap-up" section) |

## Technical Learning Objectives

### API Design

**Design an API to meet the needs of your application.** Provide a link to the
definition for your endpoints (can be code/configuration, or can be
documentation). List one thing that your team learned about designing a good
API.

*Endpoint definition location:*  [Design Document - 6.2 Public Endpoints](design_document.md)      
*What we learned:* It is important to have your models and database tables configured correctly prior to developing API endpoints    

**Develop a service endpoint definition that uses complex inputs and outputs.**
Select one of your endpoints and list the operation’s input and output objects.
Under each, list its attributes.

*Endpoint: Update User     
*Input object(s):* UpdateUserRequest      

* emailId
* coinId
* amount

*Output object(s): UpdateUserResult     

* Map<CoinIds, Amount> coins

**Given a user story that requires a user to provide values to a service
endpoint, design a service endpoint including inputs, outputs, and errors.**
Select one of your endpoints that accepts input values from a client. List the
error cases you identified and how the service responds in each case. Provide at
most 3 error cases.

|**Endpoint:**  |   Update User                  |
|---            |---                  |
|**Error case** |**Service response** |
|     Invalid coinId          |     Throw CoinNotFoundException               |
|      Invalid amount         |       Throw InvalidAttributeException              |

**Develop a service endpoint definition that uses query parameters to determine
how results are sorted or filtered.** List at least one endpoint that allows
sorting or filtering of results. Which attribute(s) can be sorted/filtered on?

*Endpoint:*         
*Attribute(s):*  

**Determine whether a given error condition should result in a client or server
exception.** List one client exception and one server exception that your
service code throws. List one condition in which this exception is thrown.

|                       |**Exception** |**One case in which it is thrown** |
|---	                |---	       |---	                               |
|**Client exception:**  |	APIOfflineException           |	      If our API is down, this exception will be thrown upon a user sending a GET request                         |
|**Service exception:** |	InvalidAttributeException           |	User updates a coin amount with a negative number                               |

### DynamoDB Table Design

**Decompose a given set of use cases into a set of DynamoDB tables that provides
efficient data access.** List the DynamoDB tables in your project:

1. users 
2. coins

**Design a DynamoDB table key schema that allows items to be uniquely
identified.** Describe the primary key structure for your DynamoDB table with
the most interesting primary key. In a sentence or two, explain your choice of
partition/sort key(s).

1. **users** KeySchema:
   - AttributeName: "emailId"
   - AttributeType: "S"
   - KeyType: "HASH"
   - Upon users logging in via AWS Cognito, we receive a JSON Web Token (JWT) which among other information contains the users email address. We parse this web token in JS to retrieve the email address that can then be passed to our endpoints to access the **users** table

**Design the attributes of a DynamoDB table given a set of use cases.** List a
DynamoDB table with at least 3 attributes. List one relevant use case that uses
the attribute. In one sentence, describe why the attribute is included.

**Table name:** users
 
**Attributes:**

|Attribute name |(One) relevant use case |attribute purpose |
|---            |---                     |---               |
| emailId (S)           | Retrieve a users portfolio upon GET request by sending their emailId                       |  Partition key, to identify a user                |
| coins (MAP)             | User adds a new coin to their portfolio via PUT request, sending the coin Id and the amount                       | Store a users coins by Id (key) (S), and the amount of each (value) (N)                |
| timeCreated(S)              |  Keep track of how long users use out platform for                     | Store the time the user was created                 |


### DynamoDB Indexes

**Design a GSI key schema and attribute projection that optimizes queries not
supported by a provided DynamoDB table.** In one or two sentences, explain why
you created one of the GSIs that your project uses, including one use case that
uses that index.

**Table name:**
portfolio

**Table keys:**
emailId

**GSI keys:**
coinId

**Use case for GSI:**
Find users who all hold a certain coin - to gauge that coins popularity, similarities between users who own it, etc.  

**Implement functionality that uses query() to retrieve items from a provided
DynamoDB's GSI.** List one of your use cases that uses `query()` on a GSI.

**Table name:** portfolio

**Use case for `query()` on GSI:**
Find all users who hold **coinId** "Bitcoin", retrieve the **count** from the response and display as a metric on the front-end

## Soft(er) Outcomes

**Learn a new technology.** For each team member, list something new that that
team member learned:

|Team Member |Something new the team member learned |   
|---   |---                                   |
| Evan     |  How to use AWS Cognito - create user pools, connecting to front-end, JSON Web Tokens                                    |   
| Ron     |   AWS Amplify                                   |     
| Juan     |   HTML/CSS/JS                                   |

**Identify key words to research to accomplish a technical goal | Use sources
like sage and stack overflow to solve issues encountered while programming.**
Give an example of a search term that your team might have used to find an
answer to a technical question/obstacle that your team ran into. List the
resource that you found that was helpful.

**Search terms:** How to decode JSON Web Tokens     
**Helpful resource:** https://jwt.io/     

**Find material online to learn new technical topics.** List one resource that
your team found on your own that helped you on your project.

**Topic:** Configuring AWS user pools 

**Resource:**  https://www.youtube.com/watch?v=oFSU6rhFETk

**Share what was worked on yesterday, the plan for today, and any blockers as a
part of a scrum standup.** In one or two sentences, describe what your team
found to be the most useful outcome from holding daily standups.

1. Being able to discuss blockers, bugs we were working through at the time, and leaning on our varied past programming experiences to help come up with solutions.

