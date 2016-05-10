import org.junit.Test;
import static org.junit.Assert.assertEquals;
import spittr.web.HomeController;

/**
 * Created by jhj on 2016-05-10.
 */
public class ControllerTest {
    @Test
    public void testHome() throws Exception{
        HomeController homeController = new HomeController();
        assertEquals("home", homeController.home());
    }
}
