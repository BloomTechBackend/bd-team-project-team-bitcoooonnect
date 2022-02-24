# Team Bitcoooonnect Integration Test Plan

## Product Background

Bitcoooonnect is a cryptocurrency portfolio tracker.

[Design Document](project_documents/design_document_copy.md)

### Use Cases
U1. As a Bitcoooonect customer, I want to make an account to keep track of my cryptocurrency portfolio.

U2. As a Bitcoooonect customer, I want to see my cryptocurrency holdings when I login to Bitcoooonect.

U3. As a Bitcoooonect customer, I want to add new coins to my cryptocurrency holdings on Bitcoooonect.

U4. As a Bitcoooonect customer, I want to remove coins from my cryptocurrency holdings on Bitcoooonect.

U5. As a Bitcoooonect customer, I want to update the amount of my exisiting cryptocurrency holdings.

# Automated Integration Test Plan

## Use Case: Create Account

### Test case name: handleRequest_createsNewUser_returnsNewUser

**Acceptance criteria:**

1. A user item is created in the *users* table with the users inputted email as the partition key (*emailId*)

**Endpoint(s) tested:**

1. CreateUserActivity

**GIVEN (Preconditions):**

1. A user signs up with a valid email address

**WHEN (Action(s)):**

1. Users **emailId** is passed into CreateUserActivity.handleRequest

**THEN (Verification steps):**

1. Assert that a new user item has been created with the inputted email as the partition key

**Is there any clean-up needed for this test?**

1. Remove newly created user from the users database

## Use Case: Get Account

### Test case name: handleRequest_getUser_returnsUser

**Acceptance criteria:**

1. A user is retrieved from the **users** table by their **emailId** and displays their **emailId** and **coins** 

**Endpoint(s) tested:**

1. GetUserActivity

**GIVEN (Preconditions):**

1. The user exists in the database 

**WHEN (Action(s)):**

1. Users *emailId* is passed into GetUserActivity.handleRequest

**THEN (Verification steps):**

1. Assert that the returned *emailId* is equal to the given *emailId*

## Use Case: Add Coin

### Test case name: handleRequest_addCoinToUser_returnsUpdatedUser

**Acceptance criteria:**

1. A users *coins* is updated in the *users* table with the additional coin
2. Both the coin ID and the amount is correctly reflected in the return

**Endpoint(s) tested:**

1. UpdateUserActivity

**GIVEN (Preconditions):**

1. The user exists in the database
2. A valid *coinId* and *amount*

**WHEN (Action(s)):**

1. Users *emailId*, *coinId*, and *amount* are passed into UpdateUserActivity.handleRequest

**THEN (Verification steps):**

1. Assert that the resulting *emailId* is equal to the given *emailId*
2. Assert that the resulting *coins* contains the *coinId* and *amount* values equal to the given *coinId* and *amount*


## Use Case: Remove Coin

### Test case name: handleRequest_removeCoinFromUser_returnsUpdatedUser

**Acceptance criteria:**

1. A users **coins** is updated in the **users** table with the removed coin no longer present

**Endpoint(s) tested:**

1. UpdateUserActivity

**GIVEN (Preconditions):**

1. The user exists in the database
2. The coin with **coinId** and **amount** > 0 exists in the users **coins** map

**WHEN (Action(s)):**

1. Users **emailId**, **coinId**, and **amount** of 0 are passed into UpdateUserActivity.handleRequest

**THEN (Verification steps):**

1. Assert that the resulting **emailId** is equal to the given **emailId**
2. Assert that the resulting **coins** does not contain the removed **coinId**


## Use Case: Update Coin Amount

### Test case name: handleRequest_updateCoinAmount_returnsUpdatedUser

**Acceptance criteria:**

1. A users **coins** is updated in the **users** table with **coinId**'s updated amount

**Endpoint(s) tested:**

1. UpdateUserActivity

**GIVEN (Preconditions):**

1. The user exists in the database
2. The coin with **coinId** and any **amount** exists in the users **coins** map

**WHEN (Action(s)):**

1. Users **emailId**, **coinId**, and **amount** are passed into UpdateUserActivity.handleRequest

**THEN (Verification steps):**

1. Assert that the resulting **emailId** is equal to the given **emailId**
2. Assert that the resulting **coins** contains the updated **amount** of the correct **coinId**


# Manual Front-end Test Plan

*List the key manual test cases that you will perform to verify the full
end-to-end functionality of your project. Your integration tests will verify
that your service is working properly, but you will also need to ensure that
your web pages integrate with them properly. Use your judgment about which cases
to cover in your manual tests, as they’re much more costly to execute. But you
should cover the key operations that your customers will use the application
for.*

*The goal should be that any one of your team members could take this list of
Preconditions, Actions and Verification Steps and run all of these manual tests,
then report any bugs that are observed.*

## Use Case:* [use case name]*

### **Manual Test Case: *[description of case being tested]***

**GIVEN (Preconditions):**

1. *(List the conditions that must be true for the test case to take place.
These may include seed data and/or manual steps to perform during the test—be
clear which is which)*

**WHEN (Action(s)):**

1. *(List the steps that we’re actually testing to verify that they work
correctly)*

**THEN (Verification steps):**

1. *(List the steps to verify that the expected behavior actually happens,
include any relevant invariants here as well. These can be steps to view other
pages and/or inspect data directly in the database. Try to make the steps to
execute the test as straightforward/simple as possible to save time.)*
