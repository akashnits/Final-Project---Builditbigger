# Gradle for Android and Java Final Project

In this project, we will create an app with multiple flavors that uses
multiple libraries and Google Cloud Endpoints. The finished app will consist
of four modules. A Java library that provides jokes, a Google Cloud Endpoints
(GCE) project that serves those jokes, an Android Library containing an
activity for displaying jokes, and an Android app that fetches jokes from the
GCE module and passes them to the Android Library for display.

## Why this Project

As Android projects grow in complexity, it becomes necessary to customize the
behavior of the Gradle build tool, allowing automation of repetitive tasks.
Particularly, factoring functionality into libraries and creating product
flavors allow for much bigger projects with minimal added complexity.

##What Will we Learn?

We will learn the role of Gradle in building Android Apps and how to use
Gradle to manage apps of increasing complexity. We'll learn to:

* Add free and paid flavors to an app, and set up your build to share code between them
* Factor reusable functionality into a Java library
* Factor reusable Android functionality into an Android library
* Configure a multi project build to compile your libraries and app
* Use the Gradle App Engine plugin to deploy a backend
* Configure an integration test suite that runs against the local App Engine development server

##How Do I Complete this Project?



### Step 1: Create a Java library

Created a Java library that provides jokes. Created a new
Gradle Java project  using the Android Studio wizard. Then
introduced a project dependency between  app and the new Java Library. 

Made the button display a toast showing a joke retrieved from  Java joke
telling library.

### Step 2: Create an Android Library

Created an Android Library containing an Activity that will display a joke
passed to it as an intent extra. Wired up project dependencies so that the
button can now pass the joke from the Java Library to the Android Library.


### Step 3: Created GCE Module

Introduced a project dependency between  Java library and  GCE module,
and modified the GCE starter code to pull jokes from  Java library. Created
an Async task to retrieve jokes. Made the button kick off a task to retrieve a
joke, then launched the activity from  Android Library to display it.

### Step 4: Added Functional Tests

Added code to test that  Async task successfully retrieves a non-empty
string. 

### Step 5: Added a Paid Flavor

Added free and paid product flavors to  app. Removed the ad from the paid flavor.

