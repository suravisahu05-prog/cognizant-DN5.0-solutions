public class RegistrationService {
    private EmailService emailService;

    public RegistrationService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void registerUser(String email) {
        emailService.sendEmail(email, "Welcome!");
    }
}
