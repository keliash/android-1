/**
 *   ownCloud Android client application
 *
 *   @author purigarcia
 *   Copyright (C) 2016 ownCloud GmbH.
 *
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License version 2,
 *   as published by the Free Software Foundation.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.owncloud.android.test.ui.models;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

public class GmailSendMailView {
	final AndroidDriver driver;
	
	@CacheLookup
	@AndroidFindBy(uiAutomator = "new UiSelector().description(\"To\")")
	private AndroidElement toTextField;
	
	@CacheLookup
	@AndroidFindBy(name = "Subject")
	private AndroidElement subjectTextField;
	
	@CacheLookup
	@AndroidFindBy(uiAutomator = "new UiSelector().description(\"Send\")")
	private AndroidElement sendButton;
	
	public GmailSendMailView (AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void typeToEmailAdress (String email) {
		toTextField.sendKeys(email + "\n");
	}

	public void clickOnSendButton () {
		sendButton.click();
	}
		
	public void typeSubject (String subject) {
		subjectTextField.clear();
		subjectTextField.sendKeys(subject);
	}
}
