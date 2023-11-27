package TestOtp.payload;

public class OtpVerificationRequest {

    private String phoneNumber;
    private String enteredOtp;

    // Constructors, getters, and setters

    public OtpVerificationRequest() {
        // Default constructor
    }

    public OtpVerificationRequest(String phoneNumber, String enteredOtp) {
        this.phoneNumber = phoneNumber;
        this.enteredOtp = enteredOtp;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEnteredOtp() {
        return enteredOtp;
    }

    public void setEnteredOtp(String enteredOtp) {
        this.enteredOtp = enteredOtp;
    }
}
