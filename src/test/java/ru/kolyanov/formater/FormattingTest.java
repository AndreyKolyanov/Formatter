package ru.kolyanov.formater;

import org.junit.Test;
import ru.kolyanov.input.*;
import ru.kolyanov.output.FileWriter;
import ru.kolyanov.output.IWriter;
import ru.kolyanov.output.StringWriter;
import ru.kolyanov.output.WritingException;

import static junit.framework.Assert.assertEquals;

public class FormattingTest {

    IReader reader;
    IWriter writer;
    IFormatter formatter;


    public void formatting(String str, String actual) throws FormattingException, ReaderException{
        reader = new StringReader(str);
        writer = new StringWriter();
        formatter = new Formatter();
        formatter.format(reader, writer);
        assertEquals("fail", actual, writer.getLines());
    }
    @Test
    public void testFormatting() throws FormattingException, ReaderException {
        formatting("class Main {asd;asdaa;asd;{asdsd;dss;}}",
                "class Main {\n    asd;\n    asdaa;\n    asd;\n    {\n        asdsd;\n        dss;\n    }\n}\n");
    }

    @Test(expected = FormattingException.class)
    public void testFormatting2() throws FormattingException, ReaderException{
        formatting("class Main }{asd;asdaa;asd;{asdsd;dss;}}",
                "class Main {\n    asd;\n    asdaa;\n    asd;\n    {\n        asdsd;\n        dss;\n    }\n}\n");
    }

    @Test
    public void testFormatting3() throws FormattingException, ReaderException {
        formatting("{}", "{\n}\n");
    }

}
