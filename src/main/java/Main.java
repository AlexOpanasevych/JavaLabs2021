import com.phone.controllers.PhoneController;
import com.phone.models.Phone;
import com.phone.models.Smartphone;
import com.phone.views.PhoneView;

public class Main {

    public static void main(String[] args) throws Throwable {
        Phone phone = new Smartphone();
        PhoneView view = new PhoneView();
        PhoneController phoneController = new PhoneController(view, phone);
        phoneController.execute();
    }

}
