package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
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
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
                 

	 }

	 @Test
	  public void test02()  throws Throwable  {
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
		 appt.setStartHour(24);
		 appt.setStartMinute(24);
		 appt.setStartDay(24);
		 appt.setStartMonth(06);
		 appt.setStartYear(2017);
		 appt.setTitle("break");
		 appt.setDescription("This is a break");

                assertEquals(24,appt.getStartHour());
                assertEquals(24,appt.getStartMinute());
                assertEquals(24,appt.getStartDay());
                assertEquals(06,appt.getStartMonth());
                assertEquals(2017,appt.getStartYear());
                assertEquals("break",appt.getTitle());
		        assertEquals("This is a break",appt.getDescription());



		 
	 }
   @Test
	public void test03()  throws Throwable {
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";

		Appt appt_1 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);






		assertEquals(0  ,appt_1.compareTo(appt_1));

	}

	@Test
	public void test04()  throws Throwable {
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

		Appt appt_1 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		int recurDays[]={1,2,3};
		int recurBy=2;
		int recurIncrement=1;
		int recurNumber=2;
		appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);

		assertEquals(2,appt.getRecurNumber());
		assertEquals(2,appt.getRecurBy());
		assertEquals(1,appt.getRecurIncrement());

		assertTrue(appt.isRecurring());


		recurNumber=0;
		appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
		assertFalse(appt.isRecurring());
		assertEquals(appt_1.toString(),appt.toString()  );
        assertNotEquals("aaa",appt.toString()  );
		assertEquals(recurDays, appt.getRecurDays());


		int startHour_1=01;
		int startMinute_1=30;
		int startDay_1=15;
		int startMonth_1=01;
		int startYear_1=2018;
		String title_1="Birthday Party";
		String description_1="This is my birthday party.";

		int start_hour_0=0;

		Appt appt_2 = new Appt(startHour_1,
				startMinute_1,
				startDay_1 ,
				startMonth_1 ,
				startYear_1 ,
				title_1,
				description_1);

		Appt appt_3 = new Appt(start_hour_0,
				startMinute_1,
				startDay_1 ,
				startMonth_1 ,
				startYear_1 ,
				title_1,
				description_1);



		assertNotEquals("aaa",appt_2.toString()  );
		assertNotEquals("aaa",appt_3.toString()  );

      int startMinute_2=61;
		Appt appt_4 = new Appt(start_hour_0,
				startMinute_2,
				startDay_1 ,
				startMonth_1 ,
				startYear_1 ,
				title_1,
				description_1);

		assertFalse(appt_4.getValid());

		int startDay_2=61;

		Appt appt_5 = new Appt(start_hour_0,
				startMinute_1,
				startDay_2 ,
				startMonth_1 ,
				startYear_1 ,
				title_1,
				description_1);
		assertFalse(appt_5.getValid());

		 startDay_2=0;

		Appt appt_6 = new Appt(start_hour_0,
				startMinute_1,
				startDay_2 ,
				startMonth_1 ,
				startYear_1 ,
				title_1,
				description_1);
		assertFalse(appt_6.getValid());

		int startMonth_2=0;

		Appt appt_7 = new Appt(start_hour_0,
				startMinute_1,
				startDay_1 ,
				startMonth_2 ,
				startYear_1 ,
				title_1,
				description_1);
		assertFalse(appt_7.getValid());

		int startMinute_3=-1;

		Appt appt_8 = new Appt(start_hour_0,
				startMinute_3,
				startDay_1 ,
				startMonth_1 ,
				startYear_1 ,
				title_1,
				description_1);
		assertFalse(appt_8.getValid());




	}

//add more unit tests as you needed
	
}
