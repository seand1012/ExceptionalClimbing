//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    ExceptionalClimbingTester, tests ExceptionalClimbing
// Course:   CS 300 Fall 2021
//
// Author:   Sean DeGrazia
// Email:    sdegrazia@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         Michelle Jensen, expained catching general exceptions
// Online Sources:  none
//
///////////////////////////////////////////////////////////////////////////////
import java.util.zip.DataFormatException;

// This class shouldn't throw exceptions
// Plan for exceptions to be thrown but aren't, and for when you expect an exception to not be thrown but it is
// Check Pre-assignment quiz question 5

/**
 * Tests if ExceptionalClimbing works properly, and if it throws exceptions when
 * it doesn't
 * 
 * @author seandegrazia
 *
 */
public class ExceptionalClimbingTester {

	public static void main(String[] args) throws IllegalArgumentException, DataFormatException, Exception {
		// TODO Auto-generated method stub
		runAllTests();

	}
	

	/**
	 * 
	 * @return true if throws or doesn't throw exceptions properly, false if
	 *         otherwise
	 * @throws IllegalArgumentException if input is invalid or array is full
	 * @throws DataFormatException      if null elements or numSend is negative
	 * @throws Exception
	 */
	public static boolean testSendClimb() throws IllegalArgumentException, DataFormatException, Exception {
		String[] emptySend = new String[1];
		String[] partialSend = new String[4];
		String[] fullSend = new String[1]; // FULL SEND FULL SEND FULL SEND
		int numSend = 0;
		String grade = "V0";
		String badGrade = "whatever I want";
		partialSend[0] = grade;
		fullSend[0] = grade;

		// break up try blocks to individual tests\
		// test if exception message is correct, if so print exception

		// test if adding an invalid input
		try {
			ExceptionalClimbing.sendClimb(emptySend, numSend, badGrade);

		} catch (IllegalArgumentException e) {
			if (e.getMessage().equals(badGrade + " is not a valid grade")) {
				System.out.println(e.getMessage());
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		numSend = 1;

		// test if trying to add to a full array
		try {
			ExceptionalClimbing.sendClimb(fullSend, numSend, grade);
		} catch (IllegalArgumentException e) {
			if (e.getMessage().equals("cannot add new value to full length " + numSend + " array")) {
				System.out.println(e.getMessage());
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		// test if array has non consecutive null elements
		try {
			numSend = 0;
			partialSend[0] = null;
			partialSend[3] = "V0";
			ExceptionalClimbing.sendClimb(partialSend, numSend, grade);
		} catch (DataFormatException e) {
			if (e.getMessage().equals("invalid oversize array")) {
				System.out.println(e.getMessage());
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		return false;

	}

	/**
	 * 
	 * @return true if throws or doesn't throw exceptions properly, false if
	 *         otherwise
	 * @throws IllegalArgumentException if input is not valid
	 * @throws DataFormatException      if null elements or numFail is is negative
	 * @throws Exception                if bad exception
	 */
	public static boolean testFailClimb() throws IllegalArgumentException, DataFormatException, Exception {
		String[] emptyFail = new String[1];
		String[] partialFail = new String[4];
		String[] fullFail = new String[1];
		int numFail = 0;
		String grade = "V0";
		String badGrade = "whatever I want";
		partialFail[0] = grade;
		fullFail[0] = grade;

		try {
			ExceptionalClimbing.sendClimb(emptyFail, numFail, badGrade);
		} catch (IllegalArgumentException e) {
			if (e.getMessage().equals(badGrade + " is not a valid grade")) {
				System.out.println(e.getMessage());
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		numFail = 1;
		// test if trying to add to a full array
		try {
			ExceptionalClimbing.sendClimb(fullFail, numFail, grade);
		} catch (IllegalArgumentException e) {
			if (e.getMessage().equals("cannot add new value to full length " + numFail + " array")) {
				System.out.println(e.getMessage());
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		// test if array has non consecutive null elements
		try {
			numFail = 0;
			partialFail[0] = null;
			partialFail[3] = "V0";
			ExceptionalClimbing.sendClimb(partialFail, numFail, grade);
		} catch (DataFormatException e) {
			if (e.getMessage().equals("invalid oversize array")) {
				System.out.println(e.getMessage());
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		return false;
	}

	/**
	 * 
	 * @return true if proper exception thrown/not thrown, false if otherwise
	 * @throws RuntimeException
	 * @throws IllegalArgumentException
	 */
	public static boolean testGetStats() throws RuntimeException, IllegalArgumentException {
		int numSend = 0;
		int numFail = 0;
		int historyLength = 0;
		String grade = "V0";
		String[] emptySend = new String[1];
		String[] partialSend = new String[4];
		String[] fullSend = new String[1]; // FULL SEND FULL SEND FULL SEND
		String[] emptyFail = new String[1];
		String[] partialFail = new String[4];
		String[] fullFail = new String[1];

		fullSend[0] = grade;
		fullFail[0] = grade;
		partialSend[0] = grade;
		partialFail[0] = grade;

		// Trying to get stats from empty arrays
		try {
			ExceptionalClimbing.getStats(emptySend, numSend, emptyFail, numFail, historyLength);

		} catch (RuntimeException e) {
			if (e.getMessage().equals("no climbs provided")) {
				System.out.println(e.getMessage());
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		// historyLength is = 0
		numSend = 1;
		numFail = 1;
		try {
			ExceptionalClimbing.getStats(fullSend, numSend, fullFail, numFail, historyLength);
		} catch (IllegalArgumentException e) {
			if (e.getMessage().equals(historyLength + " is not a valid history length")) {
				System.out.println(e.getMessage());
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println("Bad exception!");
			return false;
		}

		// historyLength is < 0
		historyLength = -1;
		try {
			ExceptionalClimbing.getStats(fullSend, numSend, fullFail, numFail, historyLength);
		} catch (IllegalArgumentException e) {
			if (e.getMessage().equals(historyLength + " is not a valid history length")) {
				System.out.println(e.getMessage());
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		return false;
	}

	/**
	 * 
	 * @return true if it throws or doesn't throw an exception properly, false if
	 *         otherwise
	 * @throws RuntimeException
	 */
	public static boolean testGetHistogram() throws RuntimeException {
		int numSend = 0;
		int numFail = 0;
		String[] emptySend = new String[1];

		String[] emptyFail = new String[1];

		// Both arrays are empty
		try {
			ExceptionalClimbing.getHistogram(emptySend, numSend, emptyFail, numFail);
		} catch (RuntimeException e) {
			if (e.getMessage().equals("no climbs provided")) {
				System.out.println(e.getMessage());
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}

	/**
	 * 
	 * @return the value of all tests
	 * @throws IllegalArgumentException
	 * @throws DataFormatException
	 * @throws Exception
	 */
	public static boolean runAllTests() throws IllegalArgumentException, DataFormatException, Exception {
		return testSendClimb() && testFailClimb() && testGetStats() && testGetHistogram();
	}

}
