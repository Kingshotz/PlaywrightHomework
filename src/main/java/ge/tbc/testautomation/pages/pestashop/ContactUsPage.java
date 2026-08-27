package ge.tbc.testautomation.pages.pestashop;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ContactUsPage {

    Page page;
    public final Locator subjectSelect;
    public final Locator emailInput;
    public final Locator attachmentInput;
    public final Locator messageTextarea;
    public final Locator sendButton;
    public final Locator successAlert;
    public final FrameLocator shopFrame;


    public ContactUsPage(Page page) {
        this.page = page;
        this.shopFrame = page.frameLocator("#framelive");
        this.subjectSelect = shopFrame.getByLabel("Subject");
        this.emailInput = shopFrame.locator("#contact-us-email-input");
        this.attachmentInput = shopFrame.getByLabel("Attachment");
        this.messageTextarea = shopFrame.getByLabel("Message");
        this.sendButton = shopFrame.getByRole(AriaRole.BUTTON,
                new FrameLocator.GetByRoleOptions().setName("Send your message"));
        this.successAlert = shopFrame.locator(".alert-success");
    }
}
