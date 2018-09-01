package lk.ijse.motor.util;



import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class JPAUtil {

    private static EntityManagerFactory entityManagerFactory=buildEntityFactory();

     private static EntityManagerFactory buildEntityFactory()  {
         System.out.println(new File("application.properties").getAbsolutePath());

         File file = new File("application.properties");
         FileReader fileReader = null;
         try {
             fileReader = new FileReader(file);
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }
         Properties jpaProp=new Properties();
         try {
             jpaProp.load(fileReader);
         } catch (IOException e) {
             e.printStackTrace();
         }

         EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("boot2",jpaProp);
         return entityManagerFactory;

     }

    public static EntityManagerFactory getEntityManagerFactoryFactory(){

        return entityManagerFactory;
    }
}
