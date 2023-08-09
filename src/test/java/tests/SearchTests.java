package tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

	@Test
	@Tag("android")
	void successfulSearchTest() {
		step("Type search", () -> {
			$(AppiumBy.accessibilityId("Search Wikipedia")).click();
			$(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
		});
		step("Verify content found", () ->
				$$(AppiumBy.id("org.wikipedia.alpha:id/search_container"))
						.shouldHave(sizeGreaterThan(0)));
	}

	@Test
	@Tag("android")
	void newsTest() {
		step("Check news in main page ", () -> {
			$(AppiumBy.id("org.wikipedia.alpha:id/view_card_header_title")).shouldHave(text("In the news"));
		});
	}
}
