Software Requirements Specification (SRS) for the Assignment 

*Project Title*

*Bank Account Management System*

1. *Introduction*

The Bank Account Management System is a RESTful application developed using Spring Boot, Spring Data JPA, and PostgreSQL. The system is designed to manage bank customers, their accounts, and basic banking transactions such as deposits and withdrawals.


2. *Objectives*

The application should enable users to:

- Manage customer records.
- Create and manage bank accounts.
- Perform deposits and withdrawals.
- View transaction history for each account.


3. *Functional Requirements*

3.1 *Customer Management*

The system shall allow users to: 

- Add a new customer.  *doneeee*
- View all customers....
- View a customer by ID.....
- Update customer details.
- Delete a customer.

*Customer Information*

- First Name  *doneee*
- Last Name
- Email
- Phone Number
- Address


3.2 *Account Management*

The system shall allow users to:

- Create a bank account for an existing customer....
- View all bank accounts....
- View an account by its account number....
- Close a bank account....
- View all accounts belonging to a specific customer....

*Account Information*

- Account Number (must be unique)....
- Account Type (Savings or Current)...
- Balance...
- Date Created...
- Status (ACTIVE or CLOSED)...

Relationship: One customer can own multiple bank accounts, but each bank account belongs to only one customer.


3.3 Deposit.....

The system shall allow users to deposit money into an active account.

Rules:

- Deposit amount must be greater than zero....
- The account balance must be updated....
- A transaction record must be created....

3.4 Withdrawal

The system shall allow users to withdraw money from an active account.

Rules:

- Withdrawal amount must be greater than zero.
- The account must have sufficient balance.
- The account balance must be updated.
- A transaction record must be created.

3.5 Transaction History

The system shall display all transactions performed on a particular account.

Each transaction should contain:

- Transaction Type (Deposit or Withdrawal)
- Amount
- Transaction Date
- Description (optional)


4. Database Requirements

The application should contain the following entities:

Customer

- id
- firstName
- lastName
- email
- phone
- address

Account

- id
- accountNumber
- accountType
- balance
- createdAt
- status

Transaction

- id
- transactionType
- amount
- transactionDate
- description

5. Validation Rules


- Account numbers must be unique.
- Initial balance cannot be negative.
- Deposits and withdrawals must be greater than zero.
- Withdrawals cannot exceed the available balance.
- No transaction should be allowed on a closed account.