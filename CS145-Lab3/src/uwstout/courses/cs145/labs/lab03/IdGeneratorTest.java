package uwstout.courses.cs145.labs.lab03;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test for IdGenerator
 * 
 * Test for IdGenerator
 * 
 * @author SchultzRachel
 * @version 2022.10.26
 */
public class IdGeneratorTest {

	/**
	 * Test for the BasicIdFormatter
	 * 
	 * Takes in either PEON or MANAGER and returns the correct format. The lastId
	 * starts at 1000 and goes up by one.
	 */
	@Test
	public void testBasicCreateFormatter() {
		IdFormatter form1 = IdGenerator.createFormatter(SecurityType.PEON, "");
		String id1 = form1.createId("thx-1138");
		assertEquals("ZZZ-thx-USER-" + form1.getId(), id1);
		assertEquals("USER", form1.getGroup());
		assertEquals("ZZZ", form1.getPrefix());

		IdFormatter form2 = IdGenerator.createFormatter(SecurityType.PEON, "");
		String id2 = form2.createId("abc-1138");
		assertEquals("ZZZ-abc-USER-" + form2.getId(), id2);

		IdFormatter form3 = IdGenerator.createFormatter(SecurityType.MANAGER, "");
		String id3 = form3.createId("abc-1138");
		assertEquals("PHB-abc-USER-" + form3.getId(), id3);

	}

	/**
	 * Test for when the username is null for a BasicIdFormatter value.
	 * 
	 * Returns a null because the username DNE.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testBasicIdFormatterUsernameNull() {
		IdFormatter form = IdGenerator.createFormatter(SecurityType.PEON, "");
		String id = form.createId(null);
		assertEquals(null, id);
	}

	/**
	 * Test for when the username is less then 3 characters long for a
	 * BasicIdFormatter value.
	 * 
	 * Returns a null because the username needs to be at least 3 character long.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testBasicIdFormatterUsernameLess() {
		IdFormatter form4 = IdGenerator.createFormatter(SecurityType.PEON, "");
		String id4 = form4.createId("");
		assertEquals(null, id4);
	}

	/**
	 * Test for the BasicIdFormatter
	 * 
	 * Takes in either EXECUTIVE and returns the correct format. It takes in an
	 * added group string.
	 */
	@Test
	public void testExtendedCreateFormatter() {
		IdFormatter form1 = IdGenerator.createFormatter(SecurityType.EXECUTIVE, "Red");
		String id1 = form1.createId("imtheman");
		assertEquals("CEO-imtheman" + form1.getId() + "[Red]", id1);
		assertEquals("CEO", form1.getPrefix());
		assertEquals("Red", form1.getGroup());

		IdFormatter form2 = IdGenerator.createFormatter(SecurityType.EXECUTIVE, "Blue");
		String id2 = form2.createId("qwertyuio");
		assertEquals("CEO-qwertyuio" + form2.getId() + "[Blue]", id2);
	}

	/**
	 * Test for when the username is less then 8 characters long for a
	 * ExtendedIdFormatter value.
	 * 
	 * Returns a null because the username needs to be at least 8 character long.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExtendedIdFormatterUsernameLess() {
		IdFormatter form4 = IdGenerator.createFormatter(SecurityType.EXECUTIVE, "Blue");
		String id4 = form4.createId("");
		assertEquals(null, id4);
	}

	/**
	 * Test for when the group is less then 1 characters long for a
	 * ExtendedIdFormatter value.
	 * 
	 * Returns a null because the group needs to be at least 1 character long.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExtendedIdFormatterGroupNotValid() {
		IdFormatter form4 = IdGenerator.createFormatter(SecurityType.EXECUTIVE, "");
		String id4 = form4.createId("");
		assertEquals(null, id4);
	}

	/**
	 * Test for when the group is null for a ExtendedIdFormatter value.
	 * 
	 * Returns a null because the group needs to be at least 1 character long.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExtendedIdFormatterGroupNotValid3() {
		IdFormatter form4 = IdGenerator.createFormatter(SecurityType.EXECUTIVE, null);
		String id4 = form4.createId("qwer");
		assertEquals(null, id4);
	}

	/**
	 * Test to make sure the id is incrementing by one.
	 * 
	 * Makes sure the id is incrementing by one.
	 */
	@Test
	public void testIdGeneratorIncrementingByOne() {
		IdFormatter tmpForm = IdGenerator.createFormatter(SecurityType.EXECUTIVE, "Red");
		int firstId = tmpForm.getId();
		tmpForm = IdGenerator.createFormatter(SecurityType.EXECUTIVE, "Red");
		assertEquals(firstId + 1, tmpForm.getId());
		tmpForm = IdGenerator.createFormatter(SecurityType.EXECUTIVE, "Red");
		assertEquals(firstId + 2, tmpForm.getId());
	}
}
