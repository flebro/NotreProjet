package com.notreprojet.back.command;

import com.notreprojet.back.calculus.exception.CalculusException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Test class for {@link Switch}.
 */
public class SwitchTest {

	@Test
	public void getState() throws CalculusException {
		CalculationCommand calculusCommand = Mockito.mock(CalculationCommand.class);
		Mockito.when(calculusCommand.execute(0)).thenReturn(5F);
		Switch sswitch = new Switch();
		sswitch.storeAndExecute(calculusCommand);
		Assert.assertEquals(5F, sswitch.getState(), 0);
	}

	@Test
	public void getHistory() throws CalculusException {
		CalculationCommand calculusCommand = Mockito.mock(CalculationCommand.class);
		Mockito.when(calculusCommand.getMember()).thenReturn(5F);
		Switch sswitch = new Switch();
		sswitch.storeAndExecute(calculusCommand);
		Assert.assertEquals(5F, sswitch.getHistory().get(0).getMember(), 0);
	}

	@Test
	public void storeAndExecute() throws CalculusException {
		CalculationCommand calculusCommand = Mockito.mock(CalculationCommand.class);
		Mockito.when(calculusCommand.execute(0)).thenReturn(5F);
		Switch sswitch = new Switch();
		Assert.assertEquals(5F, sswitch.storeAndExecute(calculusCommand), 0);
	}

	@Test
	public void clear() throws CalculusException {
		CalculationCommand calculusCommand = Mockito.mock(CalculationCommand.class);
		Mockito.when(calculusCommand.getMember()).thenReturn(5F);
		Switch sswitch = new Switch();
		sswitch.storeAndExecute(calculusCommand);
		sswitch.clear();
		Assert.assertTrue(sswitch.getHistory().isEmpty());
		Assert.assertEquals(0F, sswitch.getState(), 0);
	}
}
