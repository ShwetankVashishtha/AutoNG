package locators;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Routes {

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public class BaseEndPoints {
        public static final String BASE_PATH = "";
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public class TestRailEndPoints {
        public static final String GET_CASE_END_POINT = "/api/v2/get_case/1";
        public static final String ADD_RESULT_END_POINT = "/api/v2/add_result/1";
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public class JiraEndpoints {
        public static final String ADD_JIRA_ISSUE_END_POINT = "/issue/";
    }
}
