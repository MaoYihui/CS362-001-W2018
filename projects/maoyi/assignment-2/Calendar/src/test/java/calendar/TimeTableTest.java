package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {

		 LinkedList<Appt> listAppts = new LinkedList<Appt>();


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


		// assertNEquals();
	 	/*
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 TimeTable timeTable=new TimeTable();


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
		 listAppts.add(appt);

		 int startHour_1=10;
		 int startMinute_1=20;
		 int startDay_1=16;
		 int startMonth_1=01;
		 int startYear_1=2018;
		 String title_1="fun";
		 String description_1="have fun.";
		 Appt appt_1 = new Appt(startHour_1,
				 startMinute_1 ,
				 startDay_1 ,
				 startMonth_1 ,
				 startYear_1 ,
				 title_1,
				 description_1);




		 listAppts.add(appt_1);
		 //LinkedList<CalDay> calDays = new LinkedList<CalDay>();

		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();

		 //Calendar rightnow = Calendar.getInstance();
		 //current month/year/date is today


		 int thisMonth;


		 int thisYear;


		 int thisDay;
		 thisMonth = 01;
		 thisYear = 2018;
		 thisDay = 15;
		 GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);

		 GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		 tomorrow.add(Calendar.DAY_OF_MONTH,1);

		 calDays = timeTable.getApptRange(listAppts, today, tomorrow);


		 assertEquals(appt.toString(),calDays.get(0).getAppts().get(0).toString());

*/




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
}
