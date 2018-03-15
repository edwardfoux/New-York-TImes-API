Readme.

Project Requirements:

The challenge is to create a simple Android app that exercises a REST-ful API. The API endpoint : http://api.nytimes.com/svc/movies/v2/reviews/dvd-picks.json?order=by-date&api-key=b75da00e12d54774a2d362adddcc9bef results in a json response which is a list of different movie reviews published by ny times. For example, 

  "results": [
    {
      "display_title": "Rat Film",
      "mpaa_rating": "",
      "headline": "Review: In \u2018Rat Film,\u2019 a City of Rodents and Racial Oppression",
        ....

    },
    {
      "display_title": "Woodpeckers",
      "mpaa_rating": "",
      "headline": "Review: \u2018Woodpeckers,\u2019 a Tale of Love and Agonizing Penal Confinement",
      ....
    },
    ..
    ]

Show a list of these items and each item row should display following fields:
  display_title (movie title)
  mpaa_rating (movie rating)
  byline (reviewer)
  headline 
  summary_short
  publication_date
  multimedia 

Running:
Please open the project with Android Studio and run on device or emulator

Executing unit tests:
Please open the Terminal and execute ./gradlew test


Project description:
The application displays the list of Dvd Picks in the a scrollable list.
The data is fetched from the provided url

App structure:
The application has clear separation of concerns where the UI and business logic are separated.
The data loading is happening in the ViewModel and being presented in the Activity.

Dependencies used:
Glide for image loading
Retorfit2 for payload fetching
Gson for converting data to POJO
RxJava for creating the stream
Architecture components for ViewModel support
Butterknife for the view binding in the Main Activity
Mockito for unit testing

Extra credit:
Used ViewModel instead of Presenter to utilize the architecture components
ViewModel retains its state even during the orientation change, which allows 
to provide seamless experience during the screen rotation
Unit tests for the utility methods and the ViewModel instance