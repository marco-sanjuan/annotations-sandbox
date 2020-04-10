package com.marco.annotationssandbox.params;

public class ParserHtml implements Parser {

    @Override
    public String parse(String source) {
        //simple conversion, it no matter
        return "<html>" + source + "</html>";
    }
}
