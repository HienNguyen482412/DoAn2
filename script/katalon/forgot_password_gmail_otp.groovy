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
import javax.mail.*
import javax.mail.internet.*
import javax.mail.search.SubjectTerm as SubjectTerm
import javax.mail.search.SearchTerm as SearchTerm
import javax.mail.Folder as Folder
import javax.mail.Session as Session
import java.util.Properties as Properties
import java.util.regex.Pattern as Pattern
import java.util.regex.Matcher as Matcher

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://www.fahasa.com/')
WebUI.enableSmartWait()

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Fahasa - Nh Sch Trc Tuyn Hng u Vit Nam_f1ab0c/advFahasa'), 
    30, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Object Repository/Page_Fahasa - Nh Sch Trc Tuyn Hng u Vit Nam_f1ab0c/closeAdv'))
}

WebUI.disableSmartWait()

WebUI.click(findTestObject('Object Repository/Page_Fahasa - Nh Sch Trc Tuyn Hng u Vit Nam_f1ab0c/div_Ti khon'))

WebUI.click(findTestObject('Object Repository/Forgot_Pasword_page/Page_Khch hng ng nhp - FAHASA.COM/span_Qun mt khu'))

WebUI.click(findTestObject('Forgot_Pasword_page/Page_Khch hng ng nhp - FAHASA.COM/input_S in thoiEmail_youama-email'))

WebUI.setText(findTestObject('Object Repository/Forgot_Pasword_page/Page_Khch hng ng nhp - FAHASA.COM/input_S in thoiEmail_youama-email'), 
    email)

if (email.length == 0) {
	WebUI.verifyElementPresent(findTestObject('Object Repository/Forgot_Pasword_page/Alert_Email_OTP/Page_Khch hng ng nhp - FAHASA.COM/div_ThongTinBoTrong'),
		0)
}
else {
	if (email == "minhhien040804@gmail.com") {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Forgot_Pasword_page/Alert_Email_OTP/Page_Khch hng ng nhp - FAHASA.COM/div_EmailKhongTonTai'),
			0)
	}
	String emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/
	if (emai !==~ emailPattern) {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Forgot_Pasword_page/Alert_Email_OTP/Page_Khch hng ng nhp - FAHASA.COM/div_EmailKhongHopLe'),
			0)
	}
}

WebUI.click(findTestObject('Object Repository/Forgot_Pasword_page/Page_Khch hng ng nhp - FAHASA.COM/span_Gi m OTP'))

String otpCode = ''

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Forgot_Pasword_page/Page_Khch hng ng nhp - FAHASA.COM/div_OTP  c gi'), 
    0)) {
    String host = 'imap.gmail.com'

    String gmail = 'hibarikyoya2k4@gmail.com'

    String password = 'kcuc mdep xotz riqe'

    Properties props = new Properties()

    props.put('mail.store.protocol', 'imaps')

    props.put('mail.imap.ssl.enable', 'true')

    Session session = Session.getDefaultInstance(props)

    Store store = session.getStore('imaps')

    store.connect(host, gmail, password)

    Folder inbox = store.getFolder('INBOX')

    inbox.open(Folder.READ_ONLY)

    SearchTerm searchTerm = new SubjectTerm('Fahasa.com send to your OTP code.')

    Message[] messages = inbox.search(searchTerm)

    if (messages.length > 0) {
        Message lastestMess = messages[(messages.length - 1)]

        String content = lastestMess.getContent().toString()

        Pattern pattern = Pattern.compile('<strong>\\s*(\\d{6})\\s*</strong>')

        Matcher matcher = pattern.matcher(content)

        if (matcher.find()) {
            String otp = matcher.group(1 // Lấy mã OTP từ nhóm đầu tiên
                )

            otpCode = otp
        } else {
            println('Không tìm thấy mã OTP.')
        }
    } else {
        println('Không tìm thấy email chứa OTP.')
    }
    
    inbox.close(false)

    store.close()
	if (type != "s") {
		otpCode = otp;
	}
	
	WebUI.click(findTestObject('Forgot_Pasword_page/Page_Khch hng ng nhp - FAHASA.COM/input_M xc nhn OTP_otpvalue'))
	
	WebUI.setText(findTestObject('Object Repository/Forgot_Pasword_page/Page_Khch hng ng nhp - FAHASA.COM/input_M xc nhn OTP_otpvalue'),
		otpCode.trim())
	
	if (otpCode == "511696") {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Forgot_Pasword_page/Alert_Email_OTP/Page_Khch hng ng nhp - FAHASA.COM/div_OTPHetHan'),
			0)
	}
	else if (otpCode.length <6) {
		
	}
	else if (otpCode.length >6) {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Forgot_Pasword_page/Alert_Email_OTP/Page_Khch hng ng nhp - FAHASA.COM/div_OTPKhongHopLe'),
			0)
	}
	else if (type == "#3") {
		WebUI.setText(findTestObject('Object Repository/Forgot_Pasword_page/Page_Khch hng ng nhp - FAHASA.COM/input_M xc nhn OTP_otpvalue'),
			"123456")
		WebUI.setText(findTestObject('Object Repository/Forgot_Pasword_page/Page_Khch hng ng nhp - FAHASA.COM/input_M xc nhn OTP_otpvalue'),
			"123457")
		WebUI.setText(findTestObject('Object Repository/Forgot_Pasword_page/Page_Khch hng ng nhp - FAHASA.COM/input_M xc nhn OTP_otpvalue'),
			"123458")
		WebUI.verifyElementPresent(findTestObject('Object Repository/Forgot_Pasword_page/Alert_Email_OTP/Page_Khch hng ng nhp - FAHASA.COM/div_OTPSaiNhieu'),
			0)
	}
	else if (type == "delay") {
		WebUI.delay(180)
		WebUI.setText(findTestObject('Object Repository/Forgot_Pasword_page/Page_Khch hng ng nhp - FAHASA.COM/input_M xc nhn OTP_otpvalue'),
			otpCode.trim())
	}
	else if (otpCode.length == 0) {
		WebUI.verifyElementNotClickable(findTestObject('Object Repository/Forgot_Pasword_page/Page_Khch hng ng nhp - FAHASA.COM/input_Mt khu_youama-password'))
	}
	if (WebUI.verifyElementPresent(findTestObject('Object Repository/Forgot_Pasword_page/Page_Khch hng ng nhp - FAHASA.COM/div_OTP hp l'),0)) {
		WebUI.click(findTestObject('Forgot_Pasword_page/Page_Khch hng ng nhp - FAHASA.COM/input_Mt khu_youama-password'))
		
		WebUI.setText(findTestObject('Object Repository/Forgot_Pasword_page/Page_Khch hng ng nhp - FAHASA.COM/input_Mt khu_youama-password'),
			'MinhHien0408@')
		
		WebUI.click(findTestObject('Object Repository/Forgot_Pasword_page/Page_Khch hng ng nhp - FAHASA.COM/button_Xc nhn'))
		
		WebUI.verifyElementPresent(findTestObject('Object Repository/Forgot_Pasword_page/Page_Ti khon - FAHASA.COM/span_Nguyn Minh Hin'),
			0)
		
	}
	
	
	
	WebUI.enableSmartWait()
	
}



