package TestOtp.Service.impl;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String twilioPhoneNumber;

    public void sendOtp(String to, String otp) {
        Twilio.init(accountSid, authToken);

        Message message = Message.creator(
                        new PhoneNumber(to),
                        new PhoneNumber(twilioPhoneNumber),
                        "Your OTP is: " + otp)
                .create();

        System.out.println("OTP message SID: " + message.getSid());
    }
}

