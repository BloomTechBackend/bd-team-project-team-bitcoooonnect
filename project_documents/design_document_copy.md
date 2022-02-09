# Team Bitcoooonnect Design Document

## Bitcoooonnect Design

## 1. Problem Statement

It's hard to track cryptocurrencies that you own, because they're on different centralized exchanges or stored in different wallets.

## 2. Top Questions to Resolve in Review

1. How to set up a login framework and which framework to use.
2. How to integrate Coinbase and CoinGecko API.
3. Which frontend framework to use.

## 3. Use Cases

U1. As a Bitcoooonect customer, I want to see my cryptocurrency holdings when I login to Bitcoooonect.

U2. As a Bitcoooonect customer, I want to add new coins to my cryptocurrency holdings on Bitcoooonect.
    
U3. As a Bitcoooonect customer, I want to remove coins from my cryptocurrency holdings on Bitcoooonect.

U4. As a Bitcoooonect customer, I want to update the amount of my exisiting cryptocurrency holdings.

## 4. Project Scope

### 4.1. In Scope

Viewing and managing their current cryptocurrency holdings. This includes seeing the cryptocurrencies that they hold, the amount,
and the price($USD). Customers can update their portfolio to reflect their actual holdings across all exchanges.

### 4.2. Out of Scope

* There are a vast amount of centralized exchanges that users can be storing their crypto on. As a result integrating all these APIs to provide real time holding updates would be useful but is currently out of scope.

* Trading cryptocurrencies directly on our platform is a feature that is out of scope.

* Real time prices updates will not be supported. In order for users to view prices they will need to make a new GET request. The prices that we show are limited to Coingecko's API terms, therefore users might not be able to make many GET requests for the most up to date prices. 

# 5. Proposed Architecture Overview

*Describe broadly how you are proposing to solve for the requirements you
described in Section 2.*

*This may include class diagram(s) showing what components you are planning to
build.*

*You should argue why this architecture (organization of components) is
reasonable. That is, why it represents a good data flow and a good separation of
concerns. Where applicable, argue why this architecture satisfies the stated
requirements.*

# 6. API

## 6.1. Public Models

*Define the data models your service will expose in its responses via your
*`-Model`* package. These will be equivalent to the *`PlaylistModel`* and
*`SongModel`* from the Unit 3 project.*

## 6.2. *First Endpoint*

*Describe the behavior of the first endpoint you will build into your service
API. This should include what data it requires, what data it returns, and how it
will handle any known failure cases. You should also include a sequence diagram
showing how a user interaction goes from user to website to service to database,
and back. This first endpoint can serve as a template for subsequent endpoints.
(If there is a significant difference on a subsequent endpoint, review that with
your team before building it!)*

*(You should have a separate section for each of the endpoints you are expecting
to build...)*

## 6.3 *Second Endpoint*

*(repeat, but you can use shorthand here, indicating what is different, likely
primarily the data in/out and error conditions. If the sequence diagram is
nearly identical, you can say in a few words how it is the same/different from
the first endpoint)*

# 7. Tables

*Define the DynamoDB tables you will need for the data your service will use. It
may be helpful to first think of what objects your service will need, then
translate that to a table structure, like with the *`Playlist` POJO* versus the
`playlists` table in the Unit 3 project.*

# 8. Pages

*Include mock-ups of the web pages you expect to build. These can be as
sophisticated as mockups/wireframes using drawing software, or as simple as
hand-drawn pictures that represent the key customer-facing components of the
pages. It should be clear what the interactions will be on the page, especially
where customers enter and submit data. You may want to accompany the mockups
with some description of behaviors of the page (e.g. “When customer submits the
submit-dog-photo button, the customer is sent to the doggie detail page”)*
