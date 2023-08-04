package com.autong.base;

import io.restassured.response.Response;

public class Assertions {

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
