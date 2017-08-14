This project is an experiment to determine the implementation of security in the predix setup. It includes
* A CRUD com.example.predixcrudservice.service that interacts with the database
* An aggregate com.example.predixcrudservice.service that receives application specific requests and calls the CRUD com.example.predixcrudservice.service
* A browser only modern front end application that authenticates a user and calls the APIs exposed by aggregate com.example.predixcrudservice.service 