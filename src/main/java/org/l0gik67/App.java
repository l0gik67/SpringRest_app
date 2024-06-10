package org.l0gik67;

import org.l0gik67.configuration.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication", Communication.class);
//        System.out.println(communication.getAllEmployees());
//        System.out.println(communication.getEmployee(100));

    }
}
