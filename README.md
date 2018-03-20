# Mocking By Example – With Mockito
This is a Spring boot REST client that connects to a remote RESTful web server via http, retrieves a random text, 
encodes it using the trivial [ROT13 Encoding](https://en.wikipedia.org/wiki/ROT13).

The point of this example is to demonstrate using `Mockito` to mock the remote REST end point.

Although simple, this is a good example where `Mocking Frameworks` like `Mocito` shine for the following two main reasons:
- The REST server is a remote Internet server which can be slow or even unreachable.
- The text returned from the REST end point is simply random. This randomness makes it tricky to unit-test.
   
## Running The Application
From the root of the repo run
```
$ ./gradlew -q clean build && java -jar build/libs/junit-mockito-0.1.0.jar http://gturnquist-quoters.cfapps.io/api/random
```

## Running The Unit Tests
From the root of the repo run
```
$ ./gradlew clean test
```
