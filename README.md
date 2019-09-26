# Funderaiser-App
Java EE Fundraising project which allows users to donate to charities through fundraising activities.

Users can either register as charities or fundraisers. Charities are able to register charitable causes. Fundraising users can create activities for specific causes, and they are also able to donate towards the activites. The donations are then forwarded to the charities through the assosciated cause.

This was a coursework which required us to write up the business logic using Enterprise Java Beans (EJBs) and data storage using Java Persistence API.

The frontend was not part of the project and is just a basic Java Server Faces components.

Tech stack: Java, Java EE, Payara Server, JPA

## Prerequisites

There are a few downloads required to run this project.

### Netbeans

This project uses Payara server which we will set up using IDE Netbeans. 

You can download it [Here](https://www.payara.fish/software/downloads/)

### Payara Server

Truffle is the development environment which we will use to compile, deploy and migrate the smart contracts.

You can download it [Here](https://www.payara.fish/software/downloads/)

## Running the application

This application was set up with Netbeans and Payara Server 5. In order to get the program fully functioning, JDBC data source and connection pools have to be set up within Payara.
