import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AlertServiceTest {

    @Test
    public void testRaiseAlert_stubVoidToDoNothing() {
        NotificationSender mockSender = mock(NotificationSender.class);
        AlertService alertService = new AlertService(mockSender);

        // Explicitly stub the void method to do nothing (this is actually the default
        // behavior for mocks, but doNothing() makes it explicit/readable)
        doNothing().when(mockSender).sendNotification("System Down");

        alertService.raiseAlert("System Down");

        // Verify the void method was actually called with the right argument
        verify(mockSender).sendNotification("System Down");
    }

    @Test
    public void testRaiseAlert_stubVoidToThrowException() {
        NotificationSender mockSender = mock(NotificationSender.class);
        AlertService alertService = new AlertService(mockSender);

        // Stub the void method to throw an exception when called
        doThrow(new RuntimeException("Notification service down"))
                .when(mockSender).sendNotification(anyString());

        // Verify that calling raiseAlert() now propagates that exception
        assertThrows(RuntimeException.class, () -> alertService.raiseAlert("Server Error"));
    }
}
