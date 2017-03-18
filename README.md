## Spring and Angular JS

#### Running the Application
On command line you can do the following command :

```
$ mvn spring-boot:run
```

and go to a browser at http://localhost:8080. When you load the home page you should get a browser dialog asking for 
username and password (the username is "user" and the password is printed in the console logs on startup). There’s 
actually no content yet, so you should get a blank page with a "Greeting" header once you successfully authenticate.

If you don’t like scraping the console log for the password just add this to the "application.properties" 
(in "src/main/resources"): security.user.password=password (and choose your own password).