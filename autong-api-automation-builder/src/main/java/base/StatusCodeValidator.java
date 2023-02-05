package base;

import org.apache.http.HttpStatus;

/**
 * @author shwetankvashishtha
 * @version 1.0
 * @since 2022
 */
public enum StatusCodeValidator {

    CODE_200(HttpStatus.SC_OK, "OK"),
    CODE_201(HttpStatus.SC_CREATED, "Created"),
    CODE_400(HttpStatus.SC_BAD_REQUEST, "Bad Request"),
    CODE_401(HttpStatus.SC_UNAUTHORIZED, "Unauthorized"),
    CODE_404(HttpStatus.SC_NOT_FOUND, "Not Found"),
    CODE_405(HttpStatus.SC_METHOD_NOT_ALLOWED, "Method Not Allowed"),
    CODE_500(HttpStatus.SC_INTERNAL_SERVER_ERROR, "Internal Server Error"),
    CODE_502(HttpStatus.SC_BAD_GATEWAY, "Bad Gateway"),
    CODE_503(HttpStatus.SC_SERVICE_UNAVAILABLE, "Service Unavailable"),
    CODE_504(HttpStatus.SC_GATEWAY_TIMEOUT, "Gateway Timeout");

    public final int code;
    public final String msg;

    StatusCodeValidator(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

