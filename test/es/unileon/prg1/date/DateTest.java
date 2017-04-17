package es.unileon.prg1.date;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DateTest {
	
	Date today;

	@Before
	public void setUp() throws Exception {
		today = new Date(1,1,2017);
	}

	@Test
	public void testDate() throws DateException{
		today = new Date();
		assertEquals(1, today.getDay());
		assertEquals(1, today.getMonth());
		assertEquals(2017, today.getYear());
	}

	@Test
	public void testDateIntIntInt() throws DateException{
		assertEquals(1, today.getDay());
		assertEquals(1, today.getMonth());
		assertEquals(2017, today.getYear());
	}

	@Test(expected = DateException.class)
	public void testDateNegativeDay() throws DateException{
		new Date(-1,1,2017);
	}

	@Test(expected = DateException.class)
	public void testDateNegativeMonth() throws DateException{
		new Date(1,-1,2017);
	}

	@Test(expected = DateException.class)
	public void testDateMonthOutOfRange() throws DateException{
		new Date(1,13,2017);
	}

	@Test(expected = DateException.class)
	public void testDateWrongDayMonth() throws DateException{
		new Date(31,2,2017);
	}

	@Test(expected = DateException.class)
	public void testDateNegativeYear() throws DateException{
		new Date(1,1,-1);
	}

	@Test
	public void testDateDate() {
		Date aDay;
		aDay = new Date(today);
		assertEquals(1, aDay.getDay());
		assertEquals(1, aDay.getMonth());
		assertEquals(2017, aDay.getYear());
	}

	@Test
	public void testSetGetDay() throws DateException{
		assertEquals(1, today.getDay());
		today.setDay(2);
		assertEquals(2, today.getDay());
	}

	@Test(expected = DateException.class)
	public void testSetDayNegativeDay() throws DateException{
		today.setDay(-1);
	}
	
	@Test(expected = DateException.class)
	public void testSetDayWrongDayMonth() throws DateException{
		today.setMonth(4);
		today.setDay(31);
	}

	@Test
	public void testSetGetMonth() throws DateException{
		assertEquals(1, today.getMonth());
		today.setMonth(2);
		assertEquals(2, today.getMonth());
	}

	@Test(expected = DateException.class)
	public void testSetMonthNegative() throws DateException{
		today.setMonth(-1);
	}

	@Test(expected = DateException.class)
	public void testSetMonthOutOfRange() throws DateException{
		today.setMonth(13);
	}

	@Test
	public void testSetGetYear() throws DateException{
		assertEquals(2017, today.getYear());
		today.setYear(2013);
		assertEquals(2013, today.getYear());
	}

	@Test(expected = DateException.class)
	public void testSetYearNegative() throws DateException{
		today.setYear(-1);
	}

	@Test
	public void testTomorrow() {
		assertEquals(1, today.getDay());
		assertEquals(1, today.getMonth());
		assertEquals(2017, today.getYear());
		Date tomorrow = today.tomorrow();
		assertEquals(2, tomorrow.getDay());
		assertEquals(1, tomorrow.getMonth());
		assertEquals(2017, tomorrow.getYear());
	}

	@Test
	public void testTomorrowLastDayOfMonth() throws DateException{
		Date aDay = new Date (28,2,2017);
		assertEquals(28, aDay.getDay());
		assertEquals(2, aDay.getMonth());
		assertEquals(2017, aDay.getYear());
		Date tomorrow = aDay.tomorrow();
		assertEquals(1, tomorrow.getDay());
		assertEquals(3, tomorrow.getMonth());
		assertEquals(2017, tomorrow.getYear());
	}

	@Test
	public void testTomorrowLastDayOfYear() throws DateException{
		Date aDay = new Date (31,12,2017);
		assertEquals(31, aDay.getDay());
		assertEquals(12, aDay.getMonth());
		assertEquals(2017, aDay.getYear());
		Date tomorrow = aDay.tomorrow();
		assertEquals(1, tomorrow.getDay());
		assertEquals(1, tomorrow.getMonth());
		assertEquals(2018, tomorrow.getYear());
	}

	@Test
	public void testIsSameDayTrue() throws DateException{
		Date aDay = new Date (1,4,2017);
		assertEquals(true, today.isSameDay(aDay));
	}

	@Test
	public void testIsSameDayFalse() throws DateException{
		Date aDay = new Date (7,4,2017);
		assertEquals(false, today.isSameDay(aDay));
	}

	@Test
	public void testIsSameMonthTrue() throws DateException{
		Date aDay = new Date (8,1,2017);
		assertEquals(true, today.isSameMonth(aDay));
	}

	@Test
	public void testIsSameMonthFalse() throws DateException{
		Date aDay = new Date (8,9,2017);
		assertEquals(false, today.isSameMonth(aDay));
	}

	@Test
	public void testIsSameYearTrue() throws DateException{
		Date aDay = new Date (8,9,2017);
		assertEquals(true, today.isSameYear(aDay));
	}

	@Test
	public void testIsSameYearFalse() throws DateException{
		Date aDay = new Date (8,9,2010);
		assertEquals(false, today.isSameYear(aDay));
	}

	@Test
	public void testIsSame() throws DateException{
		Date aDay = new Date (1,1,2017);
		assertEquals(true, today.isSame(aDay));
	}

	@Test
	public void testIsSameNotDay() throws DateException{
		Date aDay = new Date (10,1,2017);
		assertEquals(false, today.isSame(aDay));
	}

	@Test
	public void testIsSameNotMonth() throws DateException{
		Date aDay = new Date (1,10,2017);
		assertEquals(false, today.isSame(aDay));
	}

	@Test
	public void testIsSameNotYear() throws DateException{
		Date aDay = new Date (1,1,2010);
		assertEquals(false, today.isSame(aDay));
	}

	@Test
	public void testIsSameNotDayNotMonthNotYear() throws DateException{
		Date aDay = new Date (3,3,2013);
		assertEquals(false, today.isSame(aDay));
	}

	@Test
	public void testGetMonthName() throws DateException{
		assertEquals("January", today.getMonthName());
		today.setMonth(2);
		assertEquals("February", today.getMonthName());
		today.setMonth(3);
		assertEquals("March", today.getMonthName());
		today.setMonth(4);
		assertEquals("April", today.getMonthName());
		today.setMonth(5);
		assertEquals("May", today.getMonthName());
		today.setMonth(6);
		assertEquals("June", today.getMonthName());
		today.setMonth(7);
		assertEquals("July", today.getMonthName());
		today.setMonth(8);
		assertEquals("August", today.getMonthName());
		today.setMonth(9);
		assertEquals("September", today.getMonthName());
		today.setMonth(10);
		assertEquals("October", today.getMonthName());
		today.setMonth(11);
		assertEquals("November", today.getMonthName());
		today.setMonth(12);
		assertEquals("December", today.getMonthName());
	}

	@Test
	public void testDaysOfMonth() throws DateException{
		assertEquals(31, today.daysOfMonth());
		today.setMonth(4);
		assertEquals(30, today.daysOfMonth());
		today.setMonth(2);
		assertEquals(28, today.daysOfMonth());
	}

	@Test
	public void testGetSeasonName() throws DateException{
		assertEquals("Winter", today.getSeasonName());
		today.setMonth(5);
		assertEquals("Spring", today.getSeasonName());
		today.setMonth(7);
		assertEquals("Summer", today.getSeasonName());
		today.setMonth(10);
		assertEquals("Autumn", today.getSeasonName());
	}

	@Test
	public void testGetMonthsLeft() throws DateException{
		assertEquals("February March April May June July August September October November December ", today.getMonthsLeft());
		today.setMonth(10);
		assertEquals("November December ", today.getMonthsLeft());
	}

	@Test
	public void testGetDaysLeftOfMonth() throws DateException{
		today.setDay(28);
		assertEquals("29/1/2017 30/1/2017 31/1/2017 ", today.getDaysLeftOfMonth());
	}

	@Test
	public void testGetMonthsSameDays() throws DateException{
		assertEquals("January March May July August October December ", today.getMonthsSameDays());
		today.setMonth(2);
		assertEquals("February ", today.getMonthsSameDays());
		today.setMonth(4);
		assertEquals("April June September November ", today.getMonthsSameDays());
	}

	@Test
	public void testDaysPast() throws DateException{
		assertEquals(0, today.daysPast());
		today.setDay(2);
		assertEquals(1, today.daysPast());
		today.setDay(1);
		today.setMonth(2);
		assertEquals(31, today.daysPast());
		today.setMonth(12);
		today.setDay(31);
		assertEquals(364, today.daysPast());
	}
	
	@Test
	public void testNumRandomTriesEqualDate(){
		assertFalse(0 == today.numRandomTriesEqualDate());		
	}

	@Test
	public void testDayOfWeek() throws DateException{
		assertEquals("Monday", today.dayOfWeek(1));
		today.setDay(2);
		assertEquals("Tuesday", today.dayOfWeek(1));
		today.setDay(1);
		today.setMonth(2);
		assertEquals("Thursday", today.dayOfWeek(1));
	}

	@Test
	public void testToString() throws DateException{
		assertEquals("1/1/2017", today.toString());
		today.setDay(25);
		today.setMonth(8);
		today.setYear(2017);
		assertEquals("25/8/2017", today.toString());
	}

}
