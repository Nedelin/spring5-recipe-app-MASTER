package guru.springframework.converters;

import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureCommandToUnitOfMeasureTest {

  private static final String DESCRIPTION = "description";
  private static final Long LONG_VALUE = new Long(1L);
  UnitOfMeasureCommandToUnitOfMeasure converter;

  @Before
  public void setUp() throws Exception {
    converter = new UnitOfMeasureCommandToUnitOfMeasure();
  }

  @Test
  public void testNullParameter() throws Exception {
    assertNull(converter.convert(null));
  }

  @Test
  public void testEmptyOject() throws Exception {
    assertNotNull(converter.convert(new UnitOfMeasureCommand()));
  }

  @Test
  public void convert() {
    UnitOfMeasureCommand command = new UnitOfMeasureCommand();
    command.setId(LONG_VALUE);
    command.setDescription(DESCRIPTION);

    UnitOfMeasure uom = converter.convert(command);
    assertNotNull(uom);
    assertEquals(LONG_VALUE, uom.getId());
    assertEquals(DESCRIPTION, uom.getDescription());
  }
}
