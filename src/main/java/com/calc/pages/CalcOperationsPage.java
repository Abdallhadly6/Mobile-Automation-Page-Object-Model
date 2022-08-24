package com.calc.pages;

import com.calc.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CalcOperationsPage extends Base {

    @AndroidFindBy ( id = "com.transsion.calculator:id/digit_9")
    private MobileElement digit9;

    @AndroidFindBy ( id = "com.transsion.calculator:id/op_mul")
    private MobileElement mul;

    @AndroidFindBy ( id = "com.transsion.calculator:id/digit_5")
    private MobileElement digit5;

    @AndroidFindBy ( id = "com.transsion.calculator:id/eq")
    private MobileElement eq;

    // if you need to sendkeys() you will add parameter to function to send data from test case not from here
    public void clickButtons(){
        digit9.click();
        mul.click();
        digit5.click();
        eq.click();
    }


}
