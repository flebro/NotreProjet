package com.notreprojet.back.command;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Test class for {@link SwitchCareTaker}.
 */
public class SwitchCareTakerTest {

	@Test
	public void add_getAll() {
		SwitchCareTaker switchCareTaker = new SwitchCareTaker();
		SwitchMemento switchMemento = Mockito.mock(SwitchMemento.class);
		switchCareTaker.add(switchMemento);
		Assert.assertEquals(switchMemento, switchCareTaker.getAll().get(0));
	}

}
