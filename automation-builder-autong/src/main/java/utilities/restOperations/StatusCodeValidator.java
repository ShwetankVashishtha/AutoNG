package utilities.restOperations;

/**
 * @author Shwetank Vashishtha
 */
public enum StatusCodeValidator {

    CODE_200(200, "OK"),
    CODE_201(201, "Created"),
    CODE_400(400, "Bad Request"),
    CODE_401(401, "Unauthorized");

    public final int code;
    public final String msg;

    StatusCodeValidator(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

