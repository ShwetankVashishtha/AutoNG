package locators;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Locators {

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public class LoginLocators {
        public static final String USERNAME = "//input[@name='username']";
        public static final String PASSWORD = "//input[@type='password']";
        public static final String LOGIN = "//button[@type='submit']";
        public static final String DASHBOARD_LOGO = "//img[@alt='client brand banner']";
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public class AdminLocators {
        public static final String ADMIN_SIDE_NAV = "//a[@href='/web/index.php/admin/viewAdminModule']";
        public static final String USER_ROLES_LABEL = "//label[@class='oxd-label']";
        public static final String USER_ROLES_DROPDOWN = "//div[@class='oxd-select-text-input'][0]";
        public static final String FOOTER_LINK = "//a[@href='http://www.orangehrm.com']";
        public static final String COPYRIGHT_YEAR = "//div[@class='oxd-layout-footer']/p[2]";
        public static final String SEARCH_BTN = "//button[@type='submit']";
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public class MyInfoLocators {
        public static final String MYINFO_SIDE_NAV = "//span[normalize-space()='My Info']";
        public static final String ADD_ATTACHMENT_BTN = "//div[@class='orangehrm-action-header']/button[@type='button']";
        public static final String BROWSE_BTN = "//div[@class='oxd-file-button']";
        public static final String FILE_PATH_INPUT = "//input[@type='file']";
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public class AndroidLocators {
        public static final String WELCOME_TO_WHATSAPP_SCREEN = "com.whatsapp:id/action_bar_root";
        public static final String AGREE_AND_CONTINUE_BTN = "com.whatsapp:id/eula_accept";
        public static final String ENTER_YOUR_PHONE_NUMBER_SCREEN = "com.whatsapp:id/register_phone_toolbar_title";
    }
}
