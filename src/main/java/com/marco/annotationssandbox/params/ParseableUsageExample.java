package com.marco.annotationssandbox.params;

public class ParseableUsageExample {

    @Parseable(parser = ParserHtml.class)
    private String example1;

    @Parseable(parser = ParserJson.class)
    private String example2;

    public ParseableUsageExample(String example1, String example2) {
        this.example1 = example1;
        this.example2 = example2;
    }
}
