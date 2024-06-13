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
import com.kms.katalon.entity.global.GlobalVariableEntity

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

response = WS.sendRequest(findTestObject('REST API/Chaining API/GET 1 post'))

postid = GlobalVariable.POSTID

WS.comment('Old post ID from global variable : ' + postid)

//Loop for comments
for (int post_index = 0; post_index < 100; post_index++) {

new_postid = WS.getElementPropertyValue(response, '[' + post_index + '].id')

WS.comment('New post ID : ' + new_postid)

GlobalVariable.POSTID = new_postid

WS.comment('New post ID from global variable' + postid)

//Verification
response2 = WS.sendRequest(findTestObject('REST API/Chaining API/GET 1 post'))

//WS.verifyElementPropertyValue(response2, 'id', GlobalVariable.POSTID)

}

