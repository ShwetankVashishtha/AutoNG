package com.autong.base;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2023
 */
public class GetPages {

    public <TPage> TPage GetInstance(Class<TPage> pageClass) {
        try {
            return pageClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}
