# SpringDocs OAuth redirect problem

Access the Swagger-UI at http://localhost:8080/swagger-ui/index.html 

Then click the `authorize` button and use the preconfigured values. 

The `IdentityProviderController` prints then the configured values, e.g. `redirect_uri`.

The `redirect_uri` should be `http://localhost:8080/swagger-ui/oauth2-redirect.html`.
But the `swagger-ui/` path is missing. Even when it is configured in the `application.yaml`.