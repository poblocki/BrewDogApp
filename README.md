# BrewDogApp

Sample project presenting the features of Android framework

The application displays information about beers on the paging list and detailed screen.


* Implemented according to Clean Architecture rules with Data,Domain and Presentation layers
* Uses MVVM as the main architecture style
* Uses Dagger2 as the dependency injection framework
* Connects to Punk API for retrieving information about beers. 
* Stores the received API response into Android Room database
* Displays paging list of beer with the help of Android Paging library
* Uses RxJava2 for managing the data flows
* Uses Glide as the image loading library
* For navigation between screens uses Android Navigation library
* Sample unit tests are written with the help of mockk library

Potential improvements : 
* Displaying data status (loading, error, success)
* Swipe to refresh
* Writing UI tests
