package com.autong.base;

import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2022
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RestAssertions {

    /**
     * @param response
     * @return boolean validation response code
     */
    public static boolean validateOkResponse(Response response) {
        try {
            if (response.statusCode() == StatusCodeValidator.CODE_200.code) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return false;
    }

    /**
     * @param response
     * @return boolean validation response code
     */
    public static boolean validateCreatedResponse(Response response) {
        try {
            if (response.statusCode() == StatusCodeValidator.CODE_201.code) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return false;
    }

    /**
     * @param response
     * @return boolean validation response code
     */
    public static boolean validateBadRequestResponse(Response response) {
        try {
            if (response.statusCode() == StatusCodeValidator.CODE_400.code) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return false;
    }

    /**
     * @param response
     * @return boolean validation response code
     */
    public static boolean validateUnauthorizedResponse(Response response) {
        try {
            if (response.statusCode() == StatusCodeValidator.CODE_401.code) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return false;
    }

    /**
     * @param response
     * @return boolean validation response code
     */
    public static boolean validateNotFoundResponse(Response response) {
        try {
            if (response.statusCode() == StatusCodeValidator.CODE_404.code) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return false;
    }

    /**
     * @param response
     * @return boolean validation response code
     */
    public static boolean validateMethodNotAllowedResponse(Response response) {
        try {
            if (response.statusCode() == StatusCodeValidator.CODE_405.code) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return false;
    }

    /**
     * @param response
     * @return boolean validation response code
     */
    public static boolean validateInternalServerErrorResponse(Response response) {
        try {
            if (response.statusCode() == StatusCodeValidator.CODE_500.code) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return false;
    }

    /**
     * @param response
     * @return boolean validation response code
     */
    public static boolean validateBadGatewayResponse(Response response) {
        try {
            if (response.statusCode() == StatusCodeValidator.CODE_502.code) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return false;
    }

    /**
     * @param response
     * @return boolean validation response code
     */
    public static boolean validateServiceUnavailableResponse(Response response) {
        try {
            if (response.statusCode() == StatusCodeValidator.CODE_503.code) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return false;
    }

    /**
     * @param response
     * @return boolean validation response code
     */
    public static boolean validateGatewayTimeoutResponse(Response response) {
        try {
            if (response.statusCode() == StatusCodeValidator.CODE_504.code) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return false;
    }

    /**
     * @param response
     * @return boolean validation response time
     */
    public static boolean validateResponseTime(Response response) {
        try {
            if (response.getTime() <= 2000) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return false;
    }
}
