package ge.tbc.testautomation.data;

public class Constants {

    public static final String BASE_URL = "https://practicesoftwaretesting.com/",
    REGISTER_URL = BASE_URL + "auth/register",

     LOGIN_URL_PATTERN = "**/auth/login",
     ACCOUNT_URL_PATTERN = "**/account",
     FAVORITES_URL_PATTERN = "**/account/favorites",
     HAND_TOOLS_URL_PATTERN = "**/category/hand-tools",
     PRODUCT_URL_PATTERN = "**/product/**",

     CATEGORY_HAMMER = "Hammer",
     CATEGORY_HAND_SAW = "Hand Saw",
     CATEGORY_WRENCH = "Wrench",

     THOR_HAMMER_PRODUCT_NAME = "Thor Hammer",
     SLEDGEHAMMER_PRODUCT_NAME = "Sledgehammer",
     THOR_HAMMER_CATEGORY_TAG = "Hammer",
     FILTER_BRAND_FORGEFLEX = "ForgeFlex Tools",
     FILTER_CATEGORY_HAND_TOOLS = "Hand Tools",
     ADD_TO_CART_TOAST_TEXT = "Product added to shopping cart.",
     PAYMENT_METHOD_CASH_ON_DELIVERY = "cash-on-delivery",
     ORDER_CONFIRMATION_PREFIX = "Thanks for your order!",
     DATA_LEAKED_PASSWORD = "Password123@",

     FIRST_NAME_REQUIRED_ERROR = "First name is required",
     LAST_NAME_REQUIRED_ERROR = "Last name is required",
     EMAIL_REQUIRED_ERROR = "Email is required",
     SUBJECT_REQUIRED_ERROR = "Subject is required",
     MESSAGE_REQUIRED_ERROR = "Message is required",
     SUBJECT_CUSTOMER_SERVICE = "customer-service",
     MESSAGE = "This is an automated end to end test message submitted through the contact form.",
     INVALID_CONTACT_FORM_FILE_PATH = "src/main/resources/contactFormFiles/Invalid.md",
     VALID_CONTACT_FORM_FILE_PATH = "src/main/resources/contactFormFiles/valid.txt",
     SUBMIT_CONFIRMATION = "Thanks for your message! We will contact you shortly.",
    ATTACHMENT_WRONG_TYPE_ERROR = "File should have a txt extension.",
    PESTASHOP_URL = "https://demo.prestashop.com/",
    MAIL_TO = "demo@prestashop.com"



                     ;

    ;
    private Constants() {
    }
}
