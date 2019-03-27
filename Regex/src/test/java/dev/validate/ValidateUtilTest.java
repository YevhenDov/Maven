package dev.validate;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ValidateUtilTest {
    ValidateUtil validateUtil;

    @Before
    public void setValidator() {
        validateUtil = new ValidateUtil();
    }

    @Test
    public void phoneValidator() {
        String userPhoneNumber = "+38(111)444-33-22";
        assertTrue(validateUtil.phoneValidator(userPhoneNumber));
    }

    @Test
    public void emailValidator() {
        String userEmail = "user_name@gmail.com";
        assertTrue(validateUtil.emailValidator(userEmail));
    }

    @Test
    public void dateValidator() {
        String userDate = "2019-12-12";
        assertTrue(validateUtil.dateValidator(userDate));
    }

    @Test
    public void ipValidator() {
        String userIp = "192.168.0.1";
        assertTrue(validateUtil.ipValidator(userIp));
    }

    @Test
    public void phoneValidatorFalse() {
        String userPhoneNumber = "38111444332";
        assertFalse(validateUtil.phoneValidator(userPhoneNumber));
    }

    @Test
    public void emailValidatorFalse() {
        String userEmail = "fake_email";
        assertFalse(validateUtil.phoneValidator(userEmail));
    }

    @Test
    public void dateValidatorFalse() {
        String userDate = "7841276+";
        assertFalse(validateUtil.phoneValidator(userDate));
    }

    @Test
    public void ipValidatorFalse() {
        String userIp = "784.523.478.777";
        assertFalse(validateUtil.phoneValidator(userIp));
    }
}

