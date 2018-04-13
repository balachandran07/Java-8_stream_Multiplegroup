package com.kgisl.parseexbeen;

import com.opencsv.bean.CsvBindByName;

public class Employee {
    
    @CsvBindByName
    private String tradeid;
    
    @CsvBindByName
    private String status;


  
    
    @CsvBindByName
    private String last_modit;



    
    
   /**
    * @return the status
    */
   public String getStatus() {
       return status;
   }
   /**
    * @param status the status to set
    */
   public void setStatus(String status) {
       this.status = status;
   }
   /**
    * @return the tradeid
    */
   public String getTradeid() {
       return tradeid;
   }
   /**
    * @param tradeid the tradeid to set
    */
   public void setTradeid(String tradeid) {
       this.tradeid = tradeid;
   }
    /**
     * @return the last_modit
     */
    public String getLast_modit() {
        return last_modit;
    }
    /**
     * @param last_modit the last_modit to set
     */
    public void setLast_modit(String last_modit) {
        this.last_modit = last_modit;
    }
    // public static enum Status
    // {
    //     A,
    //     P
    // };

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("tradeid{id=").append(tradeid).append(", status=")
                .append(status).append(", last_modit=").append(last_modit).append("}");

        return builder.toString();
    }
}