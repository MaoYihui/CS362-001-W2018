package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;
import org.junit.Test;


import static org.junit.Assert.*;
import java.util.LinkedList;
import java.util.List;




/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {

	/**
	 * Generate Random Tests that tests TimeTable Class.
	 */
	@Test
	public void radnomtest() throws Throwable {

	 	/*

		 LinkedList<Appt> listAppts = new LinkedList<Appt>();

		 int startHour = ValuesGenerator.getRandomIntBetween(random, -2, 25);
		 int startMinute = ValuesGenerator.getRandomIntBetween(random, -5, 61);
		 int startDay = ValuesGenerator.getRandomIntBetween(random, -5, 33);
		 int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
		 int startYear = ValuesGenerator.RandInt(random);
		 String title="Meeting Today";
		 String description="Meeting with the students.";
		 Appt appt = new Appt(startHour,
				 startMinute,
				 startDay,
				 startMonth,
				 startYear,
				 title,
				 description);

		 listAppts.add(appt);
		 */

		 System.out.println("---------------------------------\n");
         System.out.println("The test would takes 30 sec\n");
         System.out.println("---------------------------------\n");

		LinkedList<Appt> listAppts_6 = new LinkedList<Appt>();
		int Y = 2018;
		LinkedList<Appt> listDeletedAppts;
//Mon=1;
		long randomseed = System.currentTimeMillis(); //10
		//			System.out.println(" Seed:"+randomseed );
		Random random = new Random(randomseed);
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		TimeTable timeTable_6 = new TimeTable();
		for (int z = -100; z < 100; z++) {


			//int startHour = ValuesGenerator.getRandomIntBetween(random, -2, 25);
			//int startMinute = ValuesGenerator.getRandomIntBetween(random, -5, 61);
			//int startDay = ValuesGenerator.getRandomIntBetween(random, -5, 33);
			// int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);


			int b = z - 16;
			int H = ValuesGenerator.getRandomIntBetween(random, -25, 25);
			;
			int Min = ValuesGenerator.getRandomIntBetween(random, -25, 61);
			;
			int D = ValuesGenerator.getRandomIntBetween(random, -25, 33);
			;
			int Mon = ValuesGenerator.getRandomIntBetween(random, 1, 11);
			;
			//Y = 2018;
			String Title = "Class";
			String Des = "Rescheduled class.";
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
			long random_seed = System.currentTimeMillis();
			Random rand = new Random(random_seed);
			// int yy = rand.nextInt(3) + 1;
			//for (int ii = 0; ii < yy; ii++)

			int n = rand.nextInt(18) + 1;


			if (n % 17 == 0) {


				appt_7.setRecurrence(recurDaysArr_7, appt_7.RECUR_BY_WEEKLY, 1, 1000);
			} else if (z % 17 == 1) {


				appt_7.setRecurrence(recurDaysArr_8, appt_7.RECUR_BY_WEEKLY, 1, 1000);
			} else if (n % 17 == 2) {


				appt_7.setRecurrence(recurDaysArr_9, appt_7.RECUR_BY_WEEKLY, 1, 1000);
			} else if (n % 17 == 3) {


				appt_7.setRecurrence(recurDaysArr_10, appt_7.RECUR_BY_WEEKLY, 1, 1000);
			} else if (n % 17 == 4) {


				appt_7.setRecurrence(recurDaysArr_11, appt_7.RECUR_BY_WEEKLY, 1, 1000);
			} else if (n % 17 == 5) {


				appt_7.setRecurrence(recurDaysArr_12, appt_7.RECUR_BY_WEEKLY, 1, 1000);
			} else if (n % 17 == 6) {


				appt_7.setRecurrence(recurDaysArr_13, appt_7.RECUR_BY_WEEKLY, 1, 1000);
			} else if (n % 17 == 7) {


				appt_7.setRecurrence(recurDaysArr_14, appt_7.RECUR_BY_WEEKLY, 1, 1000);
			} else if (n % 17 == 8) {


				appt_7.setRecurrence(recurDaysArr_8, appt_7.RECUR_BY_MONTHLY, 1, 1000);
			} else if (n % 17 == 9) {


				appt_7.setRecurrence(recurDaysArr_7, appt_7.RECUR_BY_MONTHLY, 1, b);
			} else if (n % 17 == 10) {


				appt_7.setRecurrence(recurDaysArr_8, appt_7.RECUR_BY_YEARLY, 1, 1000);
			} else if (n % 17 == 11) {


				appt_7.setRecurrence(recurDaysArr_7, appt_7.RECUR_BY_YEARLY, 1, b);
			} else if (n % 17 == 12) {


				appt_7.setRecurrence(recurDaysArr_7, appt_7.RECUR_BY_YEARLY, 1, 0);
			} else if (n % 17 == 13) {


				appt_7.setRecurrence(recurDaysArr_7, appt_7.RECUR_BY_WEEKLY, 1, 0);
			} else if (n % 17 == 14) {


				appt_7.setRecurrence(recurDaysArr_8, appt_7.RECUR_BY_WEEKLY, 1, 0);
			} else if (n % 17 == 15) {


				appt_7.setRecurrence(recurDaysArr_9, appt_7.RECUR_BY_WEEKLY, 1, 0);
			}


			int n_1 = rand.nextInt(2) + 1;
			if (n_1 == 1) {
				listDeletedAppts = timeTable_6.deleteAppt(null, null);
			}



			listAppts_6.add(appt_7);


			listDeletedAppts = timeTable_6.deleteAppt(listAppts_6, listAppts_6.get(0));
			listAppts_6.add(appt_7);
			//Random rand = new Random();

			//int  n = rand.nextInt(11) + 1;
			//LinkedList<Appt> listDeletedAppts=timeTable_6.deleteAppt(listAppts_6, listAppts_6.get(n));


			GregorianCalendar firstday_5 = new GregorianCalendar(Y - 1, 3, 14);
			GregorianCalendar lastday_5 = new GregorianCalendar(Y + 1, 3, 24);

			calDays = timeTable_6.getApptRange(listAppts_6, firstday_5, lastday_5);

			//	 listDeletedAppts = timeTable_6.deleteAppt(listAppts_6, listAppts_6.get(0));
			//listAppts_6.add(appt_7);
			// calDays = timeTable_6.getApptRange(listAppts_6, firstday_5, firstday_5);
			//	 listDeletedAppts = timeTable_6.deleteAppt(listAppts_6, listAppts_6.get(0));
			//listAppts_6.add(appt_7);
			// calDays = timeTable_6.getApptRange(listAppts_6, lastday_5, lastday_5);
			//	 listDeletedAppts = timeTable_6.deleteAppt(listAppts_6, listAppts_6.get(0));
			//listAppts_6.add(appt_7);


			Y++;
			//Mon++;
			// listDeletedAppts = timeTable_6.deleteAppt(listAppts_6, listAppts_6.get(2));
		}
		listDeletedAppts = timeTable_6.deleteAppt(listAppts_6, listAppts_6.get(10));


		//////////////////////////////////
		LinkedList<Appt> listAppts = new LinkedList<Appt>();

		TimeTable timeTable = new TimeTable();
		timeTable.deleteAppt(listAppts, new Appt(2,3,10,10,2011,"a","bb")   );
		//timeTable.deleteAppt(null,null);
		//timeTable.deleteAppt(,null);

		for (int a = 0; a < 10000; a++) {
			long random_seed = System.currentTimeMillis(); //10
			//			System.out.println(" Seed:"+randomseed );
			Random random_1 = new Random(random_seed);
			int startHour = ValuesGenerator.getRandomIntBetween(random_1, -25, 25);
			int startMinute = ValuesGenerator.getRandomIntBetween(random_1, 1, 60);
			int startDay = ValuesGenerator.getRandomIntBetween(random_1, 0, 28);
			int startMonth = ValuesGenerator.getRandomIntBetween(random_1, 1, 11);
			int startYear = ValuesGenerator.getRandomIntBetween(random_1, 2000, 2018);
			// String title = ValuesGenerator.getString(random);
			// String description = ValuesGenerator.getString(random);
			String title = "Class";
			String description = "class sa";


//			if (a % 5 != 1) {
	Appt appt = new Appt(startHour,
			startMinute,
			startDay,
			startMonth,
			startYear,
			title,
			description);

	//listDeletedAppts = timeTable.deleteAppt(listAppts, listAppts.get(0));
	listAppts.add(appt);
	//System.out.println(listAppts.size());
	//listAppts.add(appt);
	//listDeletedAppts = timeTable.deleteAppt(listAppts, listAppts.get(0));
	//listAppts.add(appt);

//		    }

	//else {
	//listAppts.add(null);
	//	listDeletedAppts = timeTable.deleteAppt(listAppts,null);
	// listAppts.add(null);
	//}


		}
		// int c=random.nextInt(1000);


		for (int c=0;c<1000;c++) {

			//long random_seed_1 = System.currentTimeMillis(); //10
			//			System.out.println(" Seed:"+randomseed );
			Random random_2 = new Random();
			//	int z=ValuesGenerator.RandInt(random_2);
			int z = random_2.nextInt(5000);

			if (listAppts.size() > z) {
				//System.out.println("z:" + z + "////////////////////////////////////////\n" + listAppts.size());
				listDeletedAppts = timeTable.deleteAppt(listAppts, listAppts.get(z));
			}
			//listDeletedAppts = timeTable.deleteAppt(listAppts, null);

//
			LinkedList<Appt> listAppts_1 = new LinkedList<Appt>();
			TimeTable timeTable_1 = new TimeTable();
			timeTable_1.deleteAppt(listAppts_1, new Appt(2, 3, 10, 10, 2011, "a", "bb"));
			timeTable_1.deleteAppt(null, null);

			Appt appt_1 = new Appt(2, 3, 10, 10, 2011, "a", "bb");

			//listDeletedAppts = timeTable.deleteAppt(listAppts, listAppts.get(0));
			listAppts.add(appt_1);
			listDeletedAppts = timeTable.deleteAppt(listAppts_1, null);

		}





	}


}