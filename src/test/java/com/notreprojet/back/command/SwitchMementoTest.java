package com.notreprojet.back.command;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for {@link SwitchMemento}.
 */
public class SwitchMementoTest {

	@Test
	public void getCommands() {
		List<CalculationCommand> calculationCommands = new ArrayList<>();
		calculationCommands.add(Mockito.mock(CalculationCommand.class));
		SwitchMemento switchMemento = new SwitchMemento(calculationCommands);
		Assert.assertEquals(1, switchMemento.getCommands().size());
	}
}
