package com.trendyolgo.Page;

import org.openqa.selenium.By;

public class FoodPage {
    private final By foodCards = By.xpath("//a[@class='group flex flex-col text-neutral-dark h-full rounded-8 overflow-hidden no-underline transition-shadow hover:shadow-card hover:text-current']");
    private final By foodRate = By.xpath(".//span)[4]");

}
