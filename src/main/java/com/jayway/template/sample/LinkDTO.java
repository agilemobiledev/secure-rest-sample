package com.jayway.template.sample;

/**
 * Created with IntelliJ IDEA.
 * User: magnuskivi
 * Date: 2013-02-08
 * Time: 15:43
 * To change this template use File | Settings | File Templates.
 */
public class LinkDTO {

    public String href;
    public String text;
    public String rel;


    public LinkDTO(String href, String text, String rel) {
        this.href = href;
        this.text = text;
        this.rel = rel;
    }


}
