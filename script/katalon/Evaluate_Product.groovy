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

WebUI.callTestCase(findTestCase('Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('EvaluateProduct_Page/Page_Ti khon - FAHASA.COM/input__q'))

WebUI.setText(findTestObject('Object Repository/EvaluateProduct_Page/Page_Ti khon - FAHASA.COM/input__q'), 'Boardgame Thám Tử Lừng Danh Conan - Nàng Dâu Halloween: Thính')

WebUI.click(findTestObject('Object Repository/EvaluateProduct_Page/Page_Ti khon - FAHASA.COM/span__fhs_btn_default active button-search'))

WebUI.click(findTestObject('Object Repository/EvaluateProduct_Page/Page_Boardgame Thm T Lng Danh Conan - Nng D_90ad7f/a_Boardgame Thm T Lng Danh Conan - Nng Du H_a6c2d6'))

while (true) {
    WebUI.refresh()

    WebUI.delay(3)

    if (WebUI.verifyElementPresent(findTestObject('Object Repository/EvaluateProduct_Page/Page_Boardgame Thm T Lng Danh Conan - Nng D_ec3347/button_Vit nh gi'), 
        0)) {
        break
    }
}

WebUI.scrollToElement(findTestObject('EvaluateProduct_Page/Page_Boardgame Thm T Lng Danh Conan - Nng D_ec3347/button_Vit nh gi'), 
    5)

WebUI.click(findTestObject('Object Repository/EvaluateProduct_Page/Page_Boardgame Thm T Lng Danh Conan - Nng D_ec3347/button_Vit nh gi'))

WebUI.click(findTestObject('Object Repository/EvaluateProduct_Page/Page_Boardgame Thm T Lng Danh Conan - Nng D_ec3347/span_Vit nh gi sn phm_rating_item rating_it_07979a'))

WebUI.setText(findTestObject('Object Repository/EvaluateProduct_Page/Page_Boardgame Thm T Lng Danh Conan - Nng D_ec3347/input_Vit nh gi sn phm_nickname_field'), 
    name)

WebUI.click(findTestObject('Object Repository/EvaluateProduct_Page/Page_Boardgame Thm T Lng Danh Conan - Nng D_ec3347/input_Vit nh gi sn phm_nickname_field'))

WebUI.setText(findTestObject('Object Repository/EvaluateProduct_Page/Page_Boardgame Thm T Lng Danh Conan - Nng D_ec3347/textarea_Thng tin ny quan trng.Vui lng khng_eef181'), 
    comment)

WebUI.click(findTestObject('Object Repository/EvaluateProduct_Page/Page_Boardgame Thm T Lng Danh Conan - Nng D_ec3347/button_Gi nhn xt'))

if ((name.length() != 0) && (comment.length() >= 100)) {
    WebUI.verifyElementPresent(findTestObject('Object Repository/EvaluateProduct_Page/Page_Boardgame Thm T Lng Danh Conan - Nng D_ec3347/div_Nhn xt ca bn s c kim duyt bi Ngi qun tr_0a056c'), 
        0)
} else {
    if ((name.length() == 0) || (comment.length() == 0)) {
        WebUI.verifyElementPresent(findTestObject('Object Repository/EvaluateProduct_Page/Page_Boardgame Thm T Lng Danh Conan - Nng Du Halloween Thnh - FAHASA.COM/div_Thng tin ny quan trng.Vui lng khng  trng'), 
            0)
    } else if (comment.length() < 100) {
        WebUI.verifyElementPresent(findTestObject('Object Repository/EvaluateProduct_Page/Page_Boardgame Thm T Lng Danh Conan - Nng Du Halloween Thnh - FAHASA.COM/div_Vui lng in t nht 100 k t'), 
            0)
    }
}

WebUI.closeBrowser()

