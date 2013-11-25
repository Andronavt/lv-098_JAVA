package tc.lv.utils;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tc.lv.service.ParserResultService;

public class GeoIpAdvice implements MethodInterceptor {
    private static final Logger LOGGER = Logger.getLogger(GeoIpAdvice.class);

    public Object invoke(MethodInvocation mi) throws Throwable {
        LOGGER.info("!!!!!!!!!!!!!!!!!!!BEFORE!!!!!!!!!!!!!!!!!!!!!");
        Object ob = mi.proceed();
        LOGGER.info("!!!!!!!!!!!!!!!!!!!AFTER!!!!!!!!!!!!!!!!!!!!!");
        return ob;

    }

}
// For insert in method
//ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "geoIpAdvice.xml" });
//ParserResultService cust = (ParserResultService) appContext.getBean("parserResultServiceProxy");
//cust.saveAllSources(parserResultList);