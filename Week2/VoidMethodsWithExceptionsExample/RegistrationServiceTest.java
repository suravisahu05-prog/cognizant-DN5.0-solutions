import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RegistrationServiceTest {

    @Test
    public void testRegisterUser_whenEmailServiceThrowsException() {
        EmailService mockEmailService = mock(EmailService.class);
        RegistrationService registrationService = new RegistrationService(mockEmailService);

        // Stub the void method to throw an exception when called
        doThrow(new RuntimeException("Email server unavailable"))
                .when(mockEmailService).sendEmail(anyString(), anyString());

        // Verify that the exception from the mock propagates up through registerUser()
        RuntimeException exception = assertThrows(
            RuntimeException.class,
            () -> registrationService.registerUser("test@example.com")
        );

        // Confirm it's actually the exception we stubbed, not some other failure
        assertEquals("Email server unavailable", exception.getMessage());

        // Verify the void method was indeed called (with any arguments) before it threw
        verify(mockEmailService).sendEmail(anyString(), anyString());
    }
}
