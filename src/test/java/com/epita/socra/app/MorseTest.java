package com.epita.socra.app;

import com.epita.socra.app.tools.IOAdapter;
import com.epita.socra.app.tools.MorseConverter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MorseTest {

    @Test
    public void given10_Then1Dot9Underscore() {
        assertEquals(". _ _ _ _ _ _ _ _ _ ", MorseConverter.convertToMorse("10"));
    }

    @Test
    public void given9_Then4Underscore1Dot() {
        assertEquals("_ _ _ _ . ", MorseConverter.convertToMorse("9"));
    }

    @Test
    public void given0_Then5Underscore() {
        assertEquals("_ _ _ _ _ ", MorseConverter.convertToMorse("0"));
    }

    @Test
    public void givenInput9_Then4Underscore1DotPrint() {
        IOAdapter mock = mock(IOAdapter.class);

        when(mock.read()).thenReturn("9");
        App app = new App(mock);
        app.run();

        verify(mock).write("Enter number: ");
        verify(mock).write("_ _ _ _ . ");
    }


    @Test
    public void given1Dot9Underscore_Then10() {
        assertEquals(". _ _ _ _ _ _ _ _ _ ", MorseConverter.convertToMorse("10"));
    }

    @Test
    public void given4Underscore1Dot_Then9() {
        assertEquals("_ _ _ _ . ", MorseConverter.convertToMorse("9"));
    }

    @Test
    public void given5Underscore_Then0() {
        assertEquals("0", MorseConverter.convertFromMorse("_ _ _ _ _"));
    }

    @Test
    public void given4Underscore1DotPrint_ThenPrint9() {
        IOAdapter mock = mock(IOAdapter.class);

        when(mock.read()).thenReturn("_ _ _ _ .");
        App app = new App(mock);
        app.run();

        verify(mock).write("Enter number: ");
        verify(mock).write("9");
    }

    @Test
    public void CheckSum9InMorseplus15InArabic() {
        IOAdapter mock = mock(IOAdapter.class);

        when(mock.read()).thenReturn("_ _ _ _ .");
        App app = new App(mock);
        app.run();

        verify(mock).write("Enter number: ");
        verify(mock).write("9");
        when(mock.read()).thenReturn("15");
        verify(mock).write("Enter number: ");
        verify(mock).write("24");
        when(mock.read()).thenReturn("quit");
        verify(mock).write("Enter number: ");
    }
}
