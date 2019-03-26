package dev.validate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateUtilTest {
    ValidateUtil validateUtil;

    @Before
    public void setValidator(){
        validateUtil = new ValidateUtil();
    }

    @Test
    public void phoneValidator() {
        String firstPhoneNumber = "+38(111)444-33-22";
        String secondPhoneNumber = "+38748579354ff";

        assertTrue(validateUtil.phoneValidator(firstPhoneNumber));
        assertFalse(validateUtil.phoneValidator(secondPhoneNumber));
    }

    @Test
    public void emailValidator() {
        String firstEmail = "user_name@gmail.com";
        String secondEmail = "fvavavaa";

        assertTrue(validateUtil.emailValidator(firstEmail));
        assertFalse(validateUtil.emailValidator(secondEmail));
    }

    @Test
    public void dateValidator() {
        String firstDate = "2019-12-12";
        String secondDate = "78427868";

        assertTrue(validateUtil.dateValidator(firstDate));
        assertFalse(validateUtil.dateValidator(secondDate));
    }

    @Test
    public void ipValidator() {
        String firstIp = "192.168.0.1";
        String secondIp = "257.257.257.257";

        assertTrue(validateUtil.ipValidator(firstIp));
        assertFalse(validateUtil.ipValidator(secondIp));
    }
}