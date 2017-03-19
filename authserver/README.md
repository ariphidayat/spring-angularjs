#### Testing the Authorization Server
Run the server with below command :

```
$ mvn spring-boot:run
```

or start the `main()` method on IDE.

Our server is using the Spring Boot default security settings, so like the server in Part I it will be protected 
by HTTP Basic authentication. To initiate an authorization code token grant you visit the authorization endpoint, 
e.g. at http://localhost:9000/uaa/oauth/authorize?response_type=code&client_id=arip&redirect_uri=http://example.com 
once you have authenticated you will get a redirect to example.com with an authorization code attached, 
e.g. http://example.com/?code=pFxHnF.

> for the purposes of this sample application we have created a client "arip" with no registered redirect, which is 
what enables us to get a redirect the example.com. In a production application you should always register
a redirect (and use HTTPS).

The code can be exchanged for an access token using the "arip" client credentials on the token endpoint:

```
curl arip:aripsecret@localhost:9000/uaa/oauth/token \
-d grant_type=authorization_code -d client_id=arip \
-d redirect_uri=http://example.com -d code=KoKqcG
```

you will get a json response e.g. 

```
{
    "access_token":"b4ace2db-6df3-44be-8cd0-e139d710ebb6",
    "token_type":"bearer",
    "refresh_token":"8eb066d1-d1c2-4a10-affa-8dba8ab7f56e",
    "expires_in":9,
    "scope":"openid"
}
```

The access token is a UUID ("b4ace2db-6df3-44be-8cd0-e139d710ebb6"), backed by an in-memory token store in the server. 
We also got a refresh token that we can use to get a new access token when the current one expires.

> since we allowed "password" grants for the "acme" client we can also get a token directly from the token endpoint 
using curl and user credentials instead of an authorization code. This is not suitable for a browser based client, 
but it’s useful for testing.
        
    
[Source](https://spring.io/guides/tutorials/spring-security-and-angular-js/#_sso_with_oauth2_angular_js_and_spring_security_part_v)
