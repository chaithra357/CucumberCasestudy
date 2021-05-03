package StudyDefintion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class StudySteps { 
	
	WebDriver driver;
	@Given("the user is registered user")
	public void the_user_is_registered_user() {
	    // Write code here that turns the phrase above into concrete actions
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://elearningm1.upskills.in/index.php/\r\n");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@When("Enter valid Name {string}")
	public void enter_valid_name(String string) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("login")).sendKeys(string);
	    
	}

	@When("Enter Valid Password {string}")
	public void enter_valid_password(String string) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("password")).sendKeys("chethu123");
	    
	}
	
	@When("Click on submit button")
	public void click_on_submit_button() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("form-login_submitAuth")).click();
	}
	@When("User Clicks on Compose")
	public void user_clicks_on_compose() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//a[@href='http://elearningm1.upskills.in/main/messages/new_message.php']")).click();
		 Thread.sleep(2000);
	}
	@When("user enters send to")
	public void user_enters_send_to() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		WebElement dd = driver.findElement(By.className("select2-search__field"));
		dd.sendKeys("disharoy");
	    Thread.sleep(2000);
	    dd.sendKeys(Keys.ENTER);
	    Thread.sleep(3000);

	}
	
	@When("user enters suubject")
	public void user_enters_suubject() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("compose_message_title")).sendKeys("Test mail");
	}
	
	@When("user enters message")
	public void user_enters_message() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		WebElement frm = driver.findElement(By.xpath("//*[@id='cke_1_contents']/iframe"));
	    Thread.sleep(2000);
	    driver.switchTo().frame(frm);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html//body[@contenteditable='true']")).sendKeys("Test Message chaithra");
	    driver.switchTo().defaultContent();
	    Thread.sleep(2000);
	}
	

	@When("user click on Send button")
	public void user_click_on_send_button() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("compose_message_compose")).click();
	}
	@Then("I should see message sent")
	public void i_should_see_message_sent() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		//String expected =driver.findElement(By.className("alert alert-success")).getText();
		String expected = driver.findElement(By.xpath("//*[@id=\"cm-content\"]/div/div[2]/div/div[contains(text(),'The message has been sent')]")).getText();
		System.out.println(expected);
        String actual="The message has been sent";
        Assert.assertTrue(expected.contains(actual));
	}



}

