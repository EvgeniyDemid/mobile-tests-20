package tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class UiElementTests extends TestBase {
	@Test
	@Tag("ios")
	void uiElements() {
		step("Type newest", () -> {
			$(AppiumBy.accessibilityId("Text Button")).click();
		});
		step("Verify title", () ->
				$(AppiumBy.name("Text Output")).shouldHave(text("Waiting for text input.")));
	}
}
