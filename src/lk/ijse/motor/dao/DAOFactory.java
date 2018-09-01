/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.dao;

import lk.ijse.motor.dao.custom.PartDAO;
import lk.ijse.motor.dao.custom.impl.CustomerDaoImpl;
import lk.ijse.motor.dao.custom.impl.CustomerDetailDaoImpl;
import lk.ijse.motor.dao.custom.impl.InvoiceDaoImpl;
import lk.ijse.motor.dao.custom.impl.InvoiceDetailDaoImpl;
import lk.ijse.motor.dao.custom.impl.PartDaoImpl;
import lk.ijse.motor.dao.custom.impl.VehicleDaoImpl;
import lk.ijse.motor.dao.custom.impl.WarrentyDaoImpl;

/**
 *
 * @author Ranga Lankathilaka
 */
public class DAOFactory {
    private static DAOFactory daofactory;
    public enum Daotype{
        CUSTOMER,CUSTOMERDETAIL,INVOICE,INVOICEDETAIL,PART,VEHICLE,WARRENTY;
    }
    
    
    private DAOFactory(){
        
    }
    
    public static DAOFactory getInstance(){
        
        if(daofactory==null){
            daofactory=new DAOFactory();
            
        }
        
        
        return daofactory;
    }
    public SuperDao getDaotype(Daotype daotype){
        switch(daotype){
            case CUSTOMER:
                return  new CustomerDaoImpl();
                
            case CUSTOMERDETAIL:
                return new CustomerDetailDaoImpl();
                
            case INVOICE:
                return new InvoiceDaoImpl();
               
            case INVOICEDETAIL:
                return  new InvoiceDetailDaoImpl();
                
                case PART:
                    return new PartDaoImpl();
                    
                    case VEHICLE:
                        return new VehicleDaoImpl();
                        
                        case WARRENTY:
                            
                            return new WarrentyDaoImpl();
                            
                            default:
                                return null;
        }
    }
    
}
