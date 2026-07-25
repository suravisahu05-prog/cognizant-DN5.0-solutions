import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyServiceTest {

    @Test
    public void testFetchData_withMultipleConsecutiveReturns() {
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub to return different values on consecutive calls, in this order
        when(mockApi.getData())
                .thenReturn("First Call Data")
                .thenReturn("Second Call Data")
                .thenReturn("Third Call Data");

        MyService service = new MyService(mockApi);

        // Each call to fetchData() triggers the next value in the sequence
        assertEquals("First Call Data", service.fetchData());
        assertEquals("Second Call Data", service.fetchData());
        assertEquals("Third Call Data", service.fetchData());

        // Once the sequence is exhausted, Mockito keeps returning the LAST stubbed value
        assertEquals("Third Call Data", service.fetchData());
    }
}
