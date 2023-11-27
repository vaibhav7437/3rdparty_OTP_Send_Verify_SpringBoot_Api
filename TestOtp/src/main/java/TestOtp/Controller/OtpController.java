package TestOtp.Controller;

import TestOtp.Service.impl.OtpService;
import TestOtp.Service.impl.TwilioService;
import TestOtp.Util.OtpStorage;
import TestOtp.payload.OtpVerificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/otp")
public class OtpController {

    private final TwilioService twilioService;
    private final OtpService otpService;
    private final OtpStorage otpStorage;

    @Autowired
    public OtpController(TwilioService twilioService, OtpService otpService, OtpStorage otpStorage) {
        this.twilioService = twilioService;
        this.otpService = otpService;
        this.otpStorage = otpStorage;
    }

    @PostMapping("/send")
    public void sendOtp(@RequestParam String phoneNumber) {
        System.out.println(phoneNumber);
        String otp = otpService.generateOtp();
        twilioService.sendOtp(phoneNumber, otp);
        // Store the OTP and associated phone number in your backend for verification
        otpStorage.storeOtp(phoneNumber, otp);
    }

    @PostMapping("/verify")
    public String verifyOtp(@RequestBody OtpVerificationRequest request) {
        // Retrieve stored OTP and associated phone number from your backend
        String storedOtp = otpStorage.getStoredOtp(request.getPhoneNumber());
        String phoneNumber = request.getPhoneNumber();
        String enteredOtp = request.getEnteredOtp();

        if (otpService.verifyOtp(enteredOtp, storedOtp)) {
            // Remove the OTP from storage after successful verification
            otpStorage.clearOtp(phoneNumber);
            return "OTP verified successfully";
        } else {
            return "Invalid OTP";
        }
    }
}
