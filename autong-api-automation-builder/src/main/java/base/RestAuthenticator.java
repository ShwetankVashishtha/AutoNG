package base;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author shwetankvashishtha
 * @version 1.0
 * @since 2022
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RestAuthenticator {

    public static PreemptiveBasicAuthScheme setAuthentication(String username, String password) {
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName(username);
        authScheme.setPassword(password);
        RestAssured.authentication = authScheme;
        return authScheme;
    }
}
