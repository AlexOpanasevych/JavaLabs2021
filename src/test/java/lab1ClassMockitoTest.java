import com.phone.controllers.PhoneController;
import com.phone.models.Phone;
import com.phone.models.Smartphone;
import com.phone.views.PhoneView;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class lab1ClassMockitoTest {
    @Test
    public void testCorrectInput() throws Throwable {
        Phone phone = Mockito.mock(Smartphone.class);
        PhoneView view = Mockito.mock(PhoneView.class);
        PhoneController controller = new PhoneController(view, phone);
//        when(view.inputPhoneType()).thenReturn("Smartphone");
        when(view.input(phone.getClass().getCanonicalName())).thenReturn("Samsung,2,3,4,5,6,7,8");
        controller.execute();
        verify(view).show(phone);
    }

    @Test
    public void testIncorrectInput(){
        Phone phone = Mockito.mock(Smartphone.class);
        PhoneView view = Mockito.mock(PhoneView.class);
        PhoneController controller = new PhoneController(view, phone);
        when(view.input(phone.getClass().getCanonicalName())).thenReturn("1");
        assertThrows(Exception.class, controller::execute);
        verify(phone);
    }
}
