import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://www.fahasa.com/')

if (WebUI.verifyElementPresent(findTestObject('Page_Fahasa - Nh Sch Trc Tuyn Hng u Vit Nam_f1ab0c/advFahasa'), 30, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Page_Fahasa - Nh Sch Trc Tuyn Hng u Vit Nam_f1ab0c/closeAdv'))
}

WebUI.click(findTestObject('Page_Fahasa - Nh Sch Trc Tuyn Hng u Vit Nam_f1ab0c/div_Ti khon'))

WebUI.setText(findTestObject('Object Repository/Page_Khch hng ng nhp - FAHASA.COM/input_S in thoiEmail_youama-email'), phone)

WebUI.setText(findTestObject('Object Repository/Page_Khch hng ng nhp - FAHASA.COM/input_Mt khu_youama-password'), 
   password)

WebUI.click(findTestObject('Object Repository/Page_Khch hng ng nhp - FAHASA.COM/button_ng nhp'))

WebUI.verifyElementPresent(findTestObject('Page_Khch hng ng nhp - FAHASA.COM/UsernameAfterLogin'), 2)

WebUI.closeBrowser()

