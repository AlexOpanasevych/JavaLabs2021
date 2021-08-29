import com.phone.models.BlockProxy;
import com.phone.models.Phone;
import com.phone.models.Smartphone;
import com.phone.models.interfaces.Entity;

public class lab1 {

     public static void main(String []args){
        Phone smartphone = new Smartphone("Iphone", 100, 3.5, 64, true, 3000, 4, 4);
		smartphone.runAllAnnotatedMethods();
		smartphone.printData();

         Entity proxy = (Entity) BlockProxy.newProxyInstance(new Phone());
         System.out.println(proxy.getFoo());
         proxy.setFoo();
     }
}