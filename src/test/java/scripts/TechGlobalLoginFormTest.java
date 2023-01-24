package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalBasePage;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalLoginFormPage;
import utilities.Waiter;

public class TechGlobalLoginFormTest extends TechGlobalBase {

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalLoginFormPage = new TechGlobalLoginFormPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Login Form");
    }

    @Test(priority = 1, description = "Validate Login Form Card")
    public void validateLoginFormCard(){
        Assert.assertEquals(techGlobalLoginFormPage.loginFormHeading.getText(), "Login Form");
        Assert.assertTrue(techGlobalLoginFormPage.userNameLabel.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.userNameInputBox.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.passwordLabel.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.passwordInputBox.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.loginButton.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.forgotPasswordLink.isDisplayed());
    }

    @Test(priority = 2, description = "Validate Valid Login")
    public void validateValidLogin(){
        techGlobalLoginFormPage.getValidUserNameAndValidPassword();
        Assert.assertEquals(techGlobalLoginFormPage.successLoginMessage.getText(), "You are logged in");
        Assert.assertTrue(techGlobalLoginFormPage.logoutButton.isDisplayed());
    }

    @Test(priority = 3, description = "Validate TechGlobal Login Form card valid login and then logout")
    public void validateValidLoginAndLogout(){
        techGlobalLoginFormPage.getValidUserNameAndValidPassword();
        techGlobalLoginFormPage.logoutButton.click();
    }

    @Test(priority = 4, description = "Validate TechGlobal Login Form card Forgot Password? Link and Reset Password page")
    public void validateForgotPasswordAndResetPassword(){
        techGlobalLoginFormPage.forgotPasswordLink.click();
        Assert.assertTrue(techGlobalLoginFormPage.resetPassword.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.resetPasswordMessage.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.emailInputBox.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.emailInputBox.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.submitButton.isDisplayed());
    }

    @Test(priority = 5, description = "Validate TechGlobal Login Form card Reset Password link")
    public void validateResetPasswordLink(){
        techGlobalLoginFormPage.forgotPasswordLink.click();
        techGlobalLoginFormPage.emailInputBox.sendKeys("beyzamizrak@gmail.com");
        techGlobalLoginFormPage.submitButton.click();
        Assert.assertEquals(techGlobalLoginFormPage.confirmationMessage.getText(), "A link to reset your password " +
                "has been sent to your email address.");
    }

    @Test(priority = 6, description = "Validate TechGlobal Login Form card invalid login with wrong username")
    public void validateInvalidLoginWithWrongUsername(){
        techGlobalLoginFormPage.getInvalidUserNameAndValidPassword();
        Assert.assertEquals(techGlobalLoginFormPage.errorMessage.getText(), "Invalid Username entered!");
    }

    @Test(priority = 7, description = "Validate TechGlobal Login Form card invalid login with wrong password")
    public void validateInvalidLoginWithWrongPassword(){
        techGlobalLoginFormPage.getValidUserNameAndInvalidPassword();
        Assert.assertEquals(techGlobalLoginFormPage.errorMessage.getText(), "Invalid Password entered!");
    }

    @Test(priority = 8, description = "Validate TechGlobal Login Form card invalid login with both wrong credentials")
    public void validateInvalidLoginWithBothWrongCredentials(){
        techGlobalLoginFormPage.getInvalidUserNameAndInvalidPassword();
        Assert.assertEquals(techGlobalLoginFormPage.errorMessage.getText(), "Invalid Username entered!");
    }








}
