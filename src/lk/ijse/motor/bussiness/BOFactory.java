/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.bussiness;

import lk.ijse.motor.bussiness.custom.impl.CustomerBOImpl;
import lk.ijse.motor.bussiness.custom.impl.CustomerDetailBOImpl;
import lk.ijse.motor.bussiness.custom.impl.InvoiceBOImpl;
import lk.ijse.motor.bussiness.custom.impl.InvoicedetailBOImpl;
import lk.ijse.motor.bussiness.custom.impl.PartBOImpl;
import lk.ijse.motor.bussiness.custom.impl.VehicleBOImpl;

/**
 *
 * @author Ranga Lankathilaka
 */
public class BOFactory {
    private  static BOFactory bOFactory;
    
    
    public enum BOType{
        CUSTOMER,PART,INVOICE,VEHICLE,INVOICEDETAIL,CUSTOMERDETAIL;
    }
    
    private BOFactory(){
      
    }
    
    public static BOFactory getInstance(){
        if(bOFactory==null){
            bOFactory=new BOFactory();
        }
        
        
        
        return bOFactory;
    }
    
    public SuperBO getBOType(BOType bOType){
        switch(bOType){
            case CUSTOMER:
                return new CustomerBOImpl();
                case PART:
                    return new PartBOImpl();
                    case INVOICE:
                        return new InvoiceBOImpl();
                    case VEHICLE:
                        return new VehicleBOImpl();
                    case INVOICEDETAIL:
                        return new InvoicedetailBOImpl();
                        case CUSTOMERDETAIL:
                            return new CustomerDetailBOImpl();
                    default:
                        return null;
            
            
        }
    }
}
