package ge.tbc.testautomation.pages.pestashop;

import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {
    Page page;
    public final FrameLocator shopFrame;
    public final Locator mailTo;
    public final Locator contactUsButton;
    public HomePage(Page page) {
        this.page = page;
        shopFrame =page.frameLocator("#framelive");
        mailTo = shopFrame.locator("a[href='mailto:demo@prestashop.com']");
        contactUsButton = shopFrame
                .locator("#_desktop_ps_contactinfo")
                .getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Contact us"));
    }
    public Frame shopFrame() {
        return page.frame("framelive");
    }

}
