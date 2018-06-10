package iss.sa46team12.springclub.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


public class BookingId implements Serializable {

   private int bookingid;
   private int facilityid;
   private int timeslotid;
}
