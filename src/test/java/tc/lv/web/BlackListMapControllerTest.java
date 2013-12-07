package tc.lv.web;

import org.junit.Assert;
import org.junit.Test;

public class BlackListMapControllerTest {

    @Test
    public void deleteIpFromWhiteList() {
	BlackListMapController test = new BlackListMapController();
	Assert.assertEquals("secure_blackListMap", test.showIpFromWhiteList());
    }

}
