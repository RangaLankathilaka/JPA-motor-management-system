/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.bussiness.custom.impl;

import lk.ijse.motor.bussiness.custom.VehicleBO;
import lk.ijse.motor.dao.DAOFactory;
import lk.ijse.motor.dao.custom.CustomerDAO;
import lk.ijse.motor.dao.custom.VehecleDAO;
import lk.ijse.motor.dto.VehicleDTO;
import lk.ijse.motor.entity.Customer;
import lk.ijse.motor.entity.Vehicle;
import lk.ijse.motor.util.JPAUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Ranga Lankathilaka
 */
public class VehicleBOImpl implements VehicleBO{
    VehecleDAO vehecleDAO;
    private EntityManagerFactory entityManagerFactory;
    CustomerDAO customerDAO;

    public VehicleBOImpl() {
        customerDAO = (CustomerDAO) DAOFactory.getInstance().getDaotype(DAOFactory.Daotype.CUSTOMER);
        vehecleDAO=(VehecleDAO) DAOFactory.getInstance().getDaotype(DAOFactory.Daotype.VEHICLE);
        entityManagerFactory = JPAUtil.getEntityManagerFactoryFactory();
    }
    

    @Override
    public boolean save(VehicleDTO entity) throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      //  Vehicle vehicle=new Vehicle(entity.getVid(),entity.getType(),entity.getIssue(),entity.getCid());
     //   return vehecleDAO.save(vehicle);





        EntityManager entityManager = entityManagerFactory.createEntityManager();

            vehecleDAO.setEntityManager(entityManager);
        entityManager.getTransaction().begin();
            Customer customer1 = customerDAO.find(entity.getCid());
            Vehicle vehicle = new Vehicle(entity.getVid(),entity.getType(),entity.getIssue(),customer1);
            vehecleDAO.save(vehicle);

        entityManager.getTransaction().commit();
        entityManager.close();
            return true;



    
    }

    @Override
    public int getVehicleCount() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 
 //return vehecleDAO.getVehicleCount();
        return 9;
    
    }
    
}
