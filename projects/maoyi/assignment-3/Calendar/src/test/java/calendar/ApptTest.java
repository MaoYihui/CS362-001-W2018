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
		 int startMonth=02;
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

		 int[] recurDaysArr_7 = {1, 2, 3, 4, 5, 6, 7};

		 int[] recurDaysArr_9 = {1, 2, 3, 4, 5, 6};
		 int[] recurDaysArr_10 = {1, 2, 3, 4, 5};
		 int[] recurDaysArr_11 = {1, 2, 3, 4};
		 int[] recurDaysArr_12 = {1, 2, 3};
		 int[] recurDaysArr_13 = {1, 2};
		 int[] recurDaysArr_14 = {1};
		 int[] recurDaysArr_8 = null;

		 /*
		 public int getRecurNumber() {
			 return recurNumber;
		 }

		 public int getRecurBy() {
			 return recurBy;
		 }

		 public int[] getRecurDays() {
			 return recurDays;
		 }

		 public boolean isRecurring() {
			 return getRecurNumber() != RECUR_NUMBER_NEVER;
		 }
		public int getRecurIncrement() {
        return recurIncrement;
    }
*/
		 appt.setRecurrence(recurDaysArr_14, appt.RECUR_BY_WEEKLY, 2, 1000);

		  appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);


		 assertEquals(0,appt.getRecurNumber());
		 assertEquals(2,appt.getRecurBy());
		 assertEquals(0,appt.getRecurIncrement());

		 assertFalse(appt.isRecurring());





	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(02, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());


		 assertEquals("	2/15/2018 at 9:30am ,Birthday Party, This is my birthday party.\n", appt.toString());


		 int startHour_1=11;
		 int startMinute_1=30;
		 int startDay_1=15;
		 int startMonth_1=02;
		 int startYear_1=2018;
		 String title_1="Birthday Party";
		 String description_1="This is my birthday party.";
		 Appt appt_1 = new Appt(startHour_1,
				 startMinute_1 ,
				 startDay_1 ,
				 startMonth_1 ,
				 startYear_1 ,
				 title_1,
				 description_1);

		 assertEquals("	2/15/2018 at 11:30pm ,Birthday Party, This is my birthday party.\n", appt_1.toString());

		 int startHour_2=10;
		 int startMinute_2=29;
		 int startDay_2=14;
		 int startMonth_2=01;
		 int startYear_2=2017;
		 String title_2="Birthday Party";
		 String description_2="This is my birthday party.";
		 Appt appt_2 = new Appt(startHour_2,
				 startMinute_2 ,
				 startDay_2 ,
				 startMonth_2 ,
				 startYear_2 ,
				 title_2,
				 description_2);

		 assertEquals(5,appt_1.compareTo(appt_2));




		 startHour=25;
		 title=null;
		 //STRING TItle="Birthday Party";
		 //String description="This is my birthday party.";
		 Appt appt_11 = new Appt(startHour,
			 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 // assertions



		 assertFalse(appt_11.getValid());



        appt_11.setStartHour(-1 );
		 assertFalse(appt_11.getValid());

		 appt_11.setStartHour(0 );
		 assertTrue(appt_11.getValid());

		 appt_11.setStartHour(11 );
		 assertTrue(appt_11.getValid());

		appt_11.setStartHour(23 );
		assertTrue(appt_11.getValid());
		// appt_11.setStartHour(25);
		// appt_11.setStartHour(24 );
		 //assertFalse(appt_11.getValid());


		 appt_11.setStartMinute(-1 );
		 assertFalse(appt_11.getValid());
		 appt_11.setStartMinute(0 );
		 assertTrue(appt_11.getValid());

		 appt_11.setStartMinute(11 );
		 assertTrue(appt_11.getValid());

		 appt_11.setStartMinute(59 );
		 assertTrue(appt_11.getValid());

		 //appt_11.setStartMinute(61);




		 appt_11.setStartDay(-1);
		 assertFalse(appt_11.getValid());


		 appt_11.setStartDay(1);
		 assertTrue(appt_11.getValid());

		 appt_11.setStartDay(11);
		 assertTrue(appt_11.getValid());

		 appt_11.setStartDay(31);
		 assertTrue(appt_11.getValid());


		 appt_11.setStartDay(32);
		 assertFalse(appt_11.getValid());

		 appt_11.setStartDay(21);

		 appt_11.setStartMonth(1);
		 assertTrue(appt_11.getValid());
		 appt_11.setStartMonth(5);
		 assertTrue(appt_11.getValid());
		 appt_11.setStartMonth(11);
		 assertTrue(appt_11.getValid());


		 appt_11.setStartMinute(-1 );
         assertEquals(null, appt_11.toString());



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
