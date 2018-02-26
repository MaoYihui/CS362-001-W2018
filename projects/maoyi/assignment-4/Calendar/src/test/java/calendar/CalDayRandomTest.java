package calendar;


import org.junit.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable {
		 long randomseed = System.currentTimeMillis(); //10
		 //			System.out.println(" Seed:"+randomseed );
		 Random random = new Random(randomseed);
		 int thisYear = ValuesGenerator.getRandomIntBetween(random, 2001, 2018);
		 int thisMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
		 int thisDay = ValuesGenerator.getRandomIntBetween(random, 0, 28);
		 GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		 CalDay cd = new CalDay(today);

	 	for (int a=0;a<100;a++) {

			int startHour = ValuesGenerator.getRandomIntBetween(random, -2, 25);
			int startMinute = ValuesGenerator.getRandomIntBetween(random, -5, 61);
			int startDay = ValuesGenerator.getRandomIntBetween(random, -5, 33);
			int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
			int startYear = ValuesGenerator.RandInt(random);
			String title = "Birthday Party";
			String description = "This is my birthday party.";
			//Construct a new Appointment object with the initial data
			Appt appt = new Appt(startHour,
					startMinute,
					startDay,
					startMonth,
					startYear,
					title,
					description);

			cd.addAppt(appt);

		}




	 }
}
