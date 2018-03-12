package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {


	 @Test
	  public void test01()  throws Throwable  {

		 LinkedList<Appt> listAppts = new LinkedList<Appt>();

		 GregorianCalendar today_1 = new GregorianCalendar(2018,1,25);
		 GregorianCalendar tomorrow_1 = new GregorianCalendar(2018,1,26);




		 TimeTable timeTable_1=new TimeTable();
		 LinkedList<CalDay> calDays_1 = new LinkedList<CalDay>();
		 calDays_1= new LinkedList<CalDay>();




		 calDays_1 = timeTable_1.getApptRange(listAppts, today_1, tomorrow_1);

		 LinkedList<Appt> listAppts_0 = new LinkedList<Appt>();
		 int startHour_0=22;
		 int startMinute_0=11;
		 int startDay_0=1;
		 int startMonth_0=2;
		 int startYear_0=2018;
		 String title_0="aaa";
		 String description_0="bbb";
		 //Construct a new Appointment object with the initial data
		 Appt appt_01 = new Appt(startHour_0,
				 startMinute_0,
				 startDay_0 ,
				 startMonth_0 ,
				 startYear_0 ,
				 title_0,
				 description_0);

		 listAppts_0.add(appt_01);



		  startHour_0=22;
		  startMinute_0=-1;
		  startDay_0=1;
		  startMonth_0=2;
		  startYear_0=2018;
		 title_0=null;
		 description_0=null;
		 //Construct a new Appointment object with the initial data
		 Appt appt_0 = new Appt(startHour_0,
				 startMinute_0,
				 startDay_0 ,
				 startMonth_0 ,
				 startYear_0 ,
				 title_0,
				 description_0);
		 listAppts_0.add(appt_0);



		 startHour_0=22;
		 startMinute_0=20;
		 startDay_0=3;
		 startMonth_0=4;
		 startYear_0=2018;
		 title_0="qqq";
		 description_0="kkkk";
		 //Construct a new Appointment object with the initial data
		 Appt appt_20 = new Appt(startHour_0,
				 startMinute_0,
				 startDay_0 ,
				 startMonth_0 ,
				 startYear_0 ,
				 title_0,
				 description_0);
		 listAppts_0.add(appt_20);
		 //listAppts_0.add(null);








		 TimeTable timeTable_0=new TimeTable();
		 LinkedList<CalDay> calDays_0 = new LinkedList<CalDay>();
		 calDays_0= new LinkedList<CalDay>();




		 calDays_0 = timeTable_0.getApptRange(listAppts_0, today_1, tomorrow_1);


		 LinkedList<Appt> listAppts_15 = new LinkedList<Appt>();

		 //listAppts_15.add(null);

		 LinkedList<CalDay> calDays_15 = new LinkedList<CalDay>();
		 calDays_15= new LinkedList<CalDay>();

		 listAppts_15.add(appt_20);
		calDays_15 = timeTable_0.getApptRange(listAppts_15, tomorrow_1, today_1);

		// assertEquals (25,calDays_15.get(0).getDay());
		 calDays_15 = timeTable_0.getApptRange(listAppts_15, today_1, tomorrow_1);
		 assertNotEquals (3,calDays_15.get(0).getDay());
		 calDays_15 = timeTable_0.getApptRange(listAppts_15, today_1, today_1);






		 int startHour=15;
		 int startMinute=30;
		 int startDay=25;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 listAppts.add(appt);

		 int[] recurDaysArr_2={2,3,4};
		 appt.setRecurrence( recurDaysArr_2, Appt.RECUR_BY_YEARLY,1 , Appt.RECUR_NUMBER_FOREVER);






		 startHour=13;
		 startMinute=30;
		 startDay=26;
		 startMonth=01;
		 startYear=2018;
		 title="Meeting Today";
		 description="Meeting with the students.";
		 //Construct a new Appointment object with the initial data
		 Appt appt_1 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 listAppts.add(appt_1);
		 int[] recurDaysArr_1={2,3,4};
		 appt_1.setRecurrence( recurDaysArr_1, Appt.RECUR_BY_MONTHLY,2 , Appt.RECUR_NUMBER_FOREVER);


		 startHour=13;
		 startMinute=30;
		 startDay=27;
		 startMonth=01;
		 startYear=2018;
		 title="Meeting Today";
		 description="Meeting with the students.";
		 //Construct a new Appointment object with the initial data
		 Appt appt_2 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 int[] recurDaysArr={2,3,4};
		 appt_2.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);

		 listAppts.add(appt_2);

		 GregorianCalendar today = new GregorianCalendar(2018,1,25);
		 GregorianCalendar tomorrow = new GregorianCalendar(2020,12,5);


		 TimeTable timeTable=new TimeTable();
		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		 calDays = new LinkedList<CalDay>();

		 calDays = timeTable.getApptRange(listAppts, today, tomorrow);


		assertEquals (25,calDays.get(0).getDay());
		 LinkedList<Appt> listDeletedAppts=timeTable.deleteAppt(listAppts, listAppts.get(0));
         assertEquals(null,listDeletedAppts);
		 LinkedList<Appt> listDeletedAppts_1=timeTable.deleteAppt(listAppts, listAppts.get(1));
		 assertNotEquals (1,listDeletedAppts_1.size());







	 }
	 @Test
	  public void test02()  throws Throwable  {

		 LinkedList<Appt> listAppts = new LinkedList<Appt>();

		int startHour=13;
		int startMinute=30;
		int startDay=27;
		int startMonth=01;
		int startYear=2018;
		String title="Meeting Today";
		String description="Meeting with the students.";
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 listAppts.add(appt);

		 int[] recurringDays_1 = new int[0];
		 appt.setRecurrence(recurringDays_1, appt.RECUR_BY_WEEKLY, 2, 3);


		  startHour=13;
		  startMinute=30;
		  startDay=28;
		  startMonth=01;
		  startYear=2018;
		  title="Meeting Today";
		  description="Meeting with the students.";
		 //Construct a new Appointment object with the initial data
		 Appt appt_1 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 listAppts.add(appt_1);
		 //GregorianCalendar today = new GregorianCalendar(2018,1,25);
		 //GregorianCalendar tomorrow = new GregorianCalendar(2020,12,5);
		 int[] recurringDays = new int[0];
		appt_1.setRecurrence(recurringDays, appt_1.RECUR_BY_WEEKLY, 0, appt_1.RECUR_NUMBER_NEVER);











		 TimeTable timeTable=new TimeTable();
		 GregorianCalendar today = new GregorianCalendar(2018,1,25);
		 GregorianCalendar yesterday = new GregorianCalendar(2018,1,24);
		 GregorianCalendar tomorrow = new GregorianCalendar(2020,12,5);
		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		 calDays = new LinkedList<CalDay>();

		 calDays = timeTable.getApptRange(listAppts, today, tomorrow);


		 assertEquals (25,calDays.get(0).getDay());
		 calDays = timeTable.getApptRange(listAppts, tomorrow, today);

		 calDays = timeTable.getApptRange(listAppts, yesterday, today);
		 assertEquals (24,calDays.get(0).getDay());
		 calDays = timeTable.getApptRange(listAppts, today, yesterday);



		 int []pv={1,0};
		 LinkedList<Appt> list= timeTable.permute(listAppts,pv);

		 assertEquals(  27,list.get(0).getStartDay());








	 }


//add more unit tests as you needed

	@Test
	public void test03()  throws Throwable {

		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = new LinkedList<CalDay>();


		//2018/3/12/14:30
		int H = 14;
		int Min = 30;
		int D = 12;
		int Mon = 3;
		int Y = 2018;
		String Title = "Class";
		String Des = "Rescheduled class.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(H,
				Min,
				D,
				Mon,
				Y,
				Title,
				Des);

		int[] recurDaysArr = {1, 2, 3, 4};
		appt.setRecurrence(recurDaysArr, appt.RECUR_BY_WEEKLY, 2, 0);
		listAppts.add(appt);


		//2018/3/12/15:30

		H = 15;
		Min = 30;
		D = 12;
		Mon = 3;
		Y = 2018;
		Title = "Class";
		Des = "Rescheduled class.";
		//Construct a new Appointment object with the initial data
		Appt appt_1 = new Appt(H,
				Min,
				D,
				Mon,
				Y,
				Title,
				Des);
		int[] recurDaysArr_1 = {1, 2, 3, 4};
		appt_1.setRecurrence(recurDaysArr_1, appt_1.RECUR_BY_WEEKLY, 2, 2);

		listAppts.add(appt_1);


		H = 13;
		Min = 30;
		D = 12;
		Mon = 3;
		Y = 2018;
		Title = "Class";
		Des = "Rescheduled class.";
		//Construct a new Appointment object with the initial data
		Appt appt_2 = new Appt(H,
				Min,
				D,
				Mon,
				Y,
				Title,
				Des);
		int[] recurDaysArr_2 = {1, 2, 3, 4};
		appt_2.setRecurrence(recurDaysArr_2, appt_2.RECUR_BY_WEEKLY, 2, appt_2.RECUR_NUMBER_FOREVER);

		listAppts.add(appt_2);


		H = 13;
		Min = 30;
		D = 25;
		Mon = 3;
		Y = 2018;
		Title = "Class";
		Des = "Rescheduled class.";
		//Construct a new Appointment object with the initial data
		Appt appt_3 = new Appt(H,
				Min,
				D,
				Mon,
				Y,
				Title,
				Des);
		int[] recurDaysArr_3 = {1, 2, 3, 4};
		appt_3.setRecurrence(recurDaysArr_3, appt_3.RECUR_BY_WEEKLY, 1, 5);

		listAppts.add(appt_3);


		TimeTable timeTable = new TimeTable();
		GregorianCalendar today = new GregorianCalendar(2018, 3, 10);
		GregorianCalendar today_2 = new GregorianCalendar(2018, 3, 12);

		GregorianCalendar tomorrow = new GregorianCalendar(2018, 3, 20);

		GregorianCalendar today_1 = new GregorianCalendar(2018, 3, 19);
		GregorianCalendar tomorrow_1 = new GregorianCalendar(2018, 5, 19);

		calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		calDays = timeTable.getApptRange(listAppts, today, today_2);
		calDays = timeTable.getApptRange(listAppts, today_2, today_2);


		calDays = timeTable.getApptRange(listAppts, tomorrow, today);
		calDays = timeTable.getApptRange(listAppts, today_1, tomorrow_1);
//////////////////////////////////////////////////////////////
		LinkedList<Appt> listAppts_1 = new LinkedList<Appt>();

		H = 13;
		Min = 30;
		D = 7;
		Mon = 3;
		Y = 2018;
		Title = "Class";
		Des = "Rescheduled class.";
		//Construct a new Appointment object with the initial data
		Appt appt_4 = new Appt(H,
				Min,
				D,
				Mon,
				Y,
				Title,
				Des);
		int[] recurDaysArr_4 = {1, 2, 3, 4};
		appt_4.setRecurrence(recurDaysArr_4, appt_4.RECUR_BY_MONTHLY, 1, 5);

		listAppts_1.add(appt_4);


		TimeTable timeTable_1 = new TimeTable();
		GregorianCalendar firstday = new GregorianCalendar(2018, 3, 14);
		GregorianCalendar lastday = new GregorianCalendar(2018, 3, 24);
		calDays = timeTable_1.getApptRange(listAppts_1, firstday, lastday);
/*            --------------------------------------------------------------     */

		LinkedList<Appt> listAppts_2 = new LinkedList<Appt>();

		H = 13;
		Min = 30;
		D = 7;
		Mon = 3;
		Y = 2018;
		Title = "Class";
		Des = "Rescheduled class.";
		//Construct a new Appointment object with the initial data
		Appt appt_5 = new Appt(H,
				Min,
				D,
				Mon,
				Y,
				Title,
				Des);
		int[] recurDaysArr_5 = {1, 2, 3, 4};
		for (int a = -2; a < 5; a++) {
			appt_5.setRecurrence(recurDaysArr_5, appt_5.RECUR_BY_WEEKLY, 1, -5);

			listAppts_2.add(appt_5);
		}

		TimeTable timeTable_2 = new TimeTable();
		GregorianCalendar firstday_1 = new GregorianCalendar(2018, 3, 14);
		GregorianCalendar lastday_1 = new GregorianCalendar(2018, 3, 24);
		calDays = timeTable_2.getApptRange(listAppts_2, firstday_1, lastday_1);



/*            --------------------------------------------------------------     */

		LinkedList<Appt> listAppts_3 = new LinkedList<Appt>();

		H = 13;
		Min = 30;
		D = 13;
		Mon = 3;
		Y = 2018;
		Title = "Class";
		Des = "Rescheduled class.";
		//Construct a new Appointment object with the initial data
		Appt appt_6 = new Appt(H,
				Min,
				D,
				Mon,
				Y,
				Title,
				Des);
		int[] recurDaysArr_6 = {1, 2, 3, 4, 5, 6, 7};

		appt_6.setRecurrence(recurDaysArr_6, appt_6.RECUR_BY_WEEKLY, 1, 5);

		listAppts_3.add(appt_6);


		TimeTable timeTable_3 = new TimeTable();
		GregorianCalendar firstday_2 = new GregorianCalendar(2018, 3, 14);
		GregorianCalendar lastday_2 = new GregorianCalendar(2018, 4, 24);
		calDays = timeTable_3.getApptRange(listAppts_3, firstday_2, lastday_2);
		calDays = timeTable_3.getApptRange(listAppts_3, firstday_2, firstday_2);
		calDays = timeTable_3.getApptRange(listAppts_3, lastday_2, firstday_2);


		/*___________________________________________________*/


		LinkedList<Appt> listAppts_4 = new LinkedList<Appt>();

		TimeTable timeTable_4 = new TimeTable();
		for (int z = 13; z < 28; z++) {
			int b = z - 16;
			H = 13;
			Min = 30;
			D = z;
			Mon = 3;
			Y = 2018;
			Title = "Class";
			Des = "Rescheduled class.";
			//Construct a new Appointment object with the initial data
			Appt appt_7 = new Appt(H,
					Min,
					D,
					Mon,
					Y,
					Title,
					Des);
			int[] recurDaysArr_7 = {1, 2, 3, 4, 5, 6, 7};
			if (z % 2 == 0) {
				appt_7.setRecurrence(recurDaysArr_7, appt_6.RECUR_BY_WEEKLY, 1, 1000);
			} else {
				appt_7.setRecurrence(recurDaysArr_7, appt_6.RECUR_BY_WEEKLY, 1, 0);
			}

			listAppts_4.add(appt_7);


			GregorianCalendar firstday_3 = new GregorianCalendar(2018, 3, 14);
			GregorianCalendar lastday_3 = new GregorianCalendar(2018, 4, 24);

			calDays = timeTable_4.getApptRange(listAppts_4, firstday_3, lastday_3);
		}

/*___________________________________________________*/


		LinkedList<Appt> listAppts_5 = new LinkedList<Appt>();

		TimeTable timeTable_5 = new TimeTable();
		for (int z = 13; z < 28; z++) {
			int b = z - 16;
			H = 13;
			Min = 30;
			D = z;
			Mon = 3;
			Y = 2018;
			Title = "Class";
			Des = "Rescheduled class.";
			//Construct a new Appointment object with the initial data
			Appt appt_7 = new Appt(H,
					Min,
					D,
					Mon,
					Y,
					Title,
					Des);
			int[] recurDaysArr_7 = {1, 2, 3, 4, 5, 6, 7};
			if (z % 2 == 0) {
				appt_7.setRecurrence(null, appt_7.RECUR_BY_WEEKLY, 1, 1000);
			} else {
				appt_7.setRecurrence(recurDaysArr_7, appt_7.RECUR_BY_WEEKLY, 1, 1000);
			}

			listAppts_5.add(appt_7);


			GregorianCalendar firstday_4 = new GregorianCalendar(2018, 3, 14);
			GregorianCalendar lastday_4 = new GregorianCalendar(2018, 6, 24);

			calDays = timeTable_5.getApptRange(listAppts_5, firstday_4, lastday_4);

		}


/*___________________________________________________*/


		LinkedList<Appt> listAppts_6 = new LinkedList<Appt>();
		Y = 2018;
		LinkedList<Appt> listDeletedAppts;
//Mon=1;
		TimeTable timeTable_6 = new TimeTable();
		for (int z = -10; z < 100; z++) {
			int b = z - 16;
			H = 13;
			Min = 30;
			D = z;
			Mon = 3;
			//Y = 2018;
			Title = "Class";
			Des = "Rescheduled class.";
			//Construct a new Appointment object with the initial data
			Appt appt_7 = new Appt(H,
					Min,
					D,
					Mon,
					Y,
					Title,
					Des);
			int[] recurDaysArr_7 = {1, 2, 3, 4, 5, 6, 7};

			int[] recurDaysArr_9 = {1, 2, 3, 4, 5, 6};
			int[] recurDaysArr_10 = {1, 2, 3, 4, 5};
			int[] recurDaysArr_11 = {1, 2, 3, 4};
			int[] recurDaysArr_12 = {1, 2, 3};
			int[] recurDaysArr_13 = {1, 2};
			int[] recurDaysArr_14 = {1};
			int[] recurDaysArr_8 = null;
			Random rand = new Random();
			int yy = rand.nextInt(3) + 1;
			for (int ii = 0; ii < yy; ii++) {

				int n = rand.nextInt(1000) + 1;
				if (n % 16 == 0) {


					appt_7.setRecurrence(recurDaysArr_7, appt_7.RECUR_BY_WEEKLY, 1, 1000);
				} else if (z % 16 == 1) {


					appt_7.setRecurrence(recurDaysArr_8, appt_7.RECUR_BY_WEEKLY, 1, 1000);
				} else if (n % 16 == 2) {


					appt_7.setRecurrence(recurDaysArr_9, appt_7.RECUR_BY_WEEKLY, 1, 1000);
				} else if (n % 16 == 3) {


					appt_7.setRecurrence(recurDaysArr_10, appt_7.RECUR_BY_WEEKLY, 1, 1000);
				} else if (n % 16 == 4) {


					appt_7.setRecurrence(recurDaysArr_11, appt_7.RECUR_BY_WEEKLY, 1, 1000);
				} else if (n % 16 == 5) {


					appt_7.setRecurrence(recurDaysArr_12, appt_7.RECUR_BY_WEEKLY, 1, 1000);
				} else if (n % 16 == 6) {


					appt_7.setRecurrence(recurDaysArr_13, appt_7.RECUR_BY_WEEKLY, 1, 1000);
				} else if (n % 16 == 7) {


					appt_7.setRecurrence(recurDaysArr_14, appt_7.RECUR_BY_WEEKLY, 1, 1000);
				} else if (n % 16 == 8) {


					appt_7.setRecurrence(recurDaysArr_8, appt_7.RECUR_BY_MONTHLY, 1, 1000);
				} else if (n % 16 == 9) {


					appt_7.setRecurrence(recurDaysArr_7, appt_7.RECUR_BY_MONTHLY, 1, b);
				} else if (n % 16 == 10) {


					appt_7.setRecurrence(recurDaysArr_8, appt_7.RECUR_BY_YEARLY, 1, 1000);
				} else if (n % 16 == 11) {


					appt_7.setRecurrence(recurDaysArr_7, appt_7.RECUR_BY_YEARLY, 1, b);
				} else if (n % 16 == 12) {


					appt_7.setRecurrence(recurDaysArr_7, appt_7.RECUR_BY_YEARLY, 1, 0);
				} else if (n % 16 == 13) {


					appt_7.setRecurrence(recurDaysArr_7, appt_7.RECUR_BY_WEEKLY, 1, 0);
				} else if (n % 16 == 14) {


					appt_7.setRecurrence(recurDaysArr_8, appt_7.RECUR_BY_WEEKLY, 1, 0);
				} else if (n % 16 == 15) {


					appt_7.setRecurrence(recurDaysArr_9, appt_7.RECUR_BY_WEEKLY, 1, 0);
				}


				listAppts_6.add(appt_7);

				listDeletedAppts = timeTable_6.deleteAppt(listAppts_6, listAppts_6.get(0));
				listAppts_6.add(appt_7);
				//Random rand = new Random();
			}
			//int  n = rand.nextInt(11) + 1;
			//LinkedList<Appt> listDeletedAppts=timeTable_6.deleteAppt(listAppts_6, listAppts_6.get(n));


			GregorianCalendar firstday_5 = new GregorianCalendar(Y - 1, 3, 14);
			GregorianCalendar lastday_5 = new GregorianCalendar(Y + 1, 3, 24);

			calDays = timeTable_6.getApptRange(listAppts_6, firstday_5, lastday_5);

			listDeletedAppts = timeTable_6.deleteAppt(listAppts_6, listAppts_6.get(0));
			listAppts_6.add(appt_7);
			calDays = timeTable_6.getApptRange(listAppts_6, firstday_5, firstday_5);
			listDeletedAppts = timeTable_6.deleteAppt(listAppts_6, listAppts_6.get(0));
			listAppts_6.add(appt_7);
			calDays = timeTable_6.getApptRange(listAppts_6, lastday_5, lastday_5);
			listDeletedAppts = timeTable_6.deleteAppt(listAppts_6, listAppts_6.get(0));
			listAppts_6.add(appt_7);

			Y++;
			//Mon++;

		}


		/*            --------------------------------------------------------------     */


		LinkedList<Appt> listAppts_7 = new LinkedList<Appt>();

		TimeTable timeTable_7 = new TimeTable();


		Random rand = new Random();

		for (int zz = 0; zz < 100; zz++) {

			int mintue_1 = rand.nextInt(60) - 30;
			int hours_1 = rand.nextInt(200) - 100;
			int day_1 = rand.nextInt(100) - 50;
			int month_1 = rand.nextInt(11) + 1;
			int year_1 = rand.nextInt(20) + 2000;
			Appt appt_8 = new Appt(hours_1,
					mintue_1,
					day_1,
					month_1,
					year_1,
					Title,
					Des);

			int[] recurDaysArr_7 = {1, 2, 3, 4, 5, 6, 7};

			int[] recurDaysArr_9 = {1, 2, 3, 4, 5, 6};
			int[] recurDaysArr_10 = {1, 2, 3, 4, 5};
			int[] recurDaysArr_11 = {1, 2, 3, 4};
			int[] recurDaysArr_12 = {1, 2, 3};
			int[] recurDaysArr_13 = {1, 2};
			int[] recurDaysArr_14 = {1};
			int[] recurDaysArr_8 = null;


			int tt = rand.nextInt(60);
			int cc = rand.nextInt(7);

			if (tt % 12 == 0)
				appt_8.setRecurrence(recurDaysArr_8, appt_8.RECUR_BY_WEEKLY, cc, tt);
			else if (tt % 12 == 1)
				appt_8.setRecurrence(recurDaysArr_7, appt_8.RECUR_BY_WEEKLY, cc, tt);
			else if (tt % 12 == 2)
				appt_8.setRecurrence(recurDaysArr_9, appt_8.RECUR_BY_WEEKLY, cc, tt);
			else if (tt % 12 == 3)
				appt_8.setRecurrence(recurDaysArr_10, appt_8.RECUR_BY_MONTHLY, cc, tt);
			else if (tt % 12 == 4)
				appt_8.setRecurrence(recurDaysArr_11, appt_8.RECUR_BY_YEARLY, cc, tt);

			listAppts_7.add(appt_8);

			GregorianCalendar firstday_6 = new GregorianCalendar(2000, month_1 - 1, 1);
			GregorianCalendar lastday_6 = new GregorianCalendar(2020, month_1 + 1, 28);

			calDays = timeTable_6.getApptRange(listAppts_7, firstday_6, lastday_6);

		}


	}


}
