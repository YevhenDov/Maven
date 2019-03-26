package dev.validate;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class ValidateUtilTest {
    ValidateUtil validateUtil;

    @Before
    public void setValidator() {
        validateUtil = new ValidateUtil();
    }

    @Test
    public void phoneValidator() {
        String firstPhoneNumber = "+38(111)444-33-22";
        assertTrue(validateUtil.phoneValidator(firstPhoneNumber));
    }

    @Test
    public void emailValidator() {
        String firstEmail = "user_name@gmail.com";
        assertTrue(validateUtil.emailValidator(firstEmail));
    }

    @Test
    public void dateValidator() {
        String firstDate = "2019-12-12";
        assertTrue(validateUtil.dateValidator(firstDate));
    }

    @Test
    public void ipValidator() {
        String firstIp = "192.168.0.1";
        assertTrue(validateUtil.ipValidator(firstIp));
    }
}
