package com.marco.annotationssandbox.params;

public class ParserJson implements Parser {

    @Override
    public String parse(String source) {
        //simple conversion, it no matter
        return "{" + source + "}";
    }
}
