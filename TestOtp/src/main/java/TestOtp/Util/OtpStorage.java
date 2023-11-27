package TestOtp.Util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class OtpStorage {

    private final Map<String, String> otpMap = new HashMap<>();

    public void storeOtp(String phoneNumber, String otp) {
        otpMap.put(phoneNumber, otp);
    }

    public String getStoredOtp(String phoneNumber) {
        return otpMap.get(phoneNumber);
    }

    public void clearOtp(String phoneNumber) {
        otpMap.remove(phoneNumber);
    }
}

