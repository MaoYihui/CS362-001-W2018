package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {



	 @Test
	  public void test01()  throws Throwable  {

		 Calendar rightnow = Calendar.getInstance();
		 //current month/year/date is today


		 int thisMonth;


		 int thisYear;


		 int thisDay;
		 thisMonth = rightnow.get(Calendar.MONTH)+1;
		 thisYear = rightnow.get(Calendar.YEAR);
		 thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		 GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);

		 CalDay cd=new CalDay(today);
		 /*
		 assertEquals (thisDay,cd.getDay());
		 assertEquals (thisMonth,cd.getMonth());
		 assertEquals (thisYear,cd.getYear());
*/
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";

		 Appt appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 cd.addAppt(appt);
		 assertEquals( 21,cd.getAppts().get(0).getStartHour());
		 assertEquals( 30,cd.getAppts().get(0).getStartMinute());
		 assertEquals( 15,cd.getAppts().get(0).getStartDay());
		 assertEquals( 01,cd.getAppts().get(0).getStartMonth());



		 int startHour_1=22;


		 Appt appt_1 = new Appt(startHour_1,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 cd.addAppt(appt_1);
		 assertEquals( 22,cd.getAppts().get(1).getStartHour());

		 int startHour_2=19;


		 Appt appt_2 = new Appt(startHour_2,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 cd.addAppt(appt_2);
		 assertEquals( 22,cd.getAppts().get(2).getStartHour());


		 int startHour_3=23;


		 Appt appt_3 = new Appt(startHour_3,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 cd.addAppt(appt_3);
		 assertEquals( 23,cd.getAppts().get(3).getStartHour());



		 int startHour_4=25;


		 Appt appt_4 = new Appt(startHour_4,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 cd.addAppt(appt_4);
		 assertEquals( 23,cd.getAppts().get(3).getStartHour());


         assertNotEquals("sss",cd.toString());

		 CalDay cd_1=new CalDay();
		 assertNotEquals("sss",cd_1.toString());

        assertNotEquals(null,cd.iterator());
        assertEquals(null,cd_1.iterator());


	 }




	 @Test
	  public void test02()  throws Throwable  {
		 
	 }
//add more unit tests as you needed	
}
