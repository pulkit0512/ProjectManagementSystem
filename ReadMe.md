# Problem Statement

Create a project management application (like Trello).

A project management application (like Trello) is where you can manage your project by tracking smaller tasks.


The app contains multiple boards to signify different projects

Each board contains different lists to signify sub-project

Each list contain different cards signifying smaller tasks

Each card can be assigned to a user or may remain unassigned

## Requirements

User: Each user should have a userId, name, email.

Board: Each board should have a id, name, privacy (PUBLIC/PRIVATE), url, members, lists

List: Each list should have a id, name and cards

Card: Each card should have a id, name, description, assigned user

1) We should be able to create/delete boards, add/remove people from the members list and modify attributes. Deleting a board should delete all lists inside it.
2) We should be able to create/delete lists and modify attributes. Deleting a list should delete all cards inside it.
3) We should be able to create/delete cards, assign/unassign a member to the card and modify attributes
4) We should also be able to move cards across lists in the same board
5) Ability to show all boards, a single board, a single list and a single card
6) Default privacy should be public
7) Cards should be unassigned by default
8) Ids should be auto-generated for board/list/card
9) URLs should get created based on the id

## Input

You can create a few users in your main method. No need to take it as input.

There will be different types of input:

BOARD CREATE

BOARD <name/privacy>

BOARD <ADD_MEMBER/REMOVE_MEMBER>

BOARD DELETE

LIST CREATE

LIST

LIST DELETE

CARD CREATE

CARD <name/description>

CARD ASSIGN

CARD UNASSIGN

CARD MOVE

CARD DELETE

SHOW

SHOW BOARD

SHOW LIST

SHOW CARD

If you want you create these in the main method without taking user input.

## Output

CREATE operations should print the id after creation

SHOW should print all the boards with all the lists inside them and all the cards inside all the lists (including all the attributes)

SHOW <BOARD/LIST> should print that specific entity and everything inside it (including all the attributes)

SHOW CARD should print all the attributes of the card

You can use any format to print these. Printing in json is not compulsory.

## Sample Input

SHOW

BOARD CREATE work@tech

SHOW BOARD 5da1583ec25d2a7e246b0375

SHOW

BOARD 5da1583ec25d2a7e246b0375 name workat.tech

BOARD 5da1583ec25d2a7e246b0375 privacy PRIVATE

SHOW BOARD 5da1583ec25d2a7e246b0375

BOARD CREATE workat

SHOW

BOARD 5da1583ec25d2a7e246b0375 ADD_MEMBER user1

BOARD 5da1583ec25d2a7e246b0375 ADD_MEMBER user2

BOARD 5da1583ec25d2a7e246b0375 ADD_MEMBER user3

BOARD 5da1583ec25d2a7e246b0375 REMOVE_MEMBER user2

SHOW BOARD 5da1583ec25d2a7e246b0375

BOARD DELETE 5da1586caaaad00d9b2d7aa6

SHOW BOARD 5da1586caaaad00d9b2d7aa6

SHOW

LIST CREATE 5da1583ec25d2a7e246b0375 Mock Interviews

SHOW LIST 5da1583547c78c15a1408df2

LIST 5da1583547c78c15a1408df2 name Mock Interviews - Applied

SHOW LIST 5da1583547c78c15a1408df2

LIST CREATE 5da1583ec25d2a7e246b0375 Mock Interviews - Scheduled

SHOW BOARD 5da1583ec25d2a7e246b0375

CARD CREATE 5da1583547c78c15a1408df2 abcd@gmail.com

CARD CREATE 5da1583547c78c15a1408df2 abcda@gmail.com

SHOW LIST 5da1583547c78c15a1408df2

CARD 5da1583547c78c15a14kj78g name abcde@gmail.com

CARD 5da1583547c78c15a14kj78g description At 7PM

SHOW LIST 5da1583547c78c15a1408df2

CARD 5da1583547c78c15a14kjsd8 ASSIGN gaurav@workat.tech

SHOW CARD 5da1583547c78c15a14kjsd8

CARD 5da1583547c78c15a14kjsd8 MOVE 5da1583547c78c15a143hj34

SHOW LIST 5da1583547c78c15a1408df2

SHOW LIST 5da1583547c78c15a143hj34

CARD 5da1583547c78c15a14kjsd8 UNASSIGN

SHOW CARD 5da1583547c78c15a14kjsd8

SHOW

## Sample Output

No boards

Created board: 5da1583ec25d2a7e246b0375

{"id": "5da1583ec25d2a7e246b0375", "name": "work@tech", "privacy": "PUBLIC"}

[{"id": "5da1583ec25d2a7e246b0375", "name": "work@tech", "privacy": "PUBLIC"}]

{"id": "5da1583ec25d2a7e246b0375", "name": "workat.tech", "privacy": "PRIVATE"}

Created board: 5da1586caaaad00d9b2d7aa6

[{"id": "5da1583ec25d2a7e246b0375", "name": "workat.tech", "privacy": "PRIVATE"}, {"id": "5da1586caaaad00d9b2d7aa6","name": "workat", "privacy": "PUBLIC"}]

{"id": "5da1583ec25d2a7e246b0375", "name": "workat.tech", "privacy": "PRIVATE", "members": [{"id": "user1", "name":"Gaurav Chandak", "email": "gaurav@workat.tech"}, {"id": "user3", "name": "Sagar Jain", "email":"sagar@workat.tech"}]}

Board 5da1586caaaad00d9b2d7aa6 does not exist

[{"id": "5da1583ec25d2a7e246b0375", "name": "workat.tech", "privacy": "PRIVATE", "members": [{"id": "user1", "name":"Gaurav Chandak", "email": "gaurav@workat.tech"}, {"id": "user3", "name": "Sagar Jain", "email":"sagar@workat.tech"}]}]

Created list: 5da1583547c78c15a1408df2

{"id": "5da1583547c78c15a1408df2", "name": "Mock Interviews"}

{"id": "5da1583547c78c15a1408df2", "name": "Mock Interviews - Applied"}

Created list: 5da1583547c78c15a143hj34

{"id": "5da1583ec25d2a7e246b0375", "name": "workat.tech", "privacy": "PRIVATE", "lists"": [{"id":"5da1583547c78c15a1408df2", "name": "Mock Interviews - Applied"}, {"id": "5da1583547c78c15a143hj34", "name": "MockInterviews - Scheduled"}] "members": [{"id": "user1", "name": "Gaurav Chandak", "email": "gaurav@workat.tech"},

{"id": "user3", "name": "Sagar Jain", "email": "sagar@workat.tech"}]}

Created card: 5da1583547c78c15a14kjsd8

Created card: 5da1583547c78c15a14kj78g

{"id": "5da1583547c78c15a1408df2", "name": "Mock Interviews - Applied", "cards": [{"id": "5da1583547c78c15a14kjsd8","name": "abcd@gmail.com"}, {"id": "5da1583547c78c15a14kj78g", "name": "abcda@gmail.com"}]}

{"id": "5da1583547c78c15a1408df2", "name": "Mock Interviews - Applied", "cards": [{"id": "5da1583547c78c15a14kjsd8","name": "abcd@gmail.com"}, {"id": "5da1583547c78c15a14kj78g", "name": "abcde@gmail.com", "description": "At 7PM"}]}

{"id": "5da1583547c78c15a14kjsd8", "name": "abcd@gmail.com", "assignedTo": "gaurav@workat.tech"}

{"id": "5da1583547c78c15a1408df2", "name": "Mock Interviews - Applied", "cards": [{"id": "5da1583547c78c15a14kj78g","name": "abcde@gmail.com", "description": "At 7PM"}]}

{"id": "5da1583547c78c15a143hj34", "name": "Mock Interviews - Scheduled", "cards": [{"id":"5da1583547c78c15a14kjsd8", "name": "abcd@gmail.com", "assignedTo": "gaurav@workat.tech"}]}

{"id": "5da1583547c78c15a14kjsd8", "name": "abcd@gmail.com"}