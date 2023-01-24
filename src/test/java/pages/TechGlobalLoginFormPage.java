package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import scripts.TechGlobalBase;
import scripts.TechGlobalLoginFormTest;

public class TechGlobalLoginFormPage extends TechGlobalBasePage{

    public TechGlobalLoginFormPage(){
        super();
    }

    @FindBy(id = "main_heading")
    public WebElement loginFormHeading;

    @FindBy(xpath = "(//div[@class='LoginForm_form__b4o6J']//label)[1]")
    public WebElement userNameLabel;

    @FindBy(id = "username")
    public WebElement userNameInputBox;

    @FindBy(xpath = "(//div[@class='LoginForm_form__b4o6J']//label)[2]")
    public WebElement passwordLabel;

    @FindBy(id = "password")
    public WebElement passwordInputBox;

    @FindBy(id = "login_btn")
    public WebElement loginButton;

    @FindBy(id = "forgot-password")
    public WebElement forgotPasswordLink;

    @FindBy(id = "success_lgn")
    public WebElement successLoginMessage;

    @FindBy(id = "logout")
    public WebElement logoutButton;

    @FindBy(id = "sub_heading")
    public WebElement resetPassword;

    @FindBy(xpath = "//label")
    public WebElement resetPasswordMessage;

    @FindBy(id = "email")
    public WebElement emailInputBox;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "confirmation_message")
    public WebElement confirmationMessage;

    @FindBy(id = "error_message")
    public WebElement errorMessage;







    public void getValidUserNameAndValidPassword(){
        userNameInputBox.sendKeys("TechGlobal");
        passwordInputBox.sendKeys("Test1234");
        loginButton.click();
    }

    public void getInvalidUserNameAndValidPassword(){
        userNameInputBox.sendKeys("john");
        passwordInputBox.sendKeys("Test1234");
        loginButton.click();
    }

    public void getValidUserNameAndInvalidPassword(){
        userNameInputBox.sendKeys("TechGlobal");
        passwordInputBox.sendKeys("1234");
        loginButton.click();
    }

    public void getInvalidUserNameAndInvalidPassword(){
        userNameInputBox.sendKeys("john");
        passwordInputBox.sendKeys("1234");
        loginButton.click();
    }




}
